package com.company.corejava.unit5;

public class DuoTaiTest {
    public static void main(String[] args){
        Animal1 a = new Dog1();
        a.eat();
        System.out.println("--------------");
        Dog1 d = (Dog1)a;
        d.eat();
        d.lookDoor();
        System.out.println("---------------");
        a = new Cat1();
        a.eat();
//        a.playGame();报错
        System.out.println("-------------");
        Cat1 c = (Cat1)a;
        c.eat();
        c.playGame();
    }
}

class Animal1{
    public void eat() {
        System.out.println("吃饭");
    }
}

class Dog1 extends Animal1{
    public void eat(){
        System.out.println("狗吃肉");
    }

    public void lookDoor(){
        System.out.println("狗看门");
    }
}

class Cat1 extends Animal1{
    public void eat(){
        System.out.println("猫吃鱼");
    }

    public void playGame(){
        System.out.println("猫捉迷藏");
    }
}

