package com.example.kaitaisinsyo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class UserApplicationService {

    @Autowired
    private MessageSource ms;

    public Map<String,Integer> getGenderMap(Locale locale){
        Map<String,Integer> genderMap = new LinkedHashMap<>();
        genderMap.put(ms.getMessage("male",null, locale),1);
        genderMap.put(ms.getMessage("female",null,locale),2);
        return genderMap;
    }
}
