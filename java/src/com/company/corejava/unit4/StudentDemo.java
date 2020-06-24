package com.company.corejava.unit4;

class Student {
    String name;
    int age;
    String address;

    public void study(){
        System.out.println("学习");
    }

    public void eat(){
        System.out.println("吃饭");
    }

    public void sleep(){
        System.out.println("睡觉");
    }
}

class StudentDemo{
    public static void main(String[] args){
        Student s = new Student();
        s.age =26;
        System.out.println(s.age);
        s.eat();

        StandardStudent ss = new StandardStudent(26,"zzz");
        ss.show();
    }

}

class StandardStudent{
    // 带构造方法,get,set,成员变量
    private String name;
    private int age;
    StandardStudent(){

    }

    StandardStudent(int age,String name){
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void show(){
        System.out.println(this.age+"----"+this.name);
    }
}