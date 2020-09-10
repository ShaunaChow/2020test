package test;

import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = 0;
        num = s.nextInt();
        int rem = s.nextInt();
        int[] in = new int[num];
        for(int i=0;i<in.length;i++){
            in[i] = s.nextInt();
        }
        System.out.println(ok(in,rem));

    }
    private static boolean ok(int[] h, int rem){
        int pre = -1;
        for(int i=0;i<h.length;i++){
            if(h[i]-1>pre) {
                rem++;
                h[i]--;
            }else if(h[i]>pre){
            }else if (h[i]+1>pre) {
                if(rem==0) return false;
                rem--;
                h[i]++;
            }else{
                return false;
            }
            pre = h[i];
        }
        return true;
    }
}
