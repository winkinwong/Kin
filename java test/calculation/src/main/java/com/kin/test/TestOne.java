package com.kin.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName TestOne
 * @Deacription
 * 请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
 *
 * 给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。保证字符串中的字符为ASCII字符。字符串的长度小于等于3000
 * @Author WinKinWong
 * @Date 2019/12/26 15:34
 * @Version 1.0
 **/
public class TestOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符串：");
        String iniString = scanner.nextLine();
        System.out.println("您输入的字符："+iniString);
        System.out.println("是否有重复字符："+check(iniString));
    }
    public static boolean check(String iniString){
        int count = 0;
        if(iniString.length()>3000)return false;
        char[] chr = iniString.toCharArray();
           for(char word : chr){
               for (char match : chr){
                   if (word==match){
                       count++;
                   }
               }
           }
           if (count>iniString.length()) return false;
           return true;
    }
}
