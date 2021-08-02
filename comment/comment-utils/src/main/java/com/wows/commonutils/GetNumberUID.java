package com.wows.commonutils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GetNumberUID {
    private static final Random one = new Random();

    private static Date date = new Date();


    public static String getId(){

        String strDateFormat = "yyyyMMddHHss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        String format = sdf.format(date).substring(3);
        StringBuffer sub = new StringBuffer(format);
        sub.insert(8,getOne());
        sub.insert(3,getOne());
        sub.insert(0,getOne());
        sub.insert(0,getOne());
        Integer number =(sub.charAt(9) - 39)%10 ;//这里参与运算的是数值的Char值，数值与char值相差48，+9的话则减去39就行
        sub.replace(9,10,number.toString());
        return sub+"";
    }


    //随机生成一个一位整数
    public static int getOne(){
        return one.nextInt(10);
    }

}
