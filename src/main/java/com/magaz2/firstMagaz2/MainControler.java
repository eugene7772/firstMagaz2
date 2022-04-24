package com.magaz2.firstMagaz2;

import com.magaz2.firstMagaz2.Entity.Product;
import com.magaz2.firstMagaz2.repository.ProductRepository;
import com.magaz2.firstMagaz2.Entity.ProductType;
import com.magaz2.firstMagaz2.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;


@Controller
public class MainControler {

    @Autowired
    ProductTypeRepository productTypeRepository;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<ProductType> types = productTypeRepository.findAll();

        Comparator<Product> comparator = Comparator.comparing(obj->obj.getId());

        List<Product> products = productRepository.findAll();
        Collections.sort(products,comparator);
        if(!products.isEmpty()) {
            if (products.size() >= 3) {
                products.subList(3, products.size()).clear();
            }
        }
        List<Product> products2 = productRepository.findAll();
        Collections.sort(products2,comparator);
            if (products.size() >= 6) {
                products2.subList(6, products2.size()).clear();
                products2.subList(0, 3).clear();
            }
        Map<ProductType, List<Product>> map = new HashMap<>();
        types.forEach(type->map.put(type, productRepository.findByProductType(type)));

        Integer quantity = 1;

        model.addAttribute("map",map);
        model.addAttribute("types",types);
        model.addAttribute("products", products);
        model.addAttribute("products2", products2);
        model.addAttribute("quantity",quantity);
        return "home";
    }
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("name", "Авторизация");
        return "login";
    }
}
