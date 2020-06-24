package com.company.corejava.unit4;

public class PrivateDemo {
    public static void main(String[] args){
        Student1 s1 = new Student1();
//        System.out.println(s1.name+'---'+s1.age);
        System.out.println(s1.getName());
        s1.setName("zzz");
        System.out.println(s1.getName());
        System.out.println(s1.getAge());
        s1.setAge(26);
        System.out.println(s1.getAge());
    }
}

class Student1{
    private String name;

    private int age;

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public void setAge(int a){
        age = a;
    }

    public int getAge(){
        return age;
    }
}