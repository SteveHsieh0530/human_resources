package com.steve.controller;


import com.steve.model.Guest;
import com.steve.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class GuestController {

    @Autowired
    private GuestService guestService;

    @RequestMapping("/goRegister")
    public String goRegister(){
        return "/user/register";
    }
    @RequestMapping("/register")
    public String register (String acc, String pass){
        System.out.println(acc);
        System.out.println(pass);
        guestService.register(acc, pass);
        return goLogin();
    }

    @RequestMapping("/goLogin")
    public String goLogin(){
        System.out.println("pass go login");
        return "/user/login";
    }

    @RequestMapping("/login")
    public String login(String acc, String pass, HttpSession session){
        Guest guest = guestService.Login(acc, pass);
        session.setAttribute("guest", guest);
        return "/user/showGuestMainPage";
    }


}
