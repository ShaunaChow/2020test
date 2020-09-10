package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test9_3 {

    public static void main(String[] args) {//背包问题  体积和价值都可能出现负数的问题
        Scanner s = new Scanner(System.in);
        int N = s.nextInt(), M = s.nextInt();
        List<int[]> list = new ArrayList<>();
        int startValue = 0;
        for(int i=0;i<N;i++){
            int[] tmp = new int[2];
            tmp[0] = s.nextInt();
            tmp[1] = s.nextInt();
            if(tmp[0]>=0&&tmp[1]<=0) continue;
            if(tmp[0]<=0&&tmp[1]>=0) {
                M -= tmp[0];
                startValue += tmp[1];
            }else list.add(tmp);
        }
        System.out.println(ok(M,startValue,list));
    }
    private static int ok(int M, int startValue, List<int[]> list){

        return 0;
    }

    private static int getPin(List<int[]> list, int m){
        for(int i=0;i<list.size();i++){
            if(list.get(i)[0]>m) return i;
        }
        return -1;
    }
}
