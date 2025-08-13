package com.zrsedu.suanfa;

public class SSS {
    public static void main(String[] args) {
        String s = "abaccdeff";
        char c = firstNotRepeatingChar(s);
        System.out.println(c);
    }
    public  static char firstNotRepeatingChar(String s) {
        int len = s.length();
        if(len < 0 || len > 1000)
            return '#';

        for(int i = 0; i < len; i++){
            if(i == len - 1){
                if(s.indexOf(s.charAt(i)) == len - 1)
                    return s.charAt(0);
                else{
                    break;
                }
            }

            for(int j = i + 1; j < len; j++){
                if(s.charAt(j) == s.charAt(i)){
                    break;
                }
                if(j == len - 1){
                    return s.charAt(i);
                }
            }


        }
        return '#';
    }
}
