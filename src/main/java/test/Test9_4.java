package test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test9_4 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int m = s.nextInt();
        int[] nums = new int[m];
        Set<Integer> dos = new HashSet<>();
        Set<Integer> notdos = new HashSet<>();
        for(int i=0;i<m;i++){
            nums[i] = s.nextInt();
            dos.add(nums[i]);
        }
        dealWith(nums,dos,notdos);
        System.out.println(ok(N,dos,notdos));
    }

    private static void dealWith(int[] nums,Set<Integer> dos,Set<Integer> notdos){//dos代表要加的
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int tmp = divisor(nums[i],nums[j]);
                if(dos.contains(tmp)) dos.remove(tmp) ;
                if(tmp==nums[i]||tmp==nums[j]){
                    continue;
                }else{
                    notdos.add(tmp);
                }
            }
        }
    }

    public static int divisor (int a,int b) {//求最大公倍数
        int  temp, m = a, n = b;
        if(a<b) {
            temp=a;a=b;b=temp;
        }
        while(b!=0) {
            temp=a%b;
            a=b;
            b=temp;
        }
        return m*n/a;
    }

    private static int ok(int N,Set<Integer> dos, Set<Integer> notdos){//求解
        int res = 0;
        for(int i:dos){
            System.out.print(i+" ");
            res += (N/i);
        }
        System.out.println();
        for(int i:notdos){
            System.out.print(i+" ");
            res -= (N/i);
        }
        return res;
    }
}
