package com.zrsedu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       int[] gem = {100,0,50,100};
       int[][] operations = {{0,2},{0,1},{3,0},{3,0}};
        for(int i = 0; i < operations.length; i++){
            int x = operations[i][0];  //第x位勇者
            int y = operations[i][1];  //第y位勇者
            gem[y] += (int)(gem[x]/2);
            gem[x] -=(int)(gem[x]/2);
        }

        int max = gem[0];
        int min = gem[0];
        for(int i = 1; i < gem.length; i++){
            if(gem[i] > max)
                max = gem[i];
            if(gem[i] < min)
                min = gem[i];
        }
//        return max - min;
        System.out.println(max - min);
    }


}
