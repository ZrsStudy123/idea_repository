package com.zrsedu.suanfa;

public class Main1 {
    public static void main(String[] args) {
        int[] nums = {1, 5 ,2, 4, 3, 6};
        int max_length = 1;
        int[] memo = new int[nums.length];  //该数组存储从哪个结点遍历的子序列长度，用于防止重复遍历
        for(int i = 0; i <nums.length; i++){
            max_length = max_length > (GetLen(nums, i, memo))?max_length:GetLen(nums, i, memo);
        }
        System.out.println("最长递增子序列长度: " +  max_length);
    }

    public static int GetLen(int[] nums, int i, int[] memo){
        if(memo[i] != 0){  //说明该位置已经遍历过了，防止重复遍历
            return memo[i];
        }
        int max_length = 1;
        if (i == nums.length -1){
            return 1;  //假如i 为数组的最后一个元素，那么往后找不到其子序列，那么就返回 1；
        }

        for(int j = i+1; j < nums.length; j++){
            if(nums[j] > nums[i]){
                //仔细体会这里的函数递归,最好画图理解
                max_length = max_length>(GetLen(nums, j, memo)+1)?max_length:(GetLen(nums, j, memo)+1);
            }
        }
        memo[i] = max_length;  //每次递归结束时都会将递归时的 i 位置开始遍历的子序列的长度存储起来
        return max_length;
    }
}


