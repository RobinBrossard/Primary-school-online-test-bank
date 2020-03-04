package com.robin.sbdemo.Controller;


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
        return calc();

    }

    private String checkandreturn(int i) {
        int[] ilist = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        ArrayList<Integer> ical = new ArrayList<Integer>();
        int x = i;
        if(x<3){
            ical.add(x);
        }
        while (x >= 3) {
            int div = 0;
            int mod = 0;
            div = x % 3; //取余
            mod = x / 3; //取整
            if (mod > 3) {
                ical.add(div);
            } else {
                ical.add(mod);
            }
            x = x / 3;
            if(x<3){
                ical.add(x);
            }
        }
        int ilen = ical.size();
        int zeronum;
        for (zeronum = 0; zeronum < 8 - ilen; zeronum++) {
            ical.add(0);
        }
        System.out.println(ical.toString());
        //用三进制0，1，2表示连接，加和减
        int itmpleft = 0;
        int itmpright = 0;
        for (int ipos = 0; ipos < 8; ipos++) {
            //取操作符
            int icalc = ical.get(7 - ipos);
            switch (icalc) {
                case 0: //连接
                    itmpleft = ilist[ipos] * 10 + ilist[ipos + 1];
                    ipos++;
                    break;

                case 1: //做加法

                case 2: //做减法
            }
        }


        return "";
    }

    private String calc() {

        ArrayList<String> rStr = new ArrayList();

        for (int i = 0; i < Math.pow(3, 8); i++) {
            String str = checkandreturn(i);
            if (str != "") {
                rStr.add(str);
            }
        }
        return rStr.toString();

    }


}
