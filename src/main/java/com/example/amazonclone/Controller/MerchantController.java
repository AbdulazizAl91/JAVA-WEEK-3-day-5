package com.example.amazonclone.Controller;

import com.example.amazonclone.ApiResponse.ApiResponse;
import com.example.amazonclone.Model.Merchant;
import com.example.amazonclone.Service.MerchantService;
import com.example.amazonclone.Service.MerchantStockService;
import com.example.amazonclone.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/amazon/merchant")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;
    private final ProductService productService;
    private final MerchantStockService merchantStockService;


    @GetMapping("get")
    public ResponseEntity getAllMerchant(){

        return ResponseEntity.status(200).body(merchantService.getAllMerchant());
    }
    @PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiResponse("Merchant added"));
    }
    @PutMapping("update/{id}")
    public ResponseEntity updateMerchant(@PathVariable Integer id,@RequestBody @Valid Merchant merchant,Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);

        }
        boolean isUpdated = merchantService.updateMerchant(id,merchant);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("Merchant updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Merchant not founded"));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable Integer id){
        boolean isDeleted = merchantService.deleteMerchant(id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Merchant deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Merchant not founded"));
    }
    @PutMapping("/add-more-stock/{productID}/{merchantId}/{amount}")
    public ResponseEntity addMoreStock(@PathVariable Integer productID,@PathVariable Integer merchantId  ,@PathVariable Integer amount){
        boolean isAdd = merchantStockService.addMoreStock(productID,merchantId,amount);
        if (isAdd){
            return ResponseEntity.status(200).body(new ApiResponse("stock added"));

        }
        return ResponseEntity.status(400).body(new ApiResponse("Product id or merchant id not founded"));
    }







}
