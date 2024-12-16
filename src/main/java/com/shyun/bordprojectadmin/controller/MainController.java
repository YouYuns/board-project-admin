package com.shyun.bordprojectadmin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class MainController {

    public String indexPage(){
        return "/index";
    }
}
