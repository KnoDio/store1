package com.lin.Utils;

import com.google.gson.Gson;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import java.util.HashMap;
import java.util.Map;

public class clientTest {
//
//        public static void main(String[] args) {
//        System.out.println(httpClientTest("053MOpll2pH9984q1lll2SpGPA1MOplc"));
//    }
    public String httpClientTest(String code) {
        HttpClient client = new HttpClient();
        PostMethod method = null;//post 方式   get 方式 GetMethod gMethod
        String result = "";
        try {
            String appid = "wx734556e1dc0587b4";
            String secret = "0ff90243282640a1c58a8ca101a17871";
            String grant_type = "authorization_code";
            String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
            String params = "?appid=" + appid + "&secret=" + secret + "&js_code="  + code + "&grant_type=" + grant_type;
            method = new PostMethod(requestUrl+params);
            method.setParameter("param", "test");//设置参数
            client.executeMethod(method);
            if (method.getStatusCode() == HttpStatus.SC_OK) {//响应成功
                result = method.getResponseBodyAsString();//调用返回结果
            } else {//不成功组装结果
                Map<String, Object> map = new HashMap<String, Object>();
                Gson gson = new Gson();
                map.put("success", false);
                result = gson.toJson(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        return result;
    }
}
