package test;

import java.util.Scanner;
import java.util.Stack;

public class Test9_9_1 {        //非递归的快速排序

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String[] split = s1.split(" ");
        int[] nums = new int[split.length-1];
        int i = 0;
        for (String s2 : split) {
            if(s2.contains("#")) break;
            nums[i++] = Integer.valueOf(s2);
        }
        ok(nums);
        for (int num : nums) {
            System.out.print(num+"  ");
        }
    }
    private static void ok(int[] n){
        Stack<int[]> stack = new Stack<>();
        int[] s = {0,n.length-1};
        stack.push(s);
        while(stack.size()!=0){
            int[] now = stack.pop();
            int start = now[0], end = now[1];
            while(start<end){
                while(start<end&&n[start]<n[end]) end--;
                if(start==end) break;
                swap(n,start,end);
                start++;
                while(start<end&&n[start]<n[end]) start++;
                if(start==end) break;
                swap(n,start,end);
                end--;
            }
            if(start-now[0]>1) {
                int[] next = {now[0],start-1};
                stack.push(next);
            }
            if(now[1]-start>1){
                int[] next = {start+1,now[1]};
                stack.push(next);
            }
        }
    }

    private static void swap(int[] now, int start, int end) {
        int tmp = now[start];
        now[start] = now[end];
        now[end] = tmp;
    }
}
