package test;

import java.util.Scanner;

/**
 * @Author Shauna.Chou
 * @Date 2020/9/12 10:16
 * @E-Mail z1023778132@icloud.com
 */
public class xiaohongshui2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(ok(s.nextLine()));
    }

    private static int ok(String s) {
        int[] dp = new int[s.length() + 1];
        int[] keeper = new int[256];
        dp[0] = 0;
        for (int i = 1; i <= s.length(); i++){
            char now = s.charAt(i-1);
            if(keeper[now]==0) {
                dp[i] = dp[i-1]+1;
                keeper[now] = dp[i];
            }else {
                dp[i] = Math.min(dp[i - 1] + 1, keeper[now]);
                keeper[now] = dp[i];
            }
        }
        return dp[s.length()];
    }
}
