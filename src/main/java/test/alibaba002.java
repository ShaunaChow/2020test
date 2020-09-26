package test;

import java.util.Scanner;

/**
 * @Author Shauna.Chou
 * @Date 2020/9/22 19:25
 * @E-Mail z1023778132@icloud.com
 */
public class alibaba002 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int i=0;i<T;i++){
            int n = s.nextInt();
            int[][] tmp = new int[n][n];
            int[] visited = new int[n];
            for(int j=1;j<n;j++){
                int ii = s.nextInt();
                int jj = s.nextInt();
                int tar = s.nextInt();
                tmp[ii-1][jj-1] = tar;
                tmp[jj-1][ii-1] = tar;
            }
            int[][][] dp = new int[n][n][2];
            for(int k=0;k<n;k++){
                for(int m=k+1;m<n;m++){
                    if(dp[k][m][0]==0) dsp(tmp,visited,k,dp);
                }
            }

            int res = 0;
            for(int k=0;k<n;k++){
                for(int m=k+1;m<n;m++){
                    res += (dp[k][m][0]-dp[k][m][1]);
                }
            }
            System.out.println(res);
        }
    }

    private static void dsp(int[][] tmp, int[] visited, int s, int[][][] dp) {
        if(visited[s]==1) return;
        visited[s] = 1;
        for(int i=0;i<visited.length;i++){
            if(tmp[s][i]!=0&&visited[i]==0){
                for(int j=0;j<visited.length;j++){
                    if(visited[j]==1){
                        if(j==s){
                            int min = Math.min(i,j);
                            int max = Math.max(i,j);
                            dp[min][max][0] = Math.max(dp[min][max][0],tmp[s][i]);
                            if(dp[min][max][1]==0)
                                dp[min][max][1] = tmp[s][i];
                            else
                                dp[min][max][1] = Math.min(dp[min][max][1],tmp[s][i]);
                        }else{
                            int min = Math.min(s,j);
                            int max = Math.max(s,j);
                            int lastMax = dp[min][max][0];
                            int lastMin = dp[min][max][1];
                            min = Math.min(i,j);
                            max = Math.max(i,j);
                            dp[min][max][0] = Math.max(Math.max(dp[min][max][0],tmp[s][i]),lastMax);
                            if(dp[min][max][1]==0)
                                dp[min][max][1] = Math.min(tmp[s][i],lastMin);
                            else
                                dp[min][max][1] = Math.min(Math.min(dp[min][max][1],tmp[s][i]),lastMin);
                        }
                    }
                }
                dsp(tmp,visited,i,dp);
            }
        }
        visited[s] = 0;
    }
}
/**
1
4
1 2 3
2 3 2
2 4 4
 * **/