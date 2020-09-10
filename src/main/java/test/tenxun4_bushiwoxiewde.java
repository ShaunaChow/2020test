package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class tenxun4_bushiwoxiewde {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
            list.add(arr[i]);
        }
        Arrays.sort(arr);
        int n1 = arr[num/2-1];
        int n2 = arr[num/2];
        for(int i=0;i<num;i++){
            if(list.get(i)<=n1){
                System.out.println(n2);
            }else{
                System.out.println(n1);
            }
        }
    }
}

