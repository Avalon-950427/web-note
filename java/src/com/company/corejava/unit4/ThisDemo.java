package com.company.corejava.unit4;

public class ThisDemo {
    /*
    * this:当前类的对象引用,即谁调用方法,那么该方法内部的this就代表谁
    * */
    public static void main(String[] args){
        This t = new This();
        t.setName("zzz");
        t.setAge(26);
        System.out.println(t.getName());
        System.out.println(t.getAge());
    }
}

class This{
    private int age;
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }
}