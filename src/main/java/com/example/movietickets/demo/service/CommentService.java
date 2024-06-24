package com.example.movietickets.demo.service;

import com.example.movietickets.demo.model.Comment;
import com.example.movietickets.demo.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;


@Service
@SessionScope
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getAllCommentsByPostId(Long BlogId) {
        return commentRepository.findByBlogId(BlogId);
    }


    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new IllegalStateException("Comment with ID " + id + " does not exist.");
        }
        commentRepository.deleteById(id);
    }
}
