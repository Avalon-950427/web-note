package com.company.corejava.unit4;

public class RectangleDemo {
    // 变量的定义范围应该越小越好,除非它是描述类的属性可以将其定义为成员变量
    public static void main(String[] args){
        Rectangle r = new Rectangle();
        r.setHeight(2);
        r.setWidth(4);
        System.out.println(r.getZhouChang());
        System.out.println(r.getArea());
    }
}

class Rectangle{
    private int height;
    private int width;

    Rectangle(){

    }

    Rectangle(int width,int height){
        this.width = width;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getZhouChang(){
        return 2*(this.height+this.width);
    }

    public int getArea(){
        return this.width*this.height;
    }
}
