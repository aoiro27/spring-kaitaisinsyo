package com.example.kaitaisinsyo;

import com.example.kaitaisinsyo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public String getHello(){
        return "hello";
    }

    @PostMapping("/")
    public String postReq(@RequestParam("text1") String str, Model model){
        model.addAttribute("sample",str);
        return "hello/response";
    }

    @GetMapping("/db")
    public String getEmp(@RequestParam("text2") String id, Model model){
        model.addAttribute("employee",service.getEmployee(id));
        return "hello/db";
    }

}
