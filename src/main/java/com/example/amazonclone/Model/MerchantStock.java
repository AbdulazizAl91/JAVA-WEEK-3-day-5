package com.example.amazonclone.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotNull(message = "Merchant Stock id should not be empty")
    @Positive
    private Integer id;
    @NotNull(message = "product id  should not be empty")

    private Integer productId;
    @NotNull(message = "merchant id  should not be empty")

    private Integer merchantId;
    @NotNull(message = "stock should not be empty")
    @Min(10)
    @Positive
    private Integer stock;


}
