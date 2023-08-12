package com.example.amazonclone.Service;

import com.example.amazonclone.Model.MerchantStock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service

public class MerchantStockService {


    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getAllMerchantStock(){
        return merchantStocks;
    }
    public void addMerchantStock(MerchantStock merchantStock){
        merchantStocks.add(merchantStock);
    }
    public boolean updateMerchantStock(Integer id,MerchantStock merchantStock){
        for (int i =0;i<merchantStocks.size();i++){
            if (merchantStocks.get(i).getMerchantId()==id){
                merchantStocks.set(i,merchantStock);
                return true;
            }
        }
        return false;
    }
    public boolean deleteMerchantStock(Integer id){
        for (int i=0;i<merchantStocks.size();i++){
            if(merchantStocks.get(i).getId()==id){
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean addMoreStock(Integer productID, Integer merchantId,Integer amount){
        for (MerchantStock merchantStock:merchantStocks){
            if(Objects.equals(merchantStock.getProductId(),productID)&& Objects.equals(merchantStock.getMerchantId(),merchantId)){
                merchantStock.setStock(merchantStock.getStock()+amount);
                return true;
            }
        }
        return false;
    }
}
