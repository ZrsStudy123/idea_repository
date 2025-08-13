package com.zrsedu.suanfa;

import java.util.Scanner;

public class hou_zhui_biao_da_shi_qiuzhi {
    public static void main(String[] args) {
        System.out.println("请输入要计算的后缀表达式");
        Scanner scanner = new Scanner(System.in);
        String num_str = scanner.nextLine();  //遇到第一个空白字符时就会返回，建议读取一行
        int result = jisuan(num_str);
        System.out.println("后缀表达式结果为:" + result);
    }

    //入栈
    public static boolean PushStack(Num_Stack stack, int x) {
        if ((stack.top + 1) == stack.length) {
            return false;  //栈满，无法入栈
        } else {
            stack.str[stack.top + 1] = x;
            stack.top++;
            return true;
        }
    }

    //出栈
    public static int PopStack(Num_Stack stack) {
        if (stack.top == -1) {
            return 0;  //栈空，出栈失败
        } else {
            int s = stack.str[stack.top];
            stack.top--;
            return s;
        }
    }

    //编写计算后缀表达式的方法
    public static int jisuan(String num_str) {  //将结果返回
        String[] real_num = num_str.split(" ");
        Num_Stack stack = new Num_Stack(real_num.length + 3);

        for (int i = 0; i < real_num.length; i++) {
            try {
                int num = Integer.parseInt(real_num[i]);  //尝试将字符转为数字
                PushStack(stack, num);

            } catch (NumberFormatException e) {  //转换失败，说明是运算符
                int num1 = PopStack(stack);  //右侧数字
                int num2 = PopStack(stack);  //左侧数字
                int num3 ;
                char operator = real_num[i].charAt(0);
                switch (operator) {
                    case '+':
                        num3 = num2 + num1;
                        PushStack(stack,num3);
                        break;
                    case '-':
                        num3 = num2 - num1;
                        PushStack(stack,num3);
                        break;
                    case '*':
                        num3 = num2 * num1;
                        PushStack(stack,num3);
                        break;
                    case '/':
                        if (num1 != 0) {
                            num3 = num2 / num1;
                            PushStack(stack,num3);
                        } else {
                            System.out.println("除数不能为零");
                        }
                        break;
                    default:
                        System.out.println("不支持的运算符");
                }
            }
        }
        //最后栈内只剩一个元素，即为结果
        return PopStack(stack);
    }
}

//编写一个类代表栈‘
class Num_Stack {
    int length;  //代表栈的最大容量
    //    char[] str = new char[length];   注意：不可以这样，因为在类的加载是还不知道length的值
    int[] str;
    int top = -1; //栈顶指针

    public Num_Stack(int length) {
        this.length = length;
        this.str = new int[length];
    }
}
