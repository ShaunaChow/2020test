package test;

public class Test9_6 {

    public static void main(String[] args) {
        Test9_6 test9_6 = new Test9_6();
        int[] nums = {1,4,2,3,6,9,8};
        int k = 1;
        System.out.println(test9_6.ok(nums, 0, nums.length-1, nums.length-k+1));
    }

    private int ok(int[] nums, int start, int end, int k){
        if(k>end-start+1) return -1;
        int povit = nums[start];
        int p1 = start, p2 = end;
        while(p1<p2){
            while(p1<p2&&nums[p2]>povit) p2--;
            if(p1==p2) break;
            swap(nums,p1,p2);
            p1++;
            while(p1<p2&&nums[p1]<=povit) p1++;
            if(p1==p2) break;
            swap(nums,p1,p2);
            p2--;
        }
        if(p1-start==k-1) return povit;
        else if(p1-start<k-1) return ok(nums,p1+1,end,k-(p1-start)-1);
        else return ok(nums,start,p1-1,k);
    }

    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}
