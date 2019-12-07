package com.kin.test.springboot.test;

import java.io.File;

/**
 * @Author WinKinWong
 * @Description ces
 * @Date 2019/11/14 22:44
 **/
public class Test {
    public static void main(String[] args) {
        String test = new String ("");
        String url = "def";
        for(int i=0;i<99;i++){
            test+="<img src=\""+url+"\" alt=\"\" />";
        }
    url="ggg";
        System.out.println(url);
        System.out.println(test);
        File file = new File("E:\\Kin\\desktop\\DemoTest\\springbootUploadZip\\475d8af7-ab21-48bc-823a-345c58b7307a");
        boolean flag = delFile(file);
        System.out.println(flag);

    }
    static boolean delFile(File file) {
        if (!file.exists()) {
            return false;
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                delFile(f);
            }
        }
        return file.delete();
    }
}
