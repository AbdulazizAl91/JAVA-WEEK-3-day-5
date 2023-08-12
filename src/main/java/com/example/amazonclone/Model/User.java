package com.example.amazonclone.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotNull(message = "user id should not be empty")
    @Positive
    private Integer id;
    @NotEmpty(message = "username should not be empty")
    @Size(min = 6,max = 20,message = "username should have more than or equal 6 letters and less than or equal 20")
    private String username;
    @Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,16}$" )
    private String password;
    @Email
    private String email;
    @NotEmpty(message = "role should not empty")
    @Pattern(regexp = "Admin|Customer",message = "role should Admin or Customer")
    private String role;
    @NotEmpty(message ="user balance should not be empty")
    @PositiveOrZero

    private double balance;
}
