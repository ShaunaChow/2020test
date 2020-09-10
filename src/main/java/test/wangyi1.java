package test;

import java.util.Scanner;

public class wangyi1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nums = s.nextInt();
        while(nums-->0){
            int W = s.nextInt(), H = s.nextInt();
            char[][] screen = new char[H][W];
            char[][] copy = new char[H][W];
            s.nextLine();
            for(int i=0;i<H;i++){
                String line = s.nextLine();
                for(int j=0;j<W;j++) {
                    screen[i][j] = line.charAt(j);
                    copy[i][j] = line.charAt(j);
                }
            }
            int P = s.nextInt(), Q = s.nextInt();
            char[][] man = new char[Q][P];
            s.nextLine();
            for(int i=0;i<Q;i++){
                String line = s.nextLine();
                for(int j=0;j<P;j++) man[i][j] = line.charAt(j);
            }
            int i = s.nextInt(), j = s.nextInt(), a = s.nextInt(), b = s.nextInt();
            System.out.print(ok(screen,man,i,j,a,b,copy)+" ");
        }
    }
    private static int ok(char[][] screen, char[][] man, int i, int j, int a, int b,char[][] copy){
        int res = 0;
        for(;
            i<=screen.length+1&&j<=screen[0].length+1
            &&i>-man.length&&j>-man[0].length
                ;){
            int mi = 0, mj = 0;
            if(i<=0) mi = -(i-1);
            if(j<=0) mj = -(j-1);
            res += show(screen,man,(i-1<0?0:i-1),(j-1<0?0:j-1),mi,mj,copy);
            for(char[] cc:screen){
                for (char c:cc)
                    System.out.print(c);
                System.out.println();
            }
            System.out.println("----------------------");
            i += a; j += b;
        }
        return res;
    }
    private static int show(char[][] screen, char[][] man,
                            int si, int sj, int mi, int mj,
                            char[][] copy){
        int res = 0;
        int siend = si + man.length - mi;
        int sjend = sj + man[0].length - mj;
        for(int i=0;i<screen.length;i++){
            for(int j=0;j<screen[0].length;j++){
                if( i>=si && i<siend && j>=sj && j<sjend ){
                    int ipian = i - si;
                    int jpian = j - sj;
                    if(screen[i][j]!=man[mi+ipian][mj+jpian]){
                        screen[i][j] = man[mi+ipian][mj+jpian];
                        res++;
                    }
                }else if(screen[i][j]!=copy[i][j]){
                    screen[i][j]=copy[i][j];
                    res++;
                }
            }
        }
        return res;
    }
}
/**
1
4 4
....
....
....
....
3 3
.o.
/|\
./\
0 0 1 -1


1
10
10
..........
..........
..........
..........
.....a.a..
..........
..........
..........
....a.....
..........
3 3
.o.
/|\
./\
1 1 1 1
 * */