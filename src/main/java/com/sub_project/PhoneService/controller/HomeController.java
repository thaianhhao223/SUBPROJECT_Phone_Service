package com.sub_project.PhoneService.controller;

import com.sub_project.PhoneService.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phones")
public class HomeController {
    @GetMapping("/")
    public String getListBook(){
        return "Get Books hehe";
    }
}
