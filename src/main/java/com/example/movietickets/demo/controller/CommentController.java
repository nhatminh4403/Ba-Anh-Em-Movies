package com.example.movietickets.demo.controller;


import com.example.movietickets.demo.model.ComboFood;
import com.example.movietickets.demo.model.Comment;
import com.example.movietickets.demo.model.Country;
import com.example.movietickets.demo.service.ComboFoodService;
import com.example.movietickets.demo.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/post/{postId}")
    public List<Comment> getAllCommentsByPostId(@PathVariable Long postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    // Hiển thị form thêm bình luận
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("comment", new Comment());
        return "comment/comment-add";
    }

    // Xử lý yêu cầu thêm bình luận
    @PostMapping("/add")
    public String addComment(@Valid Comment comment, BindingResult result) {
        if (result.hasErrors()) {
            return "comment/comment-add";
        }
        commentService.addComment(comment);
        return "redirect:/posts/" + comment.getBlog().getId();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

}
