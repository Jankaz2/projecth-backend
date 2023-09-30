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
            int total = post.positiveVotes() + post.neutralVotes() + post.negativeVotes();

            return new PostResponse(post.id(), attitude, post.postType(), post.content(),
                    calculatePercentage(post.positiveVotes(), total), calculatePercentage(post.negativeVotes(), total), calculatePercentage(post.neutralVotes(), total),
                    tag.name(), post.videoPath());
        }).toList();

        return response;
    }

    private String calculatePercentage(int value, int total) {
       return FORMATTER.format(((double) value / total) * 100);
    }
}
