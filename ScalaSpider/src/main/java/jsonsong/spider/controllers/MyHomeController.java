package jsonsong.spider.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Map;


@RestController
public class MyHomeController {

    @RequestMapping(value = "/")
    public String index() {
        String port = env.getProperty("server.port");
        String isinit = env.getProperty("spider.isinit");
        return "service is run on " +port +" \n isinit:"+isinit +"version : 0.0.2.00005";
    }

    @RequestMapping(value = "/publish")
    public String publish() {
        InputStream in = null;
        try {
            Process pro = Runtime.getRuntime().exec(new String[]{
                   "myos", "build_spider"});

            pro.waitFor();
            in = pro.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in));
            String result = read.readLine();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Autowired
    private Environment env;


    @Value("${application.message:Hello World}")
    private String message = "Hello World";
}
