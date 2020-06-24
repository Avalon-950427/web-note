package com.company.corejava.unit4;

import java.util.Scanner;

public class ConstructDemo {
    /*
    * 构造方法:给对象的数据进行初始化
    *
    * 格式:方法名和类型一致
    *     没有返回值类型,连void都没有
    *
    * 如果我们没有给出构造方法,系统将自动提供一个无参构造方法,如果给了构造方法,系统将不提供默认构造方法
    * */

    /*
    * 静态变量和成员变量的区别
    * 所属不同:
    *       静态变量属于类,也叫类变量
    *       成员变量属于对象,也叫实例变量
    * 内存位置不同:
    *       静态变量储存在方法区的静态区
    *       成员变量存储在堆内存
    * 内存出现时间不同:
    *       静态变量随着类的加载而加载,随着类的消失而消失
    *       成员变量随着对象的创建而创建,随着对象的小时而消失
    * 调用不同:
    *       静态变量可以通过类名调用,也可以通过对象调用
    *       成员变量只能通过对象名调用
    *
    * static关键字注意事项:
    *       A:静态方法中没有this关键字
    *           因为静态是随着类的加载而加载,this是随着对象的创建而存在,静态比对象先存在
    *       B:静态方法只能访问静态成员变量和静态成员方法
    * */

    /*
    * main方法格式:
    * public:公共的,访问权限是最大的,因为main方法是被jvm调用的,所以权限要够大
    * static:静态的,不需要创建对象,通过类型就可以,方便jvm调用
    * void:方法的返回值是返回给调用者,而main方法是被jvm调用,把返回值返回给jvm没有意义
    * main:方法入口
    * String[] args:是在执行时接受键盘录入的命令行参数的
    * */

    /*
    * javadoc -d 目录 -author -version ArrayTool.java
    * */

    public static void main(String[] args){
        /*int num = (int)(Math.random()*100+1);
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n==num){
                System.out.println("猜中了");
                break;
            }else if(n < num){
                System.out.println("小了");
            }else{
                System.out.println("大了");
            }
        }*/
//        Demo d = new Demo();
//        d.fn();
        ConstructDemo cd = new ConstructDemo();
        System.out.println(cd);
        new Line();
    }
}

class Demo{

    public static void fn(){
        System.out.println("ll");
    }
}


class Line {


    public static String s = getString();

    private static String getString() {
        System.out.println("给静态变量赋值的静态方法执行：loading line");
        return "ss";
    }

    public static void test() {
        System.out.println("普通静态方法执行：loading line");
    }

    public Line() {
        System.out.println("构造方法执行：loading line");
    }

    {
        System.out.println("构造代码块执行");
    }

    static {
        System.out.println("静态代码块执行：loading line");
    }

}


