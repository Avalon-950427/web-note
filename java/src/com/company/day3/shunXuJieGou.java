package com.company.day3;

/*分类:
    顺序结构
    选择结构,分支结构
    循环结构*/

public class shunXuJieGou {
    public static void main(String[] args){
        int x = 1,y = 1;

        if(x++==2 & ++y==2)
        {
            x =7;
        }
        System.out.println("x="+x+",y="+y);
//        System.out.println(10+=1);

        boolean b = true;

        if(b==false)
            System.out.println("a");
        else if(b)
            System.out.println("b");
        else if(!b)
            System.out.println("c");
        else
            System.out.println("d");
    }
}
