package com.company.day5;

import java.util.Scanner;

public class Function {
    public static void main(String[] args){
        /*修饰符 返回值类型 方法名(参数类型 参数1, ...){
            函数体;
            return 返回值;
        }*/

//        方法功能相同,参数列表不同,java为了见名知意,可以用方法重载(与返回值类型无关)

//        System.out.println(sum(1,2));

//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        System.out.println(max(a,b));

//        int c = sc.nextInt();
//        int d = sc.nextInt();
//        int e = sc.nextInt();
//        System.out.println(isEqual(c,d));

//        System.out.println(threeMax(c,d,e));
//        print(8,9);
        chenfabiao(8);
    }

    // 求和方法
    public static double sum(double num1,double num2){
        return num1 + num2;
    }

    // 比较2个数据最大值
    public static int max(int a,int b){
        return Math.max(a, b);
    }

    // 比较2个数是否相等
    public static boolean isEqual(int a,int b){
        return a==b;
    }

    public static  boolean isEqual(byte a,byte b){
        return a==b;
    }

    public static  boolean isEqual(short a,short b){
        return a==b;
    }

    public static  boolean isEqual(long a,long b){
        return a==b;
    }

    // 比较3个数的最大值
    public static int threeMax(int a,int b,int c){
        return a>b?(Math.max(a, c)):(Math.max(b, c));
    }

    // 输出*****
    public static void print(int line,int column){
        // void类型的函数只能单独调用,不能赋值调用和输出调用
        for (int i = 0;i<line;i++){
            for(int j = 0;j<column;j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }

    // 根据键盘录入,输出nn乘法表
    public static void chenfabiao(int n){
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=i;j++){
                System.out.print(i+"*"+j+"="+i*j+"\t");
            }
            System.out.println();
        }
    }
}
