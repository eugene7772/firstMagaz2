package com.magaz2.firstMagaz2.controllers;


import com.magaz2.firstMagaz2.Entity.Brand;
import com.magaz2.firstMagaz2.Entity.Product;
import com.magaz2.firstMagaz2.globalData.GlobalCart;
import com.magaz2.firstMagaz2.service.BrandService;
import com.magaz2.firstMagaz2.service.ProductService;
import com.magaz2.firstMagaz2.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class ShopController {

    @Autowired
    ProductTypeService productTypeService;
    @Autowired
    ProductService productService;
    @Autowired
    BrandService brandService;

    @GetMapping("/shop")
    public String getShop(Model model){

        List<Product> prop = productService.getAllProducts();
        List<Product> products = new ArrayList<>();
        List<Product> products3 = new ArrayList<>();
        Integer size = prop.size();
        Integer halfsize = prop.size()/2;

        for(int i = 0;i<=halfsize;i++){
            products.add(prop.get(i));
        }
        for(int i = halfsize+1;i<size;i++){
            products3.add(prop.get(i));
        }

        model.addAttribute("productTypes", productTypeService.getAllproductType());
        model.addAttribute("products",products);
        model.addAttribute("products3",products3);
        model.addAttribute("cartCount", GlobalCart.cart.size());
        return "shop";
    }
    @GetMapping("/shop/search/{id}")
    public String ShopByProductType(Model model, @PathVariable Long id){
        Iterable<Brand> brands = brandService.getAllBrands();

        List<Product> propByProductTypeId = productService.getAllProductsByProductTypeId(id);
        List<Product> productsByProductTypeId = new ArrayList<>();
        List<Product> productsByProductTypeId3 = new ArrayList<>();
        Integer size = propByProductTypeId.size();
        Integer halfsize = propByProductTypeId.size()/2;
        if(size<2) {
            productsByProductTypeId = productService.getAllProductsByProductTypeId(id);
        }else {
        for(int i = 0;i<=halfsize;i++){
            productsByProductTypeId.add(propByProductTypeId.get(i));
        }
        for(int i = halfsize+1;i<size;i++){
            productsByProductTypeId3.add(propByProductTypeId.get(i));
        }}

        List<Product> propByBrandId = productService.getAllProductsByBrandId(id);
        List<Product> productsByBrandId = new ArrayList<>();
        List<Product> productsByBrandId4 = new ArrayList<>();
        Integer size2 = propByBrandId.size();
        Integer halfsize2 = propByBrandId.size()/2;
        if(size2<2){
            productsByBrandId = productService.getAllProductsByBrandId(id);
        }else {
        for(int i = 0;i<=halfsize2;i++){
            productsByBrandId.add(propByBrandId.get(i));
        }
        for(int i = halfsize2+1;i<size2;i++){
            productsByBrandId4.add(propByBrandId.get(i));
        }}
        model.addAttribute("brands", brands);
        model.addAttribute("products2",productsByBrandId);
        model.addAttribute("productTypes", productTypeService.getAllproductType());
        model.addAttribute("products", productsByProductTypeId);
        model.addAttribute("products3", productsByProductTypeId3);
        model.addAttribute("products4", productsByBrandId4);
        model.addAttribute("cartCount", GlobalCart.cart.size());
        return "shop";
    }
    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable Long id){
       model.addAttribute("product",productService.getProductById(id).get());
        model.addAttribute("cartCount", GlobalCart.cart.size());
        return "viewProduct";
    }
}






















