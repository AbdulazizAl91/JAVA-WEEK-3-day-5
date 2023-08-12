package com.example.amazonclone.Service;

import com.example.amazonclone.Model.MerchantStock;
import com.example.amazonclone.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
@RequiredArgsConstructor

public class UserService {
    private final MerchantStockService merchantStockService;
    private final ProductService productService;
    private final MerchantService merchantService;

    ArrayList<User> users = new ArrayList<>();



    public ArrayList<User> getAllUser(){
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }
    public boolean updateUser(Integer id,User user){
        for (int i =0;i<users.size();i++){
            if (users.get(i).getId()==id){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }
    public boolean deleteUser(Integer id){
        for (int i =0;i<users.size();i++){
            if (users.get(i).getId()==id){
                users.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean bayDirectly(Integer userId,Integer productId,Integer merchantId) throws Exception {
        boolean userFound = false;
        boolean productFound=false;
        boolean merchantFound=false;
        boolean hasStock = false;
        boolean hasBalance =false;
        int userIdCheck =0;
        double price=0;

        for (int i =0;i<users.size();i++){
            if (users.get(i).getId()==userId){
                userIdCheck=i;
                userFound=true;

            }else throw new Exception("user id uncorrected");


        }
        for (int i=0;i<productService.products.size();i++){
            if (productService.products.get(i).getId()==productId){
                price=productService.products.get(i).getPrice();
                productFound=true;
            }else throw new Exception("Prodoct id uncorrected");
        }
        for (int i=0;i<merchantService.merchants.size();i++){
            if (merchantService.merchants.get(i).getId()==merchantId){
                merchantFound=true;
            }else throw new Exception("merchant id uncorrected");
        }
        for (MerchantStock merchantStock:merchantStockService.merchantStocks){
            if (Objects.equals(merchantStock.getMerchantId(),merchantId) && Objects.equals(merchantStock.getProductId(),productId)&& merchantStock.getStock()>0){
                merchantStock.setStock(merchantStock.getStock()-1);
                hasStock =true;

            }throw new Exception("stock is  empty");
        }
        if (users.get(userIdCheck).getBalance()>=price){
            users.get(userIdCheck).setBalance(users.get(userIdCheck).getBalance()-price);

        }
        if (userFound ==true && productFound==true && merchantFound == true && hasStock ==true && hasBalance ==true){
            return true;
        }
        return false;

    }

}
