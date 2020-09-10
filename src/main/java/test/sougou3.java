package test;

import java.util.Scanner;

public class sougou3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        int[][] tmp = new int[s1.length()][10];
        int res = ok(s1, 0, 0, tmp);
        System.out.println(res);
        int i=1;
        for(;i<s1.length();i++){
            int pre = s1.charAt(i-1) - '0';
            int now = s1.charAt(i) - '0';
            if(Math.abs(now-pre)>1) break;
        }
        if(i==s1.length()) res--;
        System.out.println(res);
        System.out.println(Integer.MAX_VALUE);
    }

    private static int ok(String s1, int pin, int pre,int[][] tmp) {
        if(pin>=s1.length()) return 1;
        if(tmp[pin][pre]!=0) return tmp[pin][pre];
        if(pin==0){
            int res = 0;
            for(int i=0;i<10;i++) res += ok(s1,pin+1,i,tmp);
            return res;
        }else{
            int now = s1.charAt(pin) - '0';
            if((now+pre)%2==0){
                int res = ok(s1,pin+1,(now+pre)/2,tmp);
                tmp[pin][pre] = res;
                return res;
            }else{
                int res = ok(s1,pin+1,(now+pre)/2,tmp)
                        +ok(s1,pin+1,(now+pre)/2+1,tmp);
                tmp[pin][pre] = res;
                return res;
            }
        }
    }
}
