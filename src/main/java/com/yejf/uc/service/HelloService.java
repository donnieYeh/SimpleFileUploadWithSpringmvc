package com.yejf.uc.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

@Service
@Validated
public class HelloService {
    public String hello(@Size(min = 4, max = 5) String test){
        return "hellohelloService";
    }
}
