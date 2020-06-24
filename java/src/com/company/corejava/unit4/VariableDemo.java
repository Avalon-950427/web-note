package com.company.corejava.unit4;

import java.util.Objects;

public class VariableDemo {
     /*成员变量和局部变量的区别
          A:位置不同
                成员变量:在类中方法外
                局部变量:在方法中或者在方法形参上
          B:内存位置不同
                成员变量:在堆内存
                局部变量:在栈内存
          C:声明周期不同
                成员变量:随着对象的创建而存在,随着对象的消失而消失
                局部变量:随着方法的调用而存在,随着方法的调用完毕而消失
          D:初始化值不同
                成员变量:有默认初始化值
                局部变量:没有默认值,必须初始化再使用
     */
    /*
    * private是一个权限修饰符,可以修饰成员变量和方法,被private修饰的成员只能在本类中访问
    * */
   public static void main(String[] args){
       Variable v = new Variable(null);
//    v.num; 不能访问
       v.methods();

   }
}

class Variable{
    private int num = 0;
    private String n;
    Variable(String nn){
        n = Objects.requireNonNull(n,"unknow");
        System.out.println(n);
    }

    public void methods(){
        System.out.println(num);
    }
}
