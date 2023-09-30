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
            PostLikesEntity postLikesEntity = postLikesRepository.findByPostIdAndUserId(post.id(), userId).orElse(null);
            PostLikes postLikesDto = null;
            if(postLikesEntity != null) {
                postLikesDto = postLikesEntity.toDto();
            }

            Tag tag = tagRepository.findById(post.id()).orElseThrow(() -> new RuntimeException("Tag not found.")).toDto();
            int total = post.positiveVotes() + post.neutralVotes() + post.negativeVotes();

            String positiveVotesPercentage = FORMATTER.format(((double) post.positiveVotes() / total) * 100);
            String neutralVotesPercentage = FORMATTER.format(((double) post.neutralVotes() / total) * 100);
            String negativeVotesPercentage = FORMATTER.format(((double) post.negativeVotes() / total) * 100);

            return new PostResponse(post.id(), postLikesDto, post.postType(), post.content(),
                    positiveVotesPercentage, negativeVotesPercentage, neutralVotesPercentage, tag.name(), post.videoPath());
        }).toList();

        return response;
    }
}
