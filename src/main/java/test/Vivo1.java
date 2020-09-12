package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author Shauna.Chou
 * @Date 2020/9/12 21:09
 * @E-Mail z1023778132@icloud.com
 */
public class Vivo1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int si = s.nextInt(), sj = s.nextInt(),
                ei = s.nextInt(), ej = s.nextInt();
        char[][] b = new char[n][n];
        s.nextLine();
        for(int i=0;i<n;i++){
            b[i] = s.nextLine().toCharArray();
        }
        System.out.println(ok(b, n - 1 - sj, si, n - 1 - ej, ei)-1);
    }

    private static int ok(char[][] b, int si, int sj, int ei, int ej) {
        int[][] dp = new int[b.length][b[0].length];
        List<Node> list = new Stack<>();
        list.add(new Node(si,sj));
        int res = 1;
        while(!list.isEmpty()){
            List<Node> tmp = new ArrayList<>();
            for(int i=0;i<list.size();i++){
                Node node = list.get(i);
                if(node.i==ei&&node.j==ej){
                    return res;
                }
                dp[node.i][node.j] = res;
                if(node.i+1<b.length&&dp[node.i+1][node.j]==0){
                    if(     b[node.i+1][node.j]=='#'||
                            b[node.i+1][node.j]=='@') dp[node.i+1][node.j] = -1;
                    else tmp.add(new Node(node.i+1,node.j));
                }
                if(node.i-1>=0&&dp[node.i-1][node.j]==0){
                    if(     b[node.i-1][node.j]=='#'||
                            b[node.i-1][node.j]=='@') dp[node.i-1][node.j] = -1;
                    else tmp.add(new Node(node.i-1,node.j));
                }
                if(node.j+1<b.length&&dp[node.i][node.j+1]==0){
                    if(     b[node.i][node.j+1]=='#'||
                            b[node.i][node.j+1]=='@') dp[node.i][node.j+1] = -1;
                    else tmp.add(new Node(node.i,node.j+1));
                }
                if(node.j-1>=0&&dp[node.i][node.j-1]==0){
                    if(     b[node.i][node.j-1]=='#'||
                            b[node.i][node.j-1]=='@') dp[node.i][node.j-1] = -1;
                    else tmp.add(new Node(node.i,node.j-1));
                }
            }
            res++;
            list = tmp;
        }
        return -1;
    }
    static class Node{
        int i,j;
        Node(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
}

/***
 *
5
1 0 1 4
77777
77#77
7#777
#7777
77777
 * */