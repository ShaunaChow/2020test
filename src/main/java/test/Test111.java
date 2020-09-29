package test;

import java.util.Scanner;

/**
 * @Author Shauna.Chou
 * @Date 2020/9/29 20:05
 * @E-Mail z1023778132@icloud.com
 */
public class Test111 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        System.out.println(ok(s1));
    }

    private static int ok(String s1) {
        if(s1==null||s1.length()<3) return 0;
        int pin1 = 2;
        int res = 0;
        for(;pin1<s1.length();pin1++){
            if(s1.charAt(pin1)==s1.charAt(pin1-2)&&s1.charAt(pin1)!=s1.charAt(pin1-1)) res++;
        }
        return res;
    }
}
