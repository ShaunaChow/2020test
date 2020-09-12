package test;

import java.util.*;

/**
 * @Author Shauna.Chou
 * @Date 2020/9/11 19:58
 * @E-Mail z1023778132@icloud.com
 */
public class T360_1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt();
        int[][] tmp = new int[m][2];
        for(int i=0;i<m;i++){
            tmp[i][0] = s.nextInt();
            tmp[i][1] = s.nextInt();
        }
        System.out.println(ok(tmp, n));
    }

    private static List<Integer> ok(int[][] tmp, int n) {
        Set<Integer> up = new HashSet<>();
        for(int[] t:tmp){
            if(t[1]==0) break;
            up.add(t[0]);
        }
        Set<Integer> down = new HashSet<>();
        for(int i=tmp.length-1;i>=0;i--){
            if(tmp[i][1]==1) break;
            down.add(tmp[i][0]);
        }
        List<Integer> res = new ArrayList<>();
        if(up.size()==n) {
            res.add(tmp[0][0]);
            return res;
        }
        if(down.size()==n){
            res.add(tmp[tmp.length-1][0]);
            return res;
        }
        if(tmp[0][0]==tmp[tmp.length-1][0]) res.add(tmp[0][0]);
        else{
            Set<Integer> sett = new HashSet<>(down);
            sett.removeAll(up);
            if( (!down.contains(tmp[0][0]))&&sett.size()==0 ) res.add(tmp[0][0]);
            sett = new HashSet<>(up);
            sett.removeAll(down);
            if( (!up.contains(tmp[tmp.length-1][0]))&&sett.size()==0 ) res.add(tmp[tmp.length-1][0]);
        }
        for(int i=1;i<=n;i++){
            if(up.contains(i)||down.contains(i)) continue;
            else res.add(i);
        }
        return res;
    }
}
