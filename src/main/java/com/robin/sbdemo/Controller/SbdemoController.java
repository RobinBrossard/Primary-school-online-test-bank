package com.robin.sbdemo.Controller;


import com.robin.sbdemo.lib.CommonLib;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@SpringBootApplication
public class SbdemoController {
    @RequestMapping("/")
    public String spdemo() {
        return CommonLib.calc();

    }



}
