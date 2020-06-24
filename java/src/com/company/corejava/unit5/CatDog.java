package com.company.corejava.unit5;

/*
* 猫
* 成员变量:姓名,年龄,颜色
* 构造方法:无参,带参
* 成员方法:eat,playGame
* 狗
* 成员变量:姓名,年龄,颜色
* 构造方法:无参,带参
* 成员方法:eat,lookDoor
* */
public class CatDog {
    public static void main(String[] args){
        Cat c = new Cat();
        c.setName("小白");
        c.setAge(10);
        c.setColor("黄色");

        Dog d = new Dog("小黑",8,"黑色");
        System.out.println(d.getAge()+"---"+d.getName()+"---"+d.getColor());
    }
}

class Animal{
    private String name;
    private int age;
    private String color;

    public Animal(){}

    public Animal(String name,int age,String color){
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void eat(){
        System.out.println("吃东西");
    }
}

class Cat extends Animal{
    final int cc;
    public Cat(){
        this.cc = 20;
    }

    public Cat(String name,int age,String color){
        super(name,age,color);
        this.cc = 20;
    }

    public void playGame(){

        System.out.println("玩");
    }
}

class Dog extends Animal{
    public Dog(){}

    public Dog(String name,int age,String color){
        super(name,age,color);
    }

    public void lookDoor(){
        System.out.println("看门");
    }
}