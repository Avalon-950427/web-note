package com.company.day5;

import java.util.Arrays;

public class Array {
    int a = 10;
    public static void main(String[] args){
        int[] arr = new int[3];
        System.out.println(arr[1]);

        int[] arr1 = {34,68,93,934,56};
//        System.out.print(getMax(arr1));

        int[] arr2 = Arrays.copyOf(arr1,arr1.length*2);

        arr2[1] = 67;
        System.out.println(arr1[1]);
        System.out.println(arr2[1]);
//        Arrays.sort()
//        Arrays.fill(arr2,1);
//        System.out.print(arr2[1]);
        int x = 6;
        int[][] arrr = new int[x][];
//        for(int i = 1;i<=x;i++){
//            arrr[i-1] = new int[i];
//            arrr[i-1][0] = 1;
//            arrr[i-1][i-1] = 1;
//        }
//        System.out.println(Arrays.toString(arrr[5]));
        for(int i = 1;i<=x;i++){
            arrr[i-1] = new int[i];
            arrr[i-1][0] = 1;
            arrr[i-1][i-1] = 1;
            for(int j = 1;j<i-1;j++){
                arrr[i-1][j] = arrr[i-2][j]+arrr[i-2][j-1];
            }
        }
        for(int i=0;i<x;i++){
            System.out.println(Arrays.toString(arrr[i]));
        }
//        System.out.println(Arrays.toString(arrr[5]));
    }

    public static int getMax(int[] a){
        int first = a[0];
        for(int i = 1;i<a.length;i++) {
            if (first < a[i]) {
                first = a[i];
            }
        }
        return first;
    }
    
}
