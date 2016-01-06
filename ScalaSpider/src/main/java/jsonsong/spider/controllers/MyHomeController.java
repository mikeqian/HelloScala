package jsonsong.spider.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;


@RestController
public class MyHomeController {

    @RequestMapping(value = "/")
    public String index() {
        String port = env.getProperty("server.port");
        String isinit = env.getProperty("spider.isinit");
        return "service is run on " +port +"\n isinit:"+isinit;
    }
    @Autowired
    private Environment env;


    @Value("${application.message:Hello World}")
    private String message = "Hello World";
}
