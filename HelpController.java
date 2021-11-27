package com.lin.controller;

import com.lin.pojo.Help;
import com.lin.service.HelpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/help")
public class HelpController {
    @Autowired
    @Qualifier("HelpServiceImpl")
    private HelpServiceImpl helpService;
    @RequestMapping("/add")
    @ResponseBody
    public int add(@RequestBody Help help){
        System.out.println(help);
        helpService.add(help);
        return 0;
    }
    @RequestMapping("/all")
    @ResponseBody
    public List<Help> all(){
        List<Help> query = helpService.query();
        System.out.println(query);
        return query;
    }
    @RequestMapping("/allres")
    @ResponseBody
    public  List<Help> all_link(@RequestParam("uid") int uid){
        return helpService.query_link(uid);
    }

    @RequestMapping("/search")
    @ResponseBody
    public  List<Help> query2(@RequestParam("name") String name){
        System.out.println(name.replace("\"",""));
        List<Help> query = helpService.query2(name.replace("\"",""));
        return query;
    }

    @RequestMapping("/query")
    @ResponseBody
    public  List<Help> query(@RequestParam("uid") int uid){
        System.out.println(helpService.queryById(uid));
        return  helpService.queryById(uid);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public  int  del(@RequestParam("id") int id)
    {
        return helpService.delete(id);
    }
}
