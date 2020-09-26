package test;

import java.util.Scanner;

/**
 * @Author Shauna.Chou
 * @Date 2020/9/22 19:03
 * @E-Mail z1023778132@icloud.com
 */
public class alibaba001 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int i=0;i<T;i++){
            int N = s.nextInt();
            int M = s.nextInt();
            int fenzi = (N+1)/2*(M/2)+(M+1)/2*(N/2);
            int fenmu = M*N;
            int gdb = gdb(fenmu, fenzi);
            System.out.println(fenzi/gdb+"/"+fenmu/gdb);
        }

    }

    private static int gdb(int a,int b) {/** 求最大公约数 **/
        //确保 a>b
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

}
