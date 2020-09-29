package test;

import java.util.Scanner;

/**
 * @Author Shauna.Chou
 * @Date 2020/9/29 20:14
 * @E-Mail z1023778132@icloud.com
 */
public class Test112 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[][] tmp = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                tmp[i][j] = s.nextInt();
            }
        }
        System.out.println(ok(tmp));
    }

    private static int ok(int[][] tmp) {
        int N = tmp.length;
        int res = 0;
        int[][] dp1 = new int[N][N];
        for(int i = N -1; i>=0; i--){
            for(int j = N -1; j>=0; j--){
                if(tmp[i][j]==-1) dp1[i][j] = -1;
                else if(i== N -1&&j== N -1) dp1[i][j] = tmp[i][j];
                else if(i==N-1) dp1[i][j] = dp1[i][j+1]==-1?-1:(tmp[i][j] + dp1[i][j+1]);
                else if(j==N-1) dp1[i][j] = dp1[i+1][j]==-1?-1:(tmp[i][j] + dp1[i+1][j]);
                else {
                    dp1[i][j] = (dp1[i+1][j]==-1&&dp1[i][j+1]==-1)
                                ? -1
                                :(tmp[i][j] + Math.max(dp1[i+1][j],dp1[i][j+1]));
                }
            }
        }
        res = dp1[0][0];
        int pi=0,pj=0;
        while(pi!=N-1||pj!=N-1){
            tmp[pi][pj] = 0;
            if(pi==N-1) pj++;
            else if(pj==N-1) pi++;
            else {
                if(dp1[pi][pj+1]>dp1[pi+1][pj]) pj++;
                else pi++;
            }
        }
        tmp[N-1][N-1] = 0;
        int[][] dp2 = new int[N][N];
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(tmp[i][j]==-1) dp1[i][j] = -1;
                else if(i== 0&&j== 0) dp1[i][j] = tmp[i][j];
                else if(i==0) dp1[i][j] = dp1[i][j-1]==-1?-1:(tmp[i][j] + dp1[i][j-1]);
                else if(j==0) dp1[i][j] = dp1[i-1][j]==-1?-1:(tmp[i][j] + dp1[i-1][j]);
                else {
                    dp1[i][j] = (dp1[i-1][j]==-1&&dp1[i][j-1]==-1)
                                ? -1
                                :(tmp[i][j] + Math.max(dp1[i-1][j],dp1[i][j-1]));
                }
            }
        }
        res += dp2[N-1][N-1];
        return res;
    }
}


/**
4
0 1 0 -1
1 0 0 -1
1 0 1 -1
-1 0 0 1
 *
 * **/