package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class wangyi2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nums = s.nextInt();
        while(nums-->0){
            int n = s.nextInt();
            int[][] tmp = new int[n][2];
            for(int i=0;i<n;i++){
                tmp[i][0] = s.nextInt();
                tmp[i][1] = s.nextInt();
            }
            System.out.print(ok(tmp)+" ");
        }
        System.out.println();
    }
    private static int ok(int[][] op){
        int[] now = {0,0};
        int count = 0;
        Map<String,Integer> map = new HashMap<>();
        map.put("0,0",0);
        for(int i=0;i<op.length;i++){
            if(op[i][1]==-1) continue;
            switch (op[i][0]){
                case 0:
                    now[0]--;
                    break;
                case 1:
                    now[0]++;
                    break;
                case 2:
                    now[1]--;
                    break;
                case 3:
                    now[1]++;
                    break;
            }
            String tmp = now[0]+","+now[1];
            count++;
            if(map.containsKey(tmp)){
                count = Math.min(count,map.get(tmp));
            }
            String[] ss = { now[0]-1+","+now[1],
                    now[0]+1+","+now[1],
                    now[0]+","+(now[1]-1),
                    now[0]+","+(now[1]+1),
            };
            for(String s:ss){
                if(map.containsKey(s)) count = Math.min(map.get(s)+1,count);
            }
            map.put(tmp,count);
        }
        return count;
    }
}
/**
3
10
0 1
0 -1
1 1
1 1
1 -1
0 1
2 1
2 -1
3 1
3 1
2
3 1
3 1
8
0 1
0 1
3 1
3 1
1 1
1 1
2 1
0 1
 * */