package com.company.day3;

import java.io.Console;
import java.util.Scanner;
import static java.lang.System.*;


public class Operator {
    public static void main(String[] args){
        // 算数运算符+ - * / % ++ --
            // 2个整数相除只能得到整数,除法2边有一个浮点数结果就是浮点数
        out.println(2/1.3); // 结果是浮点数
        out.println(2/1); // 结果是整数

        out.println("-------------------------------");

            // + 的用法:A加法B正号C字符串连接符
        out.println(3+4); // 加法
        out.println(+3); // 正号
        out.println("3"+4); // 字符串连接符

        // 赋值运算符+= -= *= /= %=
        short s = 1;
        //s = s + 1; // 报错
        s += 1; // 扩展运算符隐藏了强制类型转换,这句代码等价于s = (s的数据类型)(s+1)
        out.println(s);

        // 比较运算符 == != >= <= > <

        // 逻辑运算符 && || !

        // 位运算符 & | ^ ~ << >> >>>
            // &:有0则0
            // |:有1则1
            // ^:相同为0,不同为1
            // ~:0变1,1变0,补求原
        int a = 3; // 二进制 00000000 00000000 00000000 00000011
        int b = 4; // 二进制 00000000 00000000 00000000 00000100
        out.println(3&4); //00000000 00000000 00000000 00000000
        out.println(3|4); //00000000 00000000 00000000 00000111
        out.println(3^4); //00000000 00000000 00000000 00000111
        out.println(~3);
        out.println(a^b^b);//3,一个数据对另一个数据异或2此,该数本身不变
        out.println(a^b^a);//4
            // 交换2个变量
        a = a^b;
        b = a^b;
        a = a^b;

        // 读取输入
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        int y = sc.nextInt();
//        boolean str = sc.hasNext();
////        out.println("你输入的数据是"+x);
//        int z = x>y?x:y;
//        out.println(str);

        Console con = System.console();
        if(con!=null){
            String str = con.readLine("UserName:");
            char[] passwd = con.readPassword("password:");
        }
    }
}
