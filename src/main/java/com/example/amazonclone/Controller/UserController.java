package com.example.amazonclone.Controller;

import com.example.amazonclone.ApiResponse.ApiResponse;
import com.example.amazonclone.Model.User;
import com.example.amazonclone.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        return ResponseEntity.status(200).body(userService.getAllUser());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message =errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added"));
    }
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody @Valid User user,Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = userService.updateUser(id,user);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("User updated"));

        }
        return ResponseEntity.status(400).body(new ApiResponse("User not founded"));

    }
    @DeleteMapping("/delete/{id}")

    public ResponseEntity deleteUser(@PathVariable Integer id){
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("User deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("User not founded"));
    }
    @PutMapping("/bay-directly/{userId}/{productId}/{merchantId}")
    public ResponseEntity bayDirectly(@PathVariable Integer userId,@PathVariable Integer productId,@PathVariable Integer merchantId) throws Exception {




            try {
                boolean isBay = userService.bayDirectly(userId, productId, merchantId);


                if (isBay) {
                    return ResponseEntity.status(200).body(new ApiResponse("done successfully"));
                }
            }catch (Exception e1){
            return ResponseEntity.status(400).body(new ApiResponse(e1.getMessage()));}
            return ResponseEntity.status(400).body("try aging");




    }


}
