package test;

import java.util.Arrays;
import java.util.Scanner;

public class sougou1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] a = {s.nextInt(), s.nextInt(), s.nextInt()};
        System.out.println(ok(a));
    }
    private static int ok(int[] a) {
        Arrays.sort(a);
        if(a[0]==a[2]) return a[0];
        int d_21 = a[2] - a[1];
        int d_10 = a[1] - a[0];
        if(d_21>=d_10*2) {
            a[0] = a[1];
            a[2] -= d_10*2;
            int d = a[2] - a[1];
            return a[1] + d/5;
        }else{
            a[2] -= (d_21/2*2);
            a[0] += (d_21/2);
            int d = a[2] - a[0] + a[1] - a[0];
            return a[0] + d/4;
        }
    }
}
