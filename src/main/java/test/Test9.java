package test;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;
public class Test9 {
    private static int res = 0;
    private static class Node{
        boolean isOk;
        int deep, max;
        Node(boolean l, int m, int d){
            isOk = l;max = m;deep = d;
        }
    }
    public static void main(String[] args) {
//
//        try {
//            InputStreamReader reader = new InputStreamReader(
//                    new FileInputStream("H:\\33.txt"),Charset.forName("UTF-8")
//            );
//            BufferedReader br = new BufferedReader(reader);
//            br.lines().forEach(System.out::println);
//            System.out.println(br.readLine());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();
        int[][] in = new int[n+1][n+1];
        for(int i=0;i<n-1;i++){
            int ii = s.nextInt(), jj = s.nextInt();
            in[ii][jj] = 1;
            in[jj][ii] = 1;
        }
        ok(in,x,y,0);
        System.out.println(res);
    }
    private static Node ok(int[][] board, int x, int y, int deep){
        boolean flag = false;
        int d = 0, max = 0, isOk = 0;
        if(x==y) {
            flag = true;
            d = (deep+1)/2;
        }
        for(int i=1;i<board.length;i++){
            if(board[x][i]==1){
                board[i][x] = 0;
                Node n = ok(board,i,y,deep+1);
                flag = flag||n.isOk;
                max = Math.max(max,n.max);
                d = Math.max(d,n.deep);
                board[i][x] = 1;
            }
        }
        if(flag&&d>0) res = Math.max(res,deep+max);
        return new Node(flag,max+1,d-1);
    }
}

/**
5 1 2
2 1
3 1
4 2
5 3
 * **/

/**
10 7 6
1 2
1 3
4 2
2 5
4 8
4 9
4 10
3 6
3 7 **/

/**
 15 10 11
 1 2
 1 4
 1 3
 2 5
 2 6
 3 7
 8 9
 8 10
 5 11
 5 12
 5 13
 7 14
 4 8
 14 15
 *
 * **/
