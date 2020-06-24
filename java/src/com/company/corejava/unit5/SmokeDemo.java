package com.company.corejava.unit5;
/*
* 老师和学生案例,加入抽烟的额外功能
* 老师:姓名,年龄,吃饭,睡觉
* 学生:姓名,年龄,吃饭,睡觉
* 提取公共类,人类:姓名,年龄,吃饭,睡觉
* 提供抽烟额外功能
* */
public class SmokeDemo {
    public static void main(String[] args){
        SmokingStudent ss = new SmokingStudent();
        ss.setAge(26);
        ss.setName("zzz");
        System.out.println(ss.getName()+"---"+ss.getAge());
        ss.eat();
        ss.sleep();
        ss.smoking();
        System.out.println(
                "--------------------------------------------------");
        SmokingStudent ss1 = new SmokingStudent("zz",25);

        System.out.println(ss1.getName()+"---"+ss1.getAge());
        ss1.eat();
        ss1.sleep();
        ss1.smoking();
        System.out.println(
                "--------------------------------------------------");
    }
}

abstract class Human{
    private String name;
    private int age;

    public Human(){}

    public Human(String name,int age){
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

    public abstract void eat();

    public abstract void sleep();
}

interface Smoke{
    public abstract void smoking();
}

class Student1 extends Human{
    public Student1(){}

    public Student1(String name,int age){
        super(name,age);
    }

    public void eat(){
        System.out.println("下课吃饭");
    }

    public void sleep(){
        System.out.println("放学睡觉");
    }
}

class Teacher1 extends Human{
    public Teacher1(){}

    public Teacher1(String name,int age){
        super(name,age);
    }

    public void eat(){
        System.out.println("上完课吃饭");
    }

    public void sleep(){
        System.out.println("上完课睡觉");
    }
}




class SmokingTeacher extends Teacher1 implements Smoke{
    public SmokingTeacher(){}

    public SmokingTeacher(String name,int age){
        super(name,age);
    }

    public void smoking(){
        System.out.println("老师抽烟真爽啊");
    }
}

class SmokingStudent extends Student1 implements Smoke{
    public SmokingStudent(){}

    public SmokingStudent(String name,int age){
        super(name,age);
    }

    public void smoking(){
        System.out.println("学生抽烟真爽啊");
    }
}