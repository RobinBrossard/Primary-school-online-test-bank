package com.robin.sbdemo.lib;

import java.util.ArrayList;

public class CommonLib {

    //将整数分解为三进制数组
    private static ArrayList<Integer> getternary(int i) {
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

    private static String checkandreturn(int i) {
        int[] ilist = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        //用三进制0，1，2表示连接，加和减
        ArrayList<Integer> ical = getternary(i);

        //拼计算公式
        ArrayList<String> furmula = new ArrayList<>();
        String strTmp = String.valueOf(ilist[0]);
        for (int ipos = 0; ipos < ical.size(); ipos++) {
            //如果不是连接符0，而是计算符号1、2，则把strtmp压入公式
            if (ical.get(ipos) == 0) {
                strTmp = strTmp + ilist[ipos + 1];
            } else {
                furmula.add(strTmp);
                //翻译加减号
                if (ical.get(ipos) == 1) {
                    furmula.add(String.valueOf('+'));
                } else {
                    furmula.add(String.valueOf('-'));
                }
                strTmp = String.valueOf(ilist[ipos + 1]);
            }
        }
        furmula.add(strTmp);

        //已经有公式了，就要开始计算了
        int iresult = 0;
        for (int ipos = 0; ipos < furmula.size(); ipos++) {
            if (furmula.get(ipos).equals("+")) {
                if (iresult == 0) {
                    iresult = Integer.valueOf(furmula.get(ipos - 1));
                }
                iresult = iresult + Integer.valueOf(furmula.get(ipos + 1));
            }
            if (furmula.get(ipos).equals("-")) {
                if (iresult == 0) {
                    iresult = Integer.valueOf(furmula.get(ipos - 1));
                }
                iresult = iresult - Integer.valueOf(furmula.get(ipos + 1));
            }
        }

        if (iresult == 100) {
            String str = new String();
            for (int ipos = 0; ipos < furmula.size(); ipos++) {
                str = str + furmula.get(ipos);
            }
            return str+"=100"+"<br>";
        }
        return "";

    }

    public static String calc() {


        ArrayList<String> rStr = new ArrayList();
        int icount=1;

        for (int i = 0; i < Math.pow(3, 8); i++) {
            String str = checkandreturn(i);
            if (str != "") {
                rStr.add(icount+": "+str);
                icount++;
            }
        }
        return rStr.toString();

    }


}
