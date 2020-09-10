package test;

import java.util.Scanner;

public class Test6 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m, n;
        m = s.nextInt();
        n = s.nextInt();
        int[][] in = new int[m][n];
        long[][] ans = new long[m][n];  /** 保存每个点到终点的距离 **/
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                in[i][j] = s.nextInt();
                ans[i][j] = Integer.MAX_VALUE;/** 初始化为无穷距离 **/
            }
        }
        int[] point = new int[4];
        for (int i = 0; i < 4; i++) {
            point[i] = s.nextInt();
        }
        ans[point[2]][point[3]] = in[point[2]][point[3]];
        ok(in, point[0], point[1], ans);    /**此步计算**/
        System.out.println(ans[point[0]][point[1]] - in[point[0]][point[1]]);
    }

    private static long ok(int[][] x, int i, int j, long[][] ans){
        if(i<0||i>=x.length||j<0||j>=x[0].length) return Integer.MAX_VALUE;/** 越界退出 **/
        if(ans[i][j]!=Integer.MAX_VALUE) return ans[i][j];  /** 已经计算过了也直接返回 **/
        if(x[i][j]==-1) return Integer.MAX_VALUE;   /** 势力为-1不可达  推出  返回无穷 **/
        int tmp = x[i][j];  /**保存当前点的势力，方便下一步**/
        x[i][j] = -1;       /** 设置为-1 不可达  以免无限循环 **/
        long min = Math.min(    Math.min(  ok(x,i-1,j,ans),
                                            ok(x,i+1,j,ans)),
                                Math.min(   ok(x,i,j+1,ans),
                                            ok(x,i,j-1,ans)));  /**dfs**/
        x[i][j] = tmp;      /** 还原势力 **/
        ans[i][j] = min + x[i][j];
        return ans[i][j];   /**返回**/
    }
}
