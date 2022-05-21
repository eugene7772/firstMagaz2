package com.magaz2.firstMagaz2.controllers;

import com.magaz2.firstMagaz2.Entity.Delivery;
import com.magaz2.firstMagaz2.Entity.Order;
import com.magaz2.firstMagaz2.Entity.Product;
import com.magaz2.firstMagaz2.Entity.User;
import com.magaz2.firstMagaz2.globalData.GlobalCart;
import com.magaz2.firstMagaz2.globalData.OrderDTO;
import com.magaz2.firstMagaz2.service.EmployeeService;
import com.magaz2.firstMagaz2.service.OrderService;
import com.magaz2.firstMagaz2.service.OrderStatusService;
import com.magaz2.firstMagaz2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class PayController {
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderStatusService orderStatusService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/checkout/payPage")
    public String payAndGetOrder() {

        return "payPage";
    }

    @PostMapping("/checkout/payPage")
    public String payAndPostOrder(@ModelAttribute("orderDTO") OrderDTO orderDTO) {

        LocalDate date = LocalDate.now();

        Delivery delivery = new Delivery();
        delivery.setId(orderDTO.getId());
        delivery.setDate(date.plusDays(3).toString());
        delivery.setPrice((int) GlobalCart.cart.stream().mapToDouble(Product::getPrice).sum());
        delivery.setPointOfIssue(null);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByLogin(auth.getName()).get();

        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setDate(date.toString());
        order.setAmount((long) GlobalCart.cart.stream().mapToDouble(Product::getPrice).sum());
        order.setUser(user);
        order.setDelivery(delivery);
        order.setOrderStatus(orderStatusService.getOrderStatusById(1l).get());
        order.setEmployee(employeeService.getEmployeeById(1l).get());
        order.setAddress(orderDTO.getAddress());
        order.setPostCode(orderDTO.getPostCode());
        order.setAdditionalInformation(orderDTO.getAdditionalInformation());

        orderService.addOrder(order);

        GlobalCart.cart.clear();

        return "payPage";
    }

}
