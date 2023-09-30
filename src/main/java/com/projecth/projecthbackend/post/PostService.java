package com.projecth.projecthbackend.post;

import com.projecth.projecthbackend.post.likes.PostLikes;
import com.projecth.projecthbackend.post.likes.PostLikesEntity;
import com.projecth.projecthbackend.post.likes.PostLikesRepository;
import com.projecth.projecthbackend.post.response.PostResponse;
import com.projecth.projecthbackend.tag.Tag;
import com.projecth.projecthbackend.tag.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private static final DecimalFormat FORMATTER = new DecimalFormat("#0.00");
    private final PostRepository postRepository;
    private final TagRepository tagRepository;
    private final PostLikesRepository postLikesRepository;

    public List<PostResponse> getAllPosts(Long politicianId, Long userId) {
        List<Post> postsList = postRepository.findAllByPoliticianEntityId(politicianId).stream().map(PostEntity::toDto).toList();
        List<PostResponse> response = postsList.stream().map(post -> {
            Attitude attitude = null;
            Optional<PostLikesEntity> postLikesEntity = postLikesRepository.findByPostIdAndUserId(post.id(), userId);

            if (postLikesEntity.isPresent()) {
                attitude = postLikesEntity.get().getAttitude();
            }

            Tag tag = tagRepository.findById(post.id()).orElseThrow(() -> new RuntimeException("Tag not found.")).toDto();
            PostVotesPercentage postVotesPercentage = countPostVotesPercentage(post);
            return new PostResponse(post.id(), attitude, post.content(),
                    postVotesPercentage.positive(), postVotesPercentage.negative(), postVotesPercentage.neutral(),
                    tag.name(), post.videoPath());
        }).toList();

        return response;
    }

    @Transactional
    public PostResponse rateThePost(Long postId, Long userId, Attitude attitude) {
        var postEntity = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post with this id [" + postId + "] does not exist"));
        var foundPostLikes = postLikesRepository.findByPostIdAndUserId(postId, userId);

        if (foundPostLikes.isPresent()) {
            return postLikeAlreadyExisted(postEntity, foundPostLikes.get(), attitude);
        }

        var postLikes = postLikesRepository.save(new PostLikesEntity(null, postId, userId, attitude, LocalDateTime.now()));
        var tag = tagRepository.findById(postId);

        var updatedPostEntity = postRepository.save(increaseVotes(postEntity, attitude));
        var votesPercentage = countPostVotesPercentage(updatedPostEntity.toDto());
        return new PostResponse(
                postEntity.getId(), postLikes.getAttitude(),
                postEntity.getContent(), votesPercentage.positive(), votesPercentage.negative(), votesPercentage.neutral(),
                tag.get().getName(), postEntity.getVideoPath()
        );
    }

    private PostResponse postLikeAlreadyExisted(PostEntity postEntity, PostLikesEntity postLikes, Attitude newAttitude) {
        var currentAttitude = postLikes.getAttitude();
        var tag = tagRepository.findById(postEntity.getId());

        decreaseVotes(postEntity, currentAttitude);
        increaseVotes(postEntity, newAttitude);

        postRepository.save(postEntity);
        postLikes.setAttitude(newAttitude);
        postLikesRepository.save(postLikes);

        var votesPercentage = countPostVotesPercentage(postEntity.toDto());
        return new PostResponse(postEntity.getId(), postLikes.getAttitude(),
                postEntity.getContent(), votesPercentage.positive(), votesPercentage.negative(), votesPercentage.neutral(),
                tag.get().getName(), postEntity.getVideoPath()
        );
    }

    private PostVotesPercentage countPostVotesPercentage(Post post) {
        var total = post.positiveVotes() + post.neutralVotes() + post.negativeVotes();
        var positiveVotesPercentage = FORMATTER.format(((double) post.positiveVotes() / total) * 100);
        var neutralVotesPercentage = FORMATTER.format(((double) post.neutralVotes() / total) * 100);
        var negativeVotesPercentage = FORMATTER.format(((double) post.negativeVotes() / total) * 100);
        return new PostVotesPercentage(positiveVotesPercentage, negativeVotesPercentage, neutralVotesPercentage);
    }
    private PostEntity decreaseVotes(PostEntity postEntity, Attitude attitude) {
        switch (attitude) {
            case POSITIVE -> postEntity.setPositiveVotes(postEntity.getPositiveVotes() - 1);
            case NEGATIVE -> postEntity.setNegativeVotes(postEntity.getNegativeVotes() - 1);
            case NEUTRAL -> postEntity.setNeutralVotes(postEntity.getNeutralVotes() - 1);
        }

        return postEntity;
    }

    private PostEntity increaseVotes(PostEntity postEntity, Attitude attitude) {
        switch (attitude) {
            case POSITIVE -> postEntity.setPositiveVotes(postEntity.getPositiveVotes() + 1);
            case NEGATIVE -> postEntity.setNegativeVotes(postEntity.getNegativeVotes() + 1);
            case NEUTRAL -> postEntity.setNegativeVotes(postEntity.getNeutralVotes() + 1);
        }

        return postEntity;
    }


    private String calculatePercentage(int value, int total) {
       return FORMATTER.format(((double) value / total) * 100);
    }
}
