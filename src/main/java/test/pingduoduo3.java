package test;

import java.util.Scanner;

/**
 * @Author Shauna.Chou
 * @Date 2020/9/26 19:09
 * @E-Mail z1023778132@icloud.com
 */
public class pingduoduo3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int zu = s.nextInt();
        while(zu-->0){
            int n = s.nextInt();
            int k = s.nextInt();
            int[][] tmp = new int[n][2];
            for(int i=0;i<n;i++){
                tmp[i][0] = s.nextInt();
                tmp[i][1] = i+1;
            }

        }
    }
}
