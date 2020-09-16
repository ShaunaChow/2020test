package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Shauna.Chou
 * @Date 2020/9/16 15:39
 * @E-Mail z1023778132@icloud.com
 */
public class weizhi1 {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String[] split = s1.split(" ");
        int[] tmp = new int[split.length];
        for(int i=0;i<split.length;i++){
            tmp[i] = Integer.parseInt(split[i]);
        }
        ok(tmp,0,tmp.length-1);
        System.out.println(list);
    }

    private static void ok(int[] tmp, int i, int j) {
        if(i==j) {
            list.add(tmp[i]);
            return;
        }
        if(i>j) return;
        int povit = tmp[i];
        int pin = i+1;
        while(tmp[pin]<povit){
            pin++;
        }
        ok(tmp,i+1,pin-1);
        ok(tmp,pin,j);
    }
}
