package test;


import java.util.*;

public class tenxun2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt();
        Set<Integer>[] groups = new Set[m];
        Set<Integer> zeros = new HashSet<>(), knowns = new HashSet<>();
        for(int i=0;i<m;i++){
            int nums = s.nextInt();
            Set<Integer> set = new HashSet<>(nums);
            boolean flag = false;
            for(int j=0;j<nums;j++){
                int id = s.nextInt();
                set.add(id);
                if(id==0) {
                    zeros.add(i);
                    flag = true;
                }
            }
            if(flag) knowns.addAll(set);
            groups[i] = set;
        }
        System.out.println(ok(zeros,m,knowns,groups));
    }
    private static int ok(Set<Integer> zeros, int m, Set<Integer> knowns, Set<Integer>[] groups){
        if(zeros.size()==0) {
            return 0;
        }
        while(true) {
            int preg = zeros.size();
            for (int i = 0; i < m; i++) {
                if (zeros.contains(i)) continue;
                Set<Integer> now = new HashSet<>(knowns);
                now.removeAll(groups[i]);
                if (now.size() != knowns.size()) {
                    knowns.addAll(groups[i]);
                    zeros.add(i);
                }
            }
            if(zeros.size()==m||preg==zeros.size()) break;
        }
        return knowns.size();
    }
}
/***
50 5
2 1 2
5 10 11 12 13 14
2 0 1
2 49 2
4 6 7 8 2
 */