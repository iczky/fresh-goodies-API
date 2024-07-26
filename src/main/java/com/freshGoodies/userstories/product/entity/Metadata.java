package com.freshGoodies.userstories.product.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Embeddable
@Table(name = "metadata", schema = "public")
public class Metadata {
    @NotBlank(message = "Unit is required!")
    private String unit;

    @Min(value = 100, message = "Increment default is 100")
    private int increment;

    @Min(value = 100, message = "Weight default is 100")
    private int weight;

    @Min(value = 0, message = "Mana mungkin calorie negative wei")
    private int calorie;

    @Min(value = 0, message = "Proteins jugaa")
    private int proteins;

    @Min(value = 0, message = "Fats must be non-negative")
    private double fats;

    @Min(value = 0, message = "Carbs must be non-negative")
    private int carbs;
}
