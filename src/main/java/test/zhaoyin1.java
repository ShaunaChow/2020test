package test;

import java.util.*;

public class zhaoyin1 {

    private static List<List<Integer>> res = new ArrayList<>();
    private static int tar ;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] tmp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                tmp[i][j] = s.nextInt();
            }
        }
        int start = s.nextInt();
        tar = start;
        ok(tmp,start,new int[n],new ArrayList<>());
        for(List<Integer> l:res){
            for (int i:l) System.out.print(i+" ");
            System.out.println();
        }
    }
    private static void ok(int[][] tmp, int start, int[] passed, List<Integer> list){
        list.add(start);
        int t = passed[start];
        passed[start] = 1;
        for(int i=0;i<tmp[start].length;i++){
            if(tmp[start][i]==1){
                if(i==tar) {
                    List<Integer> newlist = new ArrayList<>(list);
                    res.add(newlist);
                }else if(passed[i]==1){
                    continue;
                }else{
                    List<Integer> newlist = new ArrayList<>(list);
                    ok(tmp, i,passed, newlist);
                }
            }
        }
        passed[start] = t;
    }
}
/**
5
0 1 0 0 0
0 0 1 1 0
1 0 0 0 0
0 0 0 0 1
0 1 1 0 0
4
 *
 * **/