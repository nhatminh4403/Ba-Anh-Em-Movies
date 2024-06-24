package com.example.movietickets.demo.controller.admin;

import com.example.movietickets.demo.model.Blog;
import com.example.movietickets.demo.model.Film;
import com.example.movietickets.demo.service.BlogService;
import com.example.movietickets.demo.service.CommentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class BlogController {

    @Autowired
    private final BlogService blogService;

    @Autowired
    private final CommentService commentService;

    @GetMapping("/admin/blog")
    public String listBlog(Model model) {
        List<Blog> blog = blogService.getAllPosts();
        model.addAttribute("blog", blog);
        model.addAttribute("title", "Danh sách blog ");
        return "/admin/blog/blog-list";
    }

    @GetMapping("/blog")
    public String listBlogUser(Model model) {
        List<Blog> blog = blogService.getAllPosts();
        model.addAttribute("blog", blog);
        model.addAttribute("title", "Danh sách blog ");
        return "/blog/blog-list";
    }

    @GetMapping("/blog/blog-details/{id}")
    public String getBlogDetail(@PathVariable Long id, Model model) {
        Blog blog = blogService.findBlogWithId(id);
        model.addAttribute("blog", blog);
        model.addAttribute("categories", commentService.getAllCommentsByPostId(id));

        return "blog/blog-detail";
    }

    //add blog
    @GetMapping("/admin/blog/add")
    public String showAddBlog(Model model){
        model.addAttribute("blog", new Blog());
        return "/admin/blog/blog-add";
    }

    @PostMapping("/admin/blog/add")
    public String addBlog(@Valid @ModelAttribute Blog blog, BindingResult result, @RequestParam("poster") MultipartFile poster) throws IOException {

      /*  if (result.hasErrors()) {
            return "/admin/blog/blog-add";
        }*/

        if (!poster.isEmpty()) {
            try {
                String imageName = saveImageStatic(poster);
                blog.setPoster("/assets/img/adminblog/" + imageName); //lưu đường dẫn vào database
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        blog.setDate(LocalDateTime.now());

        blogService.create(blog);
        return "redirect:/admin/blog";
    }

    private String saveImageStatic(MultipartFile image) throws IOException {
        Path dirImages = Paths.get("target/classes/static/assets/img/adminblog");
        if (!Files.exists(dirImages)) {
            Files.createDirectories(dirImages);
        }

        String newFileName = UUID.randomUUID()+ "." + StringUtils.getFilenameExtension(image.getOriginalFilename());

        Path pathFileUpload = dirImages.resolve(newFileName);
        Files.copy(image.getInputStream(), pathFileUpload,
                StandardCopyOption.REPLACE_EXISTING);
        return newFileName;
    }

    // Hiển thị form sửa blog
    @GetMapping("/admin/blog/edit/{id}")
    public String showEditBlogForm(@PathVariable("id") Long id, Model model) {
        Blog blog = blogService.getPostById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ComboFood Id: " + id));
        model.addAttribute("blog", blog);
        return "/admin/blog/blog-update";
    }

    // Cập nhật thông tin combofood
    @PostMapping("/admin/blog/edit/{id}")
    public String updateBlog(@PathVariable("id") Long id, @Valid @ModelAttribute Blog blog, BindingResult result, @RequestParam("poster") MultipartFile poster, Model model) throws IOException {
       /* if (result.hasErrors()) {
            return "/admin/combofood/food-update";
        }*/

        Blog existingBlog = blogService.getPostById(id).orElseThrow(() -> new IllegalArgumentException("Invalid film Id:" + id));

        if (!poster.isEmpty()) {
            String imageName = saveImageStatic(poster);
            existingBlog.setPoster("/assets/img/comboFood/" + imageName);}


        existingBlog.setTitle(blog.getTitle());
        existingBlog.setContent(blog.getContent());
        existingBlog.setPoster(blog.getPoster());

        blogService.updateBlog(existingBlog);
        return "redirect:/admin/blog";
    }

    // Xóa blog
    @GetMapping("/admin/blog/delete/{id}")
    public String deleteBlog(@PathVariable("id") Long id) {
        blogService.deleteBlog(id);
        return "redirect:/admin/blog";
    }
}
