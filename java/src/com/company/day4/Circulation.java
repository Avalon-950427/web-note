package com.company.day4;

public class Circulation {
    public static void main(String[] args){
        // 在控制台输出1-10
//        for(int i = 0;i<10;i++){
//            System.out.println(i+1);
//        }

        // 求出1-10的数据和
//        int sum = 0;
//        for(int i = 1; i<=10;i++){
//            sum += i;
//        }
//        System.out.println(sum);

        // 求1-100之和
//        int sum = 0;
//        for (int i = 1;i<=100;i++){
//            sum += i;
//        }
//        System.out.println(sum);
        // 求1-100之间偶数和
//        int sum = 0;
//        for(int i = 1;i<=100;i++){
//            if(i%2==0){
//                sum+=i;
//            }
//        }
//        System.out.println(sum);
        // 求1-100之间奇数和
//        int sum = 0;
//        for(int i = 1;i<=100;i+=2){
//            sum+=i;
//        }
//        System.out.println(sum);
        // 求所有"水仙花数",水仙花数是一个三位数,其各位数字的立方之和等于概述本身,153=1*1*1+5*5*5_3*3*3
//        for (int i = 100;i<1000;i++){
//            int ge = i%10;
//            int shi = (i/10)%10;
//            int bai = (i/100)%10;
//            if(i == ge*ge*ge+shi*shi*shi+bai*bai*bai){
//                System.out.println(i);
//            }
//        }
//        int i = 100;
//        while(i<1000){
//            int ge = i%10;
//            int shi = (i/10)%10;
//            int bai = (i/100)%10;
//            if(i == ge*ge*ge+shi*shi*shi+bai*bai*bai){
//                System.out.println(i);
//            }
//            i++;
//        }
        // 珠峰8848米,一张纸0.01米,折多少次比珠峰高
//        double x = 0.01;
//        int count = 0;
//        while(x<=8848){
//            count++;
//            x*=2;
//            System.out.println(x);
//        }
//        System.out.println(count);

        /*输出
        *
        **
        ***
        ****
        ******/
//        for(int i = 1;i<=5;i++){
//            for(int j = 1;j<=i;j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }

        // 输出99乘法表
//        out:for(int i = 1;i<=9;i++){
//            for(int j = 1;j<=i;j++){
//                System.out.print(i+"*"+j+"="+i*j+" ");
//                if(j>2){
//                    continue out;
//                }
//            }
//            System.out.println();
//        }
        // 小芳妈妈每天给小芳2.5元,小芳都会存起来,每到第5天或者5的倍数的时候都回花6元钱,经过多少天可以存到100元
        double sum = 0;
        int day = 1;
        while(sum<100){
            sum+=2.5;
            if(day%5==0){
                sum-=6;
            }
            day++;
        }
        System.out.println(day+"sum="+sum);
    }
}
