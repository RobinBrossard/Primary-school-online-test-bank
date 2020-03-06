package com.robin.sbdemo.Controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 网站的主入口，处理网页跳转相关请求
 *
 * @author Robin Wu on 2020/3/5
 */
@RestController
@SpringBootApplication
public class sbdemoWebController {
    @GetMapping("/home")
    public String index(){
        return "index"; //当浏览器输入/index时，会返回 /templates/home.html页面
    }
}
