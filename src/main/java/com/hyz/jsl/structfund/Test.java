package com.hyz.jsl.structfund;

import java.text.NumberFormat;
import java.text.ParseException;

public class Test {
    public static void main(String[] args) throws ParseException {
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        double f = (double) percentFormat.parse("-10.21%");
        System.out.println(f);
    }
}
