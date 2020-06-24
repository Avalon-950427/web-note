package com.company.corejava.unit5;

/**
 * 乒乓球运动员和篮球运动员
 * 乒乓球教练和篮球教练
 * 为了出国交流,跟乒乓球相关的人员都需要学习英语
 *
 * 具体:乒乓球运动员
 *      篮球运动员
 *      乒乓球教练
 *      篮球教练
 *
 *
 *  抽象:运动员(学)
 *      教练(教)
 *      人(姓名,年龄,吃饭,睡觉)
 *
 *  接口:学英语
 * */
public class Basketball {
    public static void main(String[] args){
        PingPangSM psm = new PingPangSM();
        psm.setName("zcw");
        psm.setAge(20);
        psm.eat();
        psm.learn();
        psm.speak();
        psm.sleep();
        System.out.println("---------------------");
        BasketSM bsm = new BasketSM("zz",26);
        bsm.learn();
        bsm.eat();
        bsm.sleep();
    }
}

interface SpeakEnglish{
    public abstract void speak();
}

abstract class Person2{
    private String name;
    private int age;

    public Person2(){}

    public Person2(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void eat();

    public void sleep(){
        System.out.println("人都要睡觉");
    }
}

abstract class Coach extends Person2{
    public Coach(){}

    public Coach(String name,int age){
        super(name,age);
    }

    public abstract void teach();
}

abstract class SportMan extends Person2{
    public SportMan(){}

    public SportMan(String name,int age){
        super(name,age);
    }

    public abstract void learn();
}

class PingPangSM extends SportMan implements SpeakEnglish{
    //pingPangSportMan
    public PingPangSM(){}

    public PingPangSM(String name,int age){
        super(name,age);
    }

    public void eat(){
        System.out.println("吃乒乓球");
    }

    public void learn(){
        System.out.println("学习打乒乓球");
    }

    public void speak(){
        System.out.println("说英语");
    }
}

class PingPangCoach extends Coach implements SpeakEnglish{
    //pingPangCoach

    public PingPangCoach(){}

    public PingPangCoach(String name,int age){
        super(name,age);
    }
    public void eat(){
        System.out.println("吃乒乓球");
    }

    public void teach(){
        System.out.println("教打乒乓球");
    }

    public void speak(){
        System.out.println("说英语");
    }
}

class BasketCoach extends Coach{
    //BasketCoach
    public BasketCoach(){}

    public BasketCoach(String name,int age){
        super(name,age);
    }

    public void eat(){
        System.out.println("吃篮球");
    }

    public void teach() {
        System.out.println("教打乒乓球");
    }
}

class BasketSM extends SportMan{
    public BasketSM(){}

    public BasketSM(String name,int age){
        super(name,age);
    }

    public void eat(){
        System.out.println("吃篮球");
    }

    public void learn(){
        System.out.println("学打篮球");
    }
}