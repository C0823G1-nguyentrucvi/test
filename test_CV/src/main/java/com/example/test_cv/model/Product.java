package com.example.test_cv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private String description;
    private String image;
     @ManyToOne
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    private Size size;

     @ManyToOne
    @JoinColumn(name = "color_id" ,referencedColumnName = "id")
    private Color color;


}
