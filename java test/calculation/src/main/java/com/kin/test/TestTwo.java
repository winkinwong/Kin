package com.kin.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName TestTwo
 * @Deacription
 *
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 * @Author WinKinWong
 * @Date 2019/12/26 17:04
 * @Version 1.0
 **/
public class TestTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入N：");
        int N = scanner.nextInt();
        if(N<0||N>30000)return;
        System.out.println();
        System.out.println("请输入M:");
        int M = scanner.nextInt();
        if (M<0||M>=5000)return;
        int[] scores = new int[N];
        for (int i = 0; i<N; i++){
            System.out.print("请输入第"+i+"个同学初始成绩:");
            scores[i] = scanner.nextInt();
            System.out.println();
        }
        for(int i = 0; i<M; i++){
            System.out.print("请输入C:");
            String C = scanner.nextLine();
            if (!(C.equals("Q"))&&!(C.equals("U")))return;
            System.out.println();
            System.out.print("请输入A:");
            int A = scanner.nextInt();
            System.out.println();
            System.out.println("请输入B:");
            int B = scanner.nextInt();
            switch (C){
                case "U": update(A,B,scores);
                case "Q": question(A,B,scores);
            }
        }

    }

    public static int question(int A, int B,int[] scores) {
            Arrays.sort(scores);
            return 0;
    }

    public static void update(int A, int B,int[] scores){

    }
}
