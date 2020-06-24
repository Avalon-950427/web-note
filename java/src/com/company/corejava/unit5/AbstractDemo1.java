package com.company.corejava.unit5;

public class AbstractDemo1 {
    public static void main(String[] args){
        Dog2 d = new Dog2("zz",22);
        d.setAge(23);
        d.setName("旺财");
        d.eat();
        System.out.println(d.getAge()+"------"+d.getName());
    }
}

abstract class Animal3{
    private String name;
    private int age;

    public Animal3(){}

    public Animal3(String name,int age){
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
}


class Cat2 extends Animal3{
    public Cat2(String name,int age){
        super(name,age);
    }

    public void eat(){
        System.out.println("猫吃鱼");
    }
}

class Dog2 extends Animal3{
    public Dog2(String name,int age){
        super(name,age);
    }

    public void eat(){
        System.out.println("狗吃肉");
    }
}