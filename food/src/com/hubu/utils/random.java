package com.hubu.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//产生指定位数的随机数
public class random {
    public static String genOrderId() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String orderId = df.format(date) + System.currentTimeMillis();
        return orderId;
    }
}
