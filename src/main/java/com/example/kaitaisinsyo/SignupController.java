package com.example.kaitaisinsyo;

import com.example.kaitaisinsyo.form.SignupForm;
import com.example.kaitaisinsyo.service.UserApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {

    @Autowired
    private UserApplicationService service;

    @GetMapping("/signup")
    public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form){
        Map<String,Integer> genderMap = service.getGenderMap(locale);
        model.addAttribute("genderMap",genderMap);
        return "user/signup";
    }

    @PostMapping("/signup")
    public String postSignup(Model model, Locale locale , @ModelAttribute @Validated SignupForm form, BindingResult result)
    {
        log.info(form.toString());
        if(result.hasErrors()){
            return getSignup(model,locale,form);
        }
        return "redirect:/login";

    }

}
