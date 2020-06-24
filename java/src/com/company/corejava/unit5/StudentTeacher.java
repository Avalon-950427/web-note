package com.company.corejava.unit5;
/*
* 学生
* 成员变量:姓名,年龄
* 构造方法无参
* 成员方法:getXxx/setXxx
* */

/*
* 老师
* 成员变量:姓名,年龄
* 构造方法:无参
* 成员方法:setXxx/getXxx
* */
public class StudentTeacher {
    public static void main(String[] args){
        /*使用继承前
        Student s1 = new Student("zzz",20);
        Student s2 = new Student();
        s2.setName("zcw");
        s2.setAge(26);*/
    }
}

class Teacher{
    private String name;
    private int age;

    public Teacher(){

    }

    public Teacher(String name,int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Student{
    private String name;
    private int age;

    public Student(){

    }

    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}

