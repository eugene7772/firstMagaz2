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
        model.addAttribute("productTypes", productTypeService.getAllproductType());
        model.addAttribute("products",productService.getAllProducts());
        model.addAttribute("cartCount", GlobalCart.cart.size());
        return "shop";
    }
    @GetMapping("/shop/search/{id}")
    public String ShopByProductType(Model model, @PathVariable Long id){
        Iterable<Brand> brands = brandService.getAllBrands();
        model.addAttribute("brands", brands);
        model.addAttribute("products2",productService.getAllProductsByBrandId(id));
        model.addAttribute("productTypes", productTypeService.getAllproductType());
        model.addAttribute("products",productService.getAllProductsByProductTypeId(id));
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






















