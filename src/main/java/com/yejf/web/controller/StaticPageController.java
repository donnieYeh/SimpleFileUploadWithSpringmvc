package com.yejf.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticPageController {
    @GetMapping("/upload")
    public String upload(){
        return "/upload";
    }

}
