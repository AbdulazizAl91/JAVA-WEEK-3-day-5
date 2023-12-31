package com.example.amazonclone.Service;

import com.example.amazonclone.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getAllProduct(){
        return products;
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public boolean updateProduct(Integer id,Product product){
        for (int i =0;i<products.size();i++){
            if (products.get(i).getId()==id){
                products.set(i,product);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(Integer id){
        for (int i=0;i<products.size();i++){
            if (products.get(i).getId()==id){
                products.remove(i);
                return true;
            }
        }
        return false;
    }
}
