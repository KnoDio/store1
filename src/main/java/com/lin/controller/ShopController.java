package com.lin.controller;

import com.google.gson.Gson;
import com.lin.pojo.Shop;
import com.lin.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    @Qualifier("ShopServiceImpl")
    private ShopService shopService;
    String uploadFileName;
    @RequestMapping("/add")
    @ResponseBody
    public String addone(@RequestBody(required = false) Shop shop){
        System.out.println(shop);
        int i = shopService.addShop(shop);
        if(i>0)
        return "success";
        return "fail";
    }
    @RequestMapping("/search")
    @ResponseBody
    public  List<Shop> search(@RequestParam("name") String string){
        System.out.println(string.replace("\"",""));
        List<Shop> query = shopService.query(string.replace("\"",""));
        return query;
    }
    @RequestMapping("/all")
    @ResponseBody
    public List<Shop> all(){
        List<Shop> shops = shopService.queryAllShop();
        return shops;
    }
    @RequestMapping("/upload")
    @ResponseBody
    public String fileUpload(@RequestParam(value = "file",required = false) CommonsMultipartFile file , HttpServletRequest request) throws IOException {

        //获取文件名 : file.getOriginalFilename();
        uploadFileName = file.getOriginalFilename();
        //如果文件名为空，直接回到首页！
        if ("".equals(uploadFileName)){
            return "redirect:/index.jsp";
        }
        System.out.println("上传文件名 : "+uploadFileName);

        //上传路径保存设置
        String path = "C:\\photo";
        //如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址："+realPath);

        InputStream is = file.getInputStream(); //文件输入流
        OutputStream os = new FileOutputStream(new File(realPath,uploadFileName)); //文件输出流

        //读取写出
        int len=0;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
            os.flush();
        }
        os.close();
        is.close();

        return "http://8.130.175.220:8081/ph/"+uploadFileName;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int delete(@RequestParam("loadid") int loadid){
        int i = shopService.deleteShopById(loadid);
        return i;
    }
    @RequestMapping("/query")
    @ResponseBody
    public List<Shop> query(@RequestParam("id") int id){
        List<Shop> shops = shopService.queryByid(id);
        return shops;
    }
}
