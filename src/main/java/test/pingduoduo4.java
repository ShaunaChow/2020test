package test;

import java.util.Scanner;

/**
 * @Author Shauna.Chou
 * @Date 2020/9/26 20:30
 * @E-Mail z1023778132@icloud.com
 */
public class pingduoduo4 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println( ok(s.nextInt(),s.nextInt()) );
    }
    private static int ok(int n, int m){
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }
        for(int i=0;i<m;i++){
            dp[0][i] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){

            }
        }
        return dp[n-1][m-1];
    }
}
