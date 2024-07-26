package com.freshGoodies.userstories.product.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "product", schema = "public")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Product name is required!")
    private String name;

    @Min(value = 0, message = "Price must be non-negative!")
    private double price;

    @Min(value = 0, message = "Weight must be non-negative!")
    private double weight;

    @NotBlank(message = "Product category is required!")
    private String category;

    @NotBlank(message = "imageUrl is required!")
    private String imageUrl;

    @Embedded
    @NotNull(message = "Metadata is required!")
    private Metadata metadata;
}
