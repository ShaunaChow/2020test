package test;

import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int in = s.nextInt();
        String res = ok(in,new char[]{'@','$','&'});
        System.out.println( "答案为："+res );
    }
    private static String ok(int x, char[] c){
        int len = c.length;
        StringBuilder sb = new StringBuilder();
        while(x>=len){
            sb.insert(0,c[x%len]);
            x = x/len;
        }
        sb.insert(0,c[x]);
        return sb.toString();
    }
}
