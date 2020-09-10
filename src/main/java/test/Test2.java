package test;

import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = 0, k = 0;
        num = s.nextInt();
        k = s.nextInt();
        int[] in = new int[num];
        int[][] dp = new int[num][2];
        for(int i=0;i<in.length;i++){
            in[i] = s.nextInt();
        }
        System.out.println(ok(in,0,k,1,dp));
    }
    private static boolean ok(int[] h, int pin, int k, int chance, int[][] dp){
        if(pin==h.length-1) return true;
        boolean res = false;
        for(int i=1;i<=k&&i+pin<h.length;i++){
            if(chance==1&&dp[pin+i][0]==1) continue;
            if(chance==0&&dp[pin+i][1]==1) continue;
            if(h[pin+i]<=h[pin]) {
                res = res||ok(h,pin+i,k,chance,dp);
            }else{
                if(chance==0) {
                    dp[pin+i][1] = 1;
                    continue;
                }
                res = res||ok(h,pin+i,k,0,dp);
            }
            if(res) return res;
            dp[pin+i][0] = chance==1?1:0;
            dp[pin+i][1] = chance==0?1:0;
        }
        return res;
    }
}
