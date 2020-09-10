package test;

import java.util.Scanner;

public class Test9_8 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        long start = System.currentTimeMillis();
        int[][] dp = new int[m][m*m+m];
        dp[0][0] = 1;
        int pin = 0;
        for(int i=1;i<n;i++){
            int[] tmp = new int[m*m+m];
            for(int j=0;j<m;j++){
                if(pin-j>=0){
                    int[] dp1 = dp[(pin-j)%m];
                    int step = j+1;
                    for(int k=0;k<dp1.length;k++){
                        if(dp1[k]==0) continue;
                        else if(k<m){
                            int _1 = k+1;
                            if(_1!=step){
                                tmp[ step*m + _1 - 1 ] = (tmp[ step*m + _1 - 1 ]+dp1[k])%1000000007;
                            }
                        }else{
                            int _1 = k/m;
                            int _2 = k%m+1;
                            if(_1==_2) continue;
                            if(_1!=step&&_2!=step){
                                tmp[ step*m + _1 - 1 ] = (tmp[ step*m + _1 - 1 ]+dp1[k])%1000000007;
                            }
                        }
                    }
                }else{
                    tmp[pin+1] = 1;
                    break;
                }
            }
            dp[(pin+1)%m] = tmp;
            pin++;
        }
        int res = 0;
        for(int now:dp[pin%m]) {
            res = (res + now)%1000000007;
        }
        System.out.println(res);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
