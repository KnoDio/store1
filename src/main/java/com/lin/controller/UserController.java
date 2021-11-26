package com.lin.controller;

import com.lin.pojo.User;
import com.lin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    @RequestMapping(value = "/add")
    @ResponseBody
    public int addone(@RequestBody User user){
        User query1 = userService.query(user);
        if(query1!=null) return 0;
        System.out.println(user);
        userService.add(user);
        User query = userService.query(user);
        return query.getId();
    }
    @RequestMapping("/login")
    @ResponseBody
    public int querry(@RequestBody User user){
        System.out.println(user);
        User query = userService.query(user);
        System.out.println(query);
        if(query==null) return 0;
        return query.getId();

    }
    @RequestMapping("/edit")
    @ResponseBody
    public  String edit(@RequestBody User user){
        System.out.println(user);
        int update = userService.update(user);
        System.out.println(update);
        if(update>0)
        return "success";
        return  "fail";
    }
}
