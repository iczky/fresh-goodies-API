package com.freshGoodies.userstories.product.model;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Setter
@Getter
public class Product {
    private Long id;
    private String name;
    private double price;
    private double weight;
    private String category;
    private String imageUrl;

    private Metadata metadata;
}
