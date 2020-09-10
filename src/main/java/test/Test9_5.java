package test;

import java.util.Scanner;

public class Test9_5 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        int res = s1.length();
        for(int i=1;i<s1.length();i++){
            int p1 = 0;
            int p2 = i;
            while(p2<s1.length()&&s1.charAt(p1)==s1.charAt(p2)){
                p1++;p2++;
            }
            if(p2==s1.length()) {
                res = Math.min(res, i - (p1 % i == 0 ? i : p1 % i));
                break;
            }
        }
        System.out.println(res);
    }
}
