package com.robin.sbdemo.Controller;


import com.robin.sbdemo.lib.CommonLib;
import com.robin.sbdemo.lib.ReadExcelTools;
import org.apache.poi.openxml4j.opc.internal.ContentType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.security.action.OpenFileInputStreamAction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController

public class SbdemoController {
    @RequestMapping("/b")
    public String spdemo() {
        return CommonLib.calc();
    }

    @RequestMapping("/a")
    public String readxls() throws IOException {

        File file=new File("d:/abc.xlsx");
        MultipartFile multipartFile=new MockMultipartFile(
                "abc.xlsx",
                "abc.xlsx",
                null,
                new FileInputStream(file)
        );
        String resstr = new String();
        List<String[]> a=ReadExcelTools.readExcel(multipartFile);
        for (String[] x:a ){
            for(String xx:x){
                resstr=resstr+xx+"<br>";
            }

        }


        return resstr;
    }

}
