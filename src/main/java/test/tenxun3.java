package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class tenxun3 {

    static class Node{
        String s;
        int n;
        Node(String str,int num){
            s = str;n = num;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt(),K = s.nextInt();
        s.nextLine();
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            String now = s.nextLine();
            int count = map.getOrDefault(now,0);
            map.put(now,count+1);
        }
        Node[] nodes = new Node[map.keySet().size()];
        int i=0;
        for(String str:map.keySet()){
            nodes[i++] = new Node(str,map.get(str));
        }
        ok(nodes,0,nodes.length-1);
        show(nodes,K);
    }

    private static void show(Node[] nodes, int K){
        int count = K, p1=nodes.length-1, pre = nodes[nodes.length-1].n;
        for(int j=nodes.length-1;j>=0&&count>0;j--){
            if(pre==nodes[j].n) continue;
            else{
                int p2 = j+1;
                while(p2<=p1&&count>0){
                    System.out.println(nodes[p2].s+" "+nodes[p2].n);
                    count--;
                    p2++;
                }
                p1 = j;
            }
            pre = nodes[j].n;
        }
        p1 = 0;
        while(count>0 && p1<nodes.length){
            System.out.println(nodes[p1].s+" "+nodes[p1++].n);
            count--;
        }
        count = K;
        while(count>0 && K-count<nodes.length){
            System.out.println(nodes[K-count].s+" "+nodes[K-count].n);
            count--;
        }
    }

    private static void ok(Node[] nodes, int start, int end) {
        int povit = nodes[start].n;
        int p1 = start, p2 = end;
        while(p1<p2){
            while(p1<p2&&compare(nodes[p2],nodes[p1])) p2--;
            if(p1==p2) break;
            Node now = nodes[p1];
            nodes[p1] = nodes[p2];
            nodes[p2] = now;
            p1++;
            while(p1<p2&&compare(nodes[p2],nodes[p1])) p1++;
            if(p1==p2) break;
            now = nodes[p1];
            nodes[p1] = nodes[p2];
            nodes[p2] = now;
            p2--;
        }
        if(p1-1-start>0) ok(nodes,start,p1-1);
        if(end-p1-1>0) ok(nodes,p1+1,end);
    }

    private static boolean compare(Node n1, Node n2){
        if(n1.n>n2.n) return true;
        else if(n1.n==n2.n){
            return n1.s.compareTo(n2.s)>=0;
        }else  return false;
    }

}


/**
12 3
a
a
a
b
b
b
d
d
c
c
e
f
 * **/