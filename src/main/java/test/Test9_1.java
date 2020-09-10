package test;

import java.util.Scanner;

public class Test9_1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), p = s.nextInt();
        int[][] in = new int[n+1][n+1];
        for(int i=0;i<p;i++){
            int ii = s.nextInt(), jj = s.nextInt();
            in[ii][jj] = 1;
            in[jj][ii] = 1;
        }
        int max = 0;
        for(int i=0;i<in.length;i++){
            if(in[1][i]==1){
                in[i][1] = 0;
                max = Math.max(max,ok(in,i));
                in[i][1] = 1;
            }
        }
        int res = n - max - 1;
        System.out.println(res);
    }

    private static int ok(int[][] board,int start){
        int max = 0;
        for(int i=0;i<board.length;i++){
            if(board[start][i]==1){
                board[i][start] = 0;
                max = max+ok(board,i);
                board[i][start] = 1;
            }
        }
        return max + 1;
    }
}
/**
 7 6
 1 2
 1 3
 2 4
 2 5
 3 6
 3 7
 * **/
/**
 8 7
 1 2
 1 3
 1 4
 4 7
 2 5
 5 6
 5 8
 * **/