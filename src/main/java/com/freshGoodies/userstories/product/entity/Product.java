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
    @Column(name = "name_product", nullable = false)
    private String name;

    @Min(value = 0, message = "Price must be non-negative!")
    @Column(name = "price", nullable = false)
    private double price;

    @Min(value = 0, message = "Weight must be non-negative!")
    @Column(name = "weight", nullable = false)
    private double weight;

    @NotBlank(message = "Product category is required!")
    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @NotBlank(message = "imageUrl is required!")
    @Column(name = "imageUrl")
    private String imageUrl;

    @Embedded
    @NotNull(message = "Metadata is required!")
    private Metadata metadata;
}
