package test;

import java.util.*;

public class Test5 {

    public static void main(String[] args) {
        int[] tmp = {1,-256,3213};
        show(tmp);
        ok(tmp);
        show(tmp);

        ok2(tmp);
        show(tmp);
        int mm = ~1;
        System.out.println(mm);
        for(int i=31;i>=0;i--){
            if((mm&(1<<i))!=0){
                System.out.print(1);
            }else {
                System.out.print(0);
            }
        }
    }

    private static void ok(int[] nums){
        for(int i=0;i<nums.length;i++){
            int tar = nums[i];
            int[] tmp = new int[32];
            for(int j=0;j<tmp.length;j++){
                if((tar&(1<<(31-j)))!=0)  {
                    tmp[j] = 1;
                } else tmp[j] = 0;
            }
            int result = 0;
            for(int j=0;j<tmp.length;j+=2){
                if(tmp[j+1]==1){
                    result = result|(1<<31-j);
                }
                if(tmp[j]==1){
                    result = result|(1<<31-j-1);
                }
            }
            nums[i] = result;
        }
    }

    private static void ok2(int[] nums){
        int[] pre = new int[2];
        pre[0] = (nums[nums.length-1]&1<<1)!=0?1:0;
        pre[1] = (nums[nums.length-1]&1)!=0?1:0;
        for(int i=0;i<nums.length;i++){
            int[] pre2 = new int[2];
            int tar = nums[i];
            pre2[0] = (tar&1<<1)!=0?1:0;
            pre2[1] = (tar&1)!=0?1:0;
            tar = tar>>2;
            tar = tar&(Integer.MAX_VALUE>>1);
            tar = tar|(pre[0]<<31);
            tar = tar|(pre[1]<<30);
            nums[i] = tar;
            pre = pre2;
        }
    }

    private static void show(int[] n){
        for(int s:n){
            for(int i=31;i>=0;i--){
                if((s&(1<<i))!=0){
                    System.out.print(1);
                }else {
                    System.out.print(0);
                }
            }
            System.out.print("  ");
        }
        System.out.println();
    }
}
