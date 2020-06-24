package com.company.corejava.unit5;
/*
* 设计员工类,员工需要高寒3个属性:姓名,工号,工资
* 经理也是员工,但有一个奖金属性
* 分析:
*   普通员工:
*       成员变量:姓名,工号,工资
*       成员方法:工作(重写)
*   经理类:
*       成员变量:姓名,工号,工资,奖金
*       成员方法:工作(重写)
*   员工类:(抽象)
*       成员变量:姓名,工号,工资
*       成员方法:工作(抽象)
* */
public class AbstractDemo2 {
    public static void main(String[] args){
        Employee e = new SummaryEmployee();
        e.setAge(22);
        e.setName("zzz");
        e.setSalary(5000);
        System.out.println(e.getAge()+"---"+e.getName()+"---"
                +e.getSalary());
        e.work();
        Manager m = new Manager("zcw",26,15000,20000);
        System.out.println(m.getAge()+"---"+m.getSalary()+"---"+m.getName()+
                "---"+m.getBonus());

    }
}

abstract class Employee{
    private String name;
    private int age;
    private int salary;

    public Employee(){}

    public Employee(String name,int age,int salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    abstract void work();
}

class SummaryEmployee extends Employee{
    public SummaryEmployee(){}

    public SummaryEmployee(String name,int age,int salary){
        super(name,age,salary);
    }

    public void work(){
        System.out.println("按照需求写代码");
    }
}

class Manager extends Employee{
    private int bonus;

    public Manager(){}

    public Manager(String name,int age,int salary,int bonus){
        super(name,age,salary);
        this.bonus=bonus;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public void setSalary(int salary) {
        super.setSalary(salary);
    }

    public void work(){
        System.out.println("跟客户谈需求");
    }
}