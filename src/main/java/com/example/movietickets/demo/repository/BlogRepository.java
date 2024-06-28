package com.example.movietickets.demo.repository;


import com.example.movietickets.demo.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Query("SELECT b FROM Blog b WHERE b.title LIKE %:keyword%")
    List<Blog> searchBlogsByTitle(@Param("keyword") String keyword);
}
