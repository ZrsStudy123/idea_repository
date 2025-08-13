package com.zrsedu.suanfa;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //输入第一行
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        //定义一个代表不同情况的最优解的二维表格：使用二维数组来表示
        //这个二维数组代表什么一定要明白
        int[][] matrix = new int[N + 1][V + 1];
        //声明一个一维数组，存放物品
        thing[] things = new thing[N + 1];
        //接下来输入n行
        for (int i = 1; i < N + 1; i++) {
            thing thing = new thing();
            //输入体积
            thing.weight = scanner.nextInt();
            //输入价值
            thing.value = scanner.nextInt();
            things[i] = thing;
        }

        int Max_Value = Most_Value(things, matrix, V, N);
        System.out.println("最大价值为" + Max_Value);

    }

    //定义方法
    public static int Most_Value(thing[] things, int[][] matrix, int V, int N) {
        for (int i = 1; i < N + 1; i++) {   //先从只有物品 1件 选择开始分析
            for (int j = 1; j < V + 1; j++) {  //先从背包容量只有 1 开始分析
                if (things[i].weight > j) {  //当前物品不进行考虑
                    matrix[i][j] = matrix[i - 1][j];  //当前单元格的最优解继承其上一个单元格的最优解
                } else {  //当前物品纳入考虑范围，有两种选择：放入当前物品，不放入当前物品
                    int matrix01 = matrix[i - 1][j]; //不放入当前物品，相当于背包容量不变，可以选择的物品少一的情况
                    //放入该物品：情况变为：可选物品少一，背包容量减去放入物品的体积的情况
                    int matrix02 = matrix[i - 1][j - things[i].weight] + things[i].value;
                    matrix[i][j] = Math.max(matrix01, matrix02);  //选取这两种情况的较大值作为该单元的最优解
                }

            }

        }
        return matrix[N][V];  //返回这个表格的右下角的单元格即是 题目要求
    }
}

class thing {
    int weight;  //代表重量
    int value; //代表价值
}
/**
 * 思考： ----01
 * 0 - 1背包问题是每种物品只可以选择一次 的情况，所以
 * int matrix02 = matrix[i - 1][j - things[i].weight] + things[i].value;  //这里 i 要 -1，因为该物品已经被选中
 *
 * 完全背包问题：每种物品可以被多次使用，所以
 * int matrix02 = matrix[i][j - things[i].weight] + things[i].value; //这里的 i 不需要进行 -1 ，因为还可以进行选择
 *
 * 思考： -----02
 * 上述使用了常规的二维数组来存储每种情况，但实际上我们只会使用到前一行的数据，是否可以改进成一维数组来减小内存的损耗
 * 我的改进思路：每次 i 增加时都会将当前 i 行的数据进行覆盖
 * */