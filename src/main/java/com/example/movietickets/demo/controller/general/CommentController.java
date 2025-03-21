package com.example.movietickets.demo.controller.general;

import com.example.movietickets.demo.model.*;
import com.example.movietickets.demo.service.BlogService;
import com.example.movietickets.demo.service.CommentService;
import com.example.movietickets.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("/blog")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private final BlogService blogService;

    @Autowired
    private final UserService userService;

    @PostMapping("/blog-details/{id}/comment")
    public String addComment(@PathVariable Long id, @Valid @ModelAttribute Comment comment,
                             BindingResult result, Model model, RedirectAttributes redirectAttributes) {



        // Lấy thông tin blog từ id
        Blog blog = blogService.findBlogWithId(id);

        // Kiểm tra và lấy thông tin người dùng đăng nhập hiện tại
        User user = userService.getCurrentUser();

        // Thiết lập thông tin cho comment
        Comment newComment = new Comment();
        newComment.setBlog(blog);
        newComment.setUser(user);
        newComment.setContent(comment.getContent());
        newComment.setDate(LocalDateTime.now());

        // Lưu comment vào cơ sở dữ liệu
        commentService.saveComment(newComment);

        // Điều hướng lại đến trang chi tiết blog
        return "redirect:/blog/blog-details/" + id;
    }


    @PostMapping("/blog-details/{id}/delete/{commentId}")
    public String deleteComment(@PathVariable("commentId") Long commentId, @PathVariable("id") Long blogId, RedirectAttributes redirectAttributes) {
        commentService.deleteComment(commentId);
        redirectAttributes.addFlashAttribute("message", "Comment đã được xóa thành công.");
        return "redirect:/blog/blog-details/" + blogId;
    }
}
