package com.zrsedu.suanfa;

import java.util.Scanner;


public class kuo_hao_pi_pei {
    public static void main(String[] args) {
        System.out.println("请输入要进行匹配的括号!");
        Scanner scanner = new Scanner(System.in);
        String str_kuohao = scanner.next();
        Stack stack = new Stack(str_kuohao.length()); //将栈的容量变为要匹配的长度
        InitStack(stack);
        for (int i = 0; i < str_kuohao.length(); i++) {
            //依次遍历要进行括号匹配
            char c = str_kuohao.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                if (!PushStack(stack, c)) {
                    System.out.println("入栈失败！");
                    return;
                }
            }
            else{  //遇到右括号
                 char zuo = PopStack(stack);
                 if (zuo == '?'){
                     System.out.println("出栈失败！");
                     return;
                 }
                 if (zuo == '(' && c != ')'){
                     System.out.println("‘(’匹配失败");
                     return;
                 } else if (zuo == '[' && c != ']') {
                     System.out.println("’[‘匹配失败");
                     return;
                 } else if (zuo == '{' && c != '}') {
                     System.out.println("’{‘匹配失败");
                     return;
                 }
            }
        }
        System.out.println("匹配成功！！");
    }

    //初始化栈
    public static void InitStack(Stack stack) {
        stack.top = -1;  //将指针变为-1
        stack.str = new char[stack.length];
    }

    //入栈
    public static boolean PushStack(Stack stack, char x) {
        if ((stack.top + 1) == stack.length) {
            return false;  //栈满，无法入栈
        } else {
            stack.str[stack.top + 1] = x;
            stack.top++;
            return true;
        }
    }

    //出栈
    public static char PopStack(Stack stack) {
        if (stack.top == -1) {
            return '?';  //栈空，出栈失败
        } else {
            char s = stack.str[stack.top];
            stack.top--;
            return s;
        }
    }
}



//编写一个类代表栈‘
class Stack {
    int length;  //代表栈的最大容量
//    char[] str = new char[length];   注意：不可以这样，因为在类的加载是还不知道length的值
    char[] str ;
    int top; //栈顶指针

    public Stack(int length) {
        this.length = length;
    }
}
