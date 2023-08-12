package com.example.amazonclone.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    @NotNull(message = "id Category of ca should not empty")
    @Positive
    private Integer id;
    @NotEmpty(message = "name of category should not be empty")
    @Size(min = 4,max = 30,message = "name of category should have more than or equal 4 letters and less than or equal 30")
    private String name;

}
