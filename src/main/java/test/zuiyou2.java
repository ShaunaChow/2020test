package test;

import java.util.Scanner;

/**
 * @Author Shauna.Chou
 * @Date 2020/9/10 19:17
 * @E-Mail z1023778132@icloud.com
 */
public class zuiyou2 {
    private static int[] dp;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        dp = new int[n+1];
        dp[1] = 1;
        dp[0] = 1;
        System.out.println(ok(n));
    }

    private static int ok(int n) {
        if (dp[n]!=0) return dp[n];
        int res = 0;
        for(int i=1;i<=n;i++){
            res += (ok(i-1)*ok(n-i));
        }
        dp[n] = res;
        return res;
    }
}
