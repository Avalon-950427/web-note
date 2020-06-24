package com.company.corejava.unit5;

public class InterfaceDemo {
    public static void main(String[] args){
//        AnimalTrain a = new AnimalTrian(); 接口是抽象的,不能实例化
        AnimalTrain a = new Dog3();
        a.jump();
    }
}

interface AnimalTrain{
    public abstract void jump();
}

class Dog3 implements AnimalTrain{
    public void jump(){
        System.out.println("狗跳的很快");
    }
}
