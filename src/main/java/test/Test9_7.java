package test;

import java.util.Scanner;

public class Test9_7 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i=0;i<n;i++){
            int ren = s.nextInt();
            int m = s.nextInt();
            int[][] people = new int[ren][2];
            int[][] mm = new int[m][2];
            for(int j=0;j<ren;j++) {
                people[j][0] = s.nextInt();
                people[j][1] = j+1;
            }
            for(int j=0;j<m;j++) {
                mm[j][0] = s.nextInt();
                mm[j][1] = j+1;
            }
            sort(people,0,people.length-1);
            sort(mm,0,mm.length-1);
            int[] ans = ok(people,mm);
            for(int now:ans)
                System.out.print(now+" ");
            System.out.println();
        }
    }

    private static void sort(int[][] nums, int start, int end){
        if(start>=end) return;
        int p1 = start, p2 = end;
        while(start<end){
            while(start<end&&nums[start][0]>nums[end][0]){
                end--;
            }
            if(start==end) break;
            swap(nums, start, end);
            start++;
            while(start<end&&nums[start][0]>nums[end][0]){
                start++;
            }
            if(start==end) break;
            swap(nums, start, end);
            end--;
        }
        sort(nums,p1,start-1);
        sort(nums,start+1,p2);
    }

    private static void swap(int[][] nums, int p1, int p2) {
        int[] tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }

    private static int[] ok(int[][] people, int[][] m){
        int p1 = 0, p2 = 0;
        int[] res = new int[people.length];
        while(p1<people.length&&p2<m.length){
            if(people[p1][0]<m[p2][0]){
                res[people[p1++][1]-1] = m[p2++][1];
            }else{
                res[people[p1++][1]-1] = -1;
            }
        }
        if(p1<people.length){
            res[people[p1++][1]] = -1;
        }
        return res;
    }
}
