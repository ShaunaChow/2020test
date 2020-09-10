package test;

import java.util.Scanner;

public class Test9_9 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String ss = s.nextLine();
        System.out.println(ok(ss));
    }
    private static int ok(String s){
        int count = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                count++;
            }
        }
        return s.length()/count;
    }
}
