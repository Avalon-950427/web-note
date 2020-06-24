package com.company.corejava.unit4;

class Phone {
   /* 手机事物:
        属性:品牌,价格,颜色
        行为:打电话,发短信,玩游戏*/
   private String brand;
   private int price;
   private String color;

   public void setBrand(String brand){
       this.brand = brand;
   }

   public void setPrice(int price){
       this.price = price;
   }

   public void setColor(String color){
       this.color = color;
   }

   public String getBrand(){
       return this.brand;
   }

   public int getPrice(){
       return this.price;
   }

   public String getColor(){
       return this.color;
   }

   public void call(String name){
       System.out.println("打电话给"+name);
   }

   public void sendMessage(){
       System.out.println("发短信");
   }

   public void playGame(String game){
       System.out.println("玩"+game+"游戏");
   }
}

class PhoneTest{
    public static void main(String[] args){
        Phone p = new Phone();
        p.setBrand("华为");
        p.setColor("黑色");
        p.setPrice(5000);
//        System.out.println(p.brand+"---"+p.color+"---"+p.price);
        p.call("zzz");
        p.sendMessage();
        p.playGame("王者荣耀");
        Phone p1 = p;
        System.out.println(p+"---"+p1);
    }
}


