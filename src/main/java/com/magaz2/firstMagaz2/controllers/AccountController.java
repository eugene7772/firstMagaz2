package com.magaz2.firstMagaz2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/account")
    public String acc(Model model){

        return "account";
    }

}
