package test;

import java.util.Scanner;

public class Test {

    private static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] in = new int[4];
        if(s.hasNextLine()){
            for(int i=0;i<in.length;i++){
                in[i] = s.nextInt();
            }
        }
        ok(in[0],in[1],in[2],in[3],0);
        System.out.println(res);
    }

    private static void ok(int A, int B, int p, int q, int t){
        if(p==0) return;
        if(p<0){
            if(q>=0) return;
            ok(A,B,q*p,q,t+1);
        }else{
            if(q>=-1&&q<=1){
                res = Math.min(res,(B-A)/q+1);
                return;
            }else if(q<-1){
                if(B-A<=2*p) res = (B-A)<=p?Math.min(res,t+1):Math.min(res,t+2);
                else{
                    ok(A,B,p*q*q,q,t+2);
                }
            }else{
                if(B-A<=p) res = Math.min(res,t+1);
                else{
                    ok(A,B,p*q,q,t+1);
                }
            }
        }
    }
}
