package com.example.amazonclone.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    @NotNull(message = "id of Product should not null")
    @Positive
    private Integer id;
    @NotEmpty(message = "name of Product should not empty")
    @Size(min = 4,max = 25,message = "name of Product should have more than or equal 4 letters and less than or equal 25")
    private String name;
    @NotEmpty(message = "price of Product should not by empty")
    @Positive
    private Double price;
    @NotNull(message = "category id of Product should not be empty")
    @Positive
    private Integer categoryID;
}
