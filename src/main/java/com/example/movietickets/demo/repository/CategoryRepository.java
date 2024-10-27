package com.example.movietickets.demo.repository;

import com.example.movietickets.demo.model.Category;
import com.example.movietickets.demo.model.ComboFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@EnableJpaRepositories(basePackageClasses = CategoryRepository.class)
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT cf FROM Category cf ORDER BY cf.id DESC")
    List<Category> findAllByOrderByIdDesc();
    Optional<Category> findCategoriesByNameContainingIgnoreCase(String categoryName);

    @Override
    List<Category> findAllById(Iterable<Long> ids);
}
