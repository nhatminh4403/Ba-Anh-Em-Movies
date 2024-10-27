package com.example.movietickets.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long id;

    @Column(name = "CATEGORY_NAME", nullable = false)
    @NotBlank(message = "Tên thể loại là bắt buộc")
    @Size(max = 100)
    private String name;

    @ManyToMany(mappedBy = "categories")
    @JsonManagedReference
    private List<Film> films = new ArrayList<>();

    @Override
    public String toString() {
        return "Category{id=" + id + ", name='" + name + "'}";
    }

}
