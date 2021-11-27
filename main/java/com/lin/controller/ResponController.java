package com.lin.controller;

import com.lin.pojo.Respon;
import com.lin.service.ResponServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/res")
public class ResponController {
    @Autowired
    @Qualifier("ResponServiceImpl")
    private ResponServiceImpl responService;
    @RequestMapping("/add")
    @ResponseBody
    public int add(@RequestBody Respon respon){
        System.out.println(respon);
        return responService.add(respon);
    }
}
