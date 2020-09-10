package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    /**
     * 返回最少多少次操作后能使这几个数变成一个等差数列，如果完全不能构造成功，就返回-1
     * @param n int整型 代表一共有n个数字
     * @param b int整型一维数组 代表这n个数字的大小
     * @return int整型
     */
    public static int solve(int n, int[] b) {
        if(n<=2) return 0;
        List<int[]> list = new ArrayList();
        for(int i=1;i>-2;i--){
            for(int j=1;j>-2;j--){
                int[] k1 = new int[3];
                k1[0] = b[1]+i;
                k1[1] = b[0]+j-(b[1]+i);
                k1[2] = (i==0?0:1)+(j==0?0:1);
                list.add(k1);
                System.out.println(k1[0]+" "+k1[1]+" "+k1[2]);
            }
        }
        for(int i=2;i<n;i++){
            List<int[]> list2 = new ArrayList();
            for(int j=1;j>-2;j--){
                for(int[] now:list){
                    if(now[0]-(b[i]+j)==now[1]){
                        int[] newk1 = new int[3];
                        newk1[0] = b[i]+j;
                        newk1[1] = now[1];
                        newk1[2] = now[2]+(j==0?0:1);
                        list2.add(newk1);
                    }
                }
            }
            if(list2.size()==0) return -1;
            list = list2;
        }
        int res = Integer.MAX_VALUE;
        for(int[] now:list){
            res = Math.min(res,now[2]);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }

    public static void main(String[] args) {
        int [] test = new int[10000];
        Random random = new Random();
        int count = 0;
        for(int i=0;i<test.length;i++){
            int rand = random.nextInt(2);
            test[i] = i+rand;
            if(rand!=0) count++;
        }
        test = new int[]{24,21,14,10};
        System.out.println(count);
        long start = System.currentTimeMillis();
        int res = solve(test.length, test);
        long end = System.currentTimeMillis();
        System.out.println("用时:"+(end-start)+" 答案:"+res);
    }
}


