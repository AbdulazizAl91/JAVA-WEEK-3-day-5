package com.example.amazonclone.Service;

import com.example.amazonclone.Model.Merchant;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@RequiredArgsConstructor


public class MerchantService {

    private final MerchantStockService merchantStockService;
    private final ProductService productService;
    ArrayList<Merchant> merchants = new ArrayList<>();





    public ArrayList<Merchant> getAllMerchant(){
        return merchants;
    }
    public void addMerchant(Merchant merchant){
        merchants.add(merchant);
    }
    public boolean updateMerchant(Integer id,Merchant merchant){
        for (int i =0; i<merchants.size();i++){
            if (merchants.get(i).getId()==id){
                merchants.set(i,merchant);
                return true;
            }
        }
        return false;
    }
    public boolean deleteMerchant(Integer id){
        for (int i =0;i<merchants.size();i++){
            if (merchants.get(i).getId()==id){
                merchants.remove(i);
                return true;
            }
        }
        return false;
    }







}
