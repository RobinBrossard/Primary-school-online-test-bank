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

    private ArrayList<Integer> getternary(int i) {
        ArrayList<Integer> ical = new ArrayList<Integer>();
        int x = i;

        while (x >= 3) {
            int div = 0;
            int mod = 0;
            div = x % 3;
            mod = x / 3;
            if (mod > 0) {
                ical.add(div);
            } else {
                ical.add(mod);
            }
            x = x / 3;
        }

        ical.add(x);


        int ilen = ical.size();
        int zeronum;
        for (zeronum = 0; zeronum < 8 - ilen; zeronum++) {
            ical.add(0);
        }
        System.out.println(ical.toString());
        return ical;

    }

    private String checkandreturn(int i) {
        int[] ilist = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        //用三进制0，1，2表示连接，加和减
        ArrayList<Integer> ical = getternary(i);

        int itmp1 = 0;
        int itmp2 = 0;
        for (int ipos = 0; ipos < 8; ipos++) {
            int icalc = ical.get(7 - ipos);
            switch (icalc) {
                case 0: //连接
                    itmp1 = ilist[ipos] * 10 + ilist[ipos + 1];
                    ipos++;
                    break;

                case 1: //做加法

                case 2: //做减法
            }
        }
        return "";
    }

    private String calc() {
        getternary(6);

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
