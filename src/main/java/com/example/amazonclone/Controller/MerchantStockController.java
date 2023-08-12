package com.example.amazonclone.Controller;

import com.example.amazonclone.ApiResponse.ApiResponse;
import com.example.amazonclone.Model.MerchantStock;

import com.example.amazonclone.Service.MerchantService;
import com.example.amazonclone.Service.MerchantStockService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchantStock")
@RequiredArgsConstructor
public class MerchantStockController {
    private final MerchantStockService merchantStockService;
    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getAllMerchantStock(){

        return ResponseEntity.status(200).body(merchantStockService.getAllMerchantStock());
    }

    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body(new ApiResponse("Merchant Stock added"));

    }
    @PostMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@PathVariable Integer id,@RequestBody @Valid MerchantStock merchantStock,Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = merchantStockService.updateMerchantStock(id,merchantStock);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Merchant Stock updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Merchant Stock not founded"));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable Integer id){
        boolean isDeleted = merchantStockService.deleteMerchantStock(id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Merchant Stock deletd"));

        }
        return ResponseEntity.status(400).body(new ApiResponse("Merchant Stock not founded"));
    }



}
