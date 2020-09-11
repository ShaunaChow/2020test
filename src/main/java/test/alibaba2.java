package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author Shauna.Chou
 * @Date 2020/9/11 8:55
 * @E-Mail z1023778132@icloud.com
 */
public class alibaba2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt(), n = s.nextInt();
        int[][] tmp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                tmp[i][j] = s.nextInt();
            }
        }
    }

    private static void ok(int[][] tmp){
        for(int i=0;i<tmp.length;i++){
            for(int j=0;j<tmp[0].length;j++){
                if(tmp[i][j]==-1){
                    int[] ints = new int[2];
                    search(tmp,i,j,ints);
                }
            }
        }
    }
    private static void search(int[][] tmp,int i, int j, int[] ints){
        int iX = tmp.length-1, jX = tmp[0].length-1;
        tmp[i][j] = -2;
        if(i>0){
            if(tmp[i-1][j]>=0){
                ints[0] += tmp[i-1][j];
                ints[1] ++;
            }else if(tmp[i-1][j]==-1){
                search(tmp,i-1,j,ints);
            }
        }
        if(i<iX){
            if(tmp[i+1][j]>=0){
                ints[0] += tmp[i+1][j];
                ints[1] ++;
            }else if(tmp[i+1][j]==-1){
                search(tmp,i+1,j,ints);
            }
        }
        if(j>0){
            if(tmp[i][j-1]>=0){
                ints[0] += tmp[i][j-1];
                ints[1] ++;
            }else if(tmp[i][j-1]==-1){
                search(tmp,i,j-1,ints);
            }
        }
        if(j<jX){
            if(tmp[i][j+1]>=0){
                ints[0] += tmp[i][j+1];
                ints[1] ++;
            }else if(tmp[i][j+1]==-1){
                search(tmp,i,j+1,ints);
            }
        }

    }
}
