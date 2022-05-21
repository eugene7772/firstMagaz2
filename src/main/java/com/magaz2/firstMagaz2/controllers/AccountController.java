package com.magaz2.firstMagaz2.controllers;

import com.magaz2.firstMagaz2.Entity.User;
import com.magaz2.firstMagaz2.globalData.UserDTO;
import com.magaz2.firstMagaz2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class AccountController {

    @Autowired
    UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/account")
    public String getAcc(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByLogin(auth.getName()).get();
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        if(user.getPassword()==null) {
            userDTO.setPassword(null);
        }else {
            userDTO.setPassword(user.getPassword());
        }
        userDTO.setPhoneClient(user.getPhoneClient());
        userDTO.setNameState(user.getNameState());

        model.addAttribute("userDTO",userDTO);

        return "account";
    }

    @PostMapping("/account")
    public String addDataUser(@ModelAttribute("userDTO") UserDTO userDTO) throws IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByLogin(auth.getName()).get();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setPhoneClient(userDTO.getPhoneClient());
        user.setNameState(userDTO.getNameState());

        userService.saveDataUser(user);

        return "account";
    }


}
