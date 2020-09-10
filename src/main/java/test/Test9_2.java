package test;

import java.util.Scanner;

public class Test9_2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[][] points = new int[n][2];
        for(int i=0;i<n;i++){
            points[i][0] = s.nextInt();
            points[i][1] = s.nextInt();
        }
        ok(points,k);
    }

    private static int ok(int[][] points,int k) {

        for(int i=0;i<points.length-1;i++){
            for(int j=i+1;j<points.length;j++){
                if(points[i][0]==points[j][0]) {
                    k--;
                }
            }
        }
        return 0;
    }
}
