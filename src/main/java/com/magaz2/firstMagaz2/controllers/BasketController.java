package com.magaz2.firstMagaz2.controllers;

import com.magaz2.firstMagaz2.Entity.Product;
import com.magaz2.firstMagaz2.Entity.User;
import com.magaz2.firstMagaz2.globalData.GlobalCart;
import com.magaz2.firstMagaz2.globalData.OrderDTO;
import com.magaz2.firstMagaz2.service.ProductService;
import com.magaz2.firstMagaz2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BasketController {

    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Long id) {
        GlobalCart.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }
    @GetMapping("/cart")
    public String cartGet(Model model){
        model.addAttribute("cartCount", GlobalCart.cart.size());
        model.addAttribute("total",GlobalCart.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart",GlobalCart.cart);
        return "cart";
    }
    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index){
        GlobalCart.cart.remove(index);
        return "redirect:/cart";
    }
    @GetMapping("/checkout")
    public String checkout(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByLogin(auth.getName()).get();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String phoneClient = user.getPhoneClient();
        String email = user.getEmail();
        String town = user.getNameState();

        model.addAttribute("orderDTO",new OrderDTO());
        model.addAttribute("town",town);
        model.addAttribute("firstName",firstName);
        model.addAttribute("lastName",lastName);
        model.addAttribute("phoneClient",phoneClient);
        model.addAttribute("email",email);
        model.addAttribute("total",GlobalCart.cart.stream().mapToDouble(Product::getPrice).sum());

        return "checkout";
    }
}
