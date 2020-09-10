package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tenxun1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int[] nums1 = new int[n1];
        for(int i=0;i<n1;i++) nums1[i] = s.nextInt();
        int n2 = s.nextInt();
        int[] nums2 = new int[n2];
        for(int i=0;i<n2;i++) nums2[i] = s.nextInt();
        List<Integer> ok = ok(nums1, nums2);
        for (int i = 0; i <ok.size() ; i++) {
            if(i==ok.size()-1)
                System.out.print(ok.get(i));
            else
                System.out.print(ok.get(i)+" ");
        }
    }
    private static List<Integer> ok(int[] n1, int[] n2){
        int p1 = 0, p2 = 0;
        List<Integer> list = new ArrayList<>(Math.min(n1.length,n2.length));
        while(p1<n1.length&&p2<n2.length){
            if(n1[p1]==n2[p2]){
                list.add(n1[p1]);
                p1++;p2++;
            }else if(n1[p1]<n2[p2]) p2++;
            else p1++;
        }
        return list;
    }
}
/**
6
6 5 4 3 2 1
5
6 5 3 2 1
 *
 * **/
