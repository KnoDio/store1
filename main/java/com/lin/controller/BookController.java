package com.lin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lin.Utils.clientTest;
import com.lin.pojo.Books;
import com.lin.pojo.Testuser;
import com.lin.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/test21")
    @ResponseBody
    public String t1(){
//        JsonObject  jsonObject;
//        jsonObject = (JsonObject) new JsonParser().parse(code).getAsJsonObject();
//        String code1 = jsonObject.get("code").getAsString();
//        System.out.println(code1);
//        String s = new clientTest().httpClientTest(code1);
//        System.out.println(s);
        return "index";
    }
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        System.out.println(list);
        return "allBook";
    }
    @RequestMapping(value = "/id")
    @ResponseBody
    public String queryone(@RequestParam("id") int id, @RequestParam("name") String name) throws JsonProcessingException {
        System.out.println(id);
        return "dcasxa";
    }
}