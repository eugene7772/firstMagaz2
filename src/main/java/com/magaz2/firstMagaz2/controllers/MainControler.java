package com.magaz2.firstMagaz2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
public class MainControler {

    @Autowired
    ProductTypeRepository productTypeRepository;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<ProductType> types = productTypeRepository.findAll();

        List<Product> products = productRepository.findAll();
        products.subList(3,products.size()).clear();

        List<Product> products2 = productRepository.findAll();
        products2.subList(6,products2.size()).clear();
        products2.subList(0,3).clear();

        Map<ProductType, List<Product>> map = new HashMap<>();
        types.forEach(type->map.put(type, productRepository.findByProductType(type)));
        model.addAttribute("map",map);
        model.addAttribute("types",types);
        model.addAttribute("products", products);
        model.addAttribute("products2", products2);
        return "home";
    }

    @GetMapping("/basket")
    public String basket(Model model) {
        model.addAttribute("name", "Корзина");
        return "basket";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("name", "Авторизация");
        return "login";
    }
}
