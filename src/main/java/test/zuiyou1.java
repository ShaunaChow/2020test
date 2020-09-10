package test;

import java.util.Scanner;

/**
 * @Author Shauna.Chou
 * @Date 2020/9/10 19:27
 * @E-Mail z1023778132@icloud.com
 */
public class zuiyou1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String n = s.nextLine();
        System.out.println(ok(n));
    }

    private static String ok(String n) {
        String res = "0";
        String mul = "1";
        for(int i=n.length()-1;i>=0;i--){
            char now = n.charAt(i);
            if(now=='-'){
                res = "-"+res;
                break;
            }
            int nn = now<='9'? now-'0' : now-'a'+10 ;
            res = add(res,mul(mul,String.valueOf(nn)));
            mul = mul(mul,"36");
        }
        return res;
    }

    private static String mul(String n1, String n2){
        char[] c1 = n1.toCharArray();
        char[] c2 = n2.toCharArray();
        char[] res = new char[c1.length+c2.length];
        int jinwei = 0;
        for(int i=c1.length-1;i>=0;i--){
            jinwei = 0;
            int nn1 = c1[i] - '0';
            for(int j=c2.length-1;j>=0;j--){
                int nn2 = c2[j] - '0';
                int nn3 = res[i+j+1];
                int ans = nn1*nn2+jinwei+nn3;
                int now = ans%10;
                jinwei = ans/10;
                res[i+j+1] = (char)(now);
            }
            res[i] = (char)jinwei;
        }
        res[0] = (char)jinwei;
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(int i=0;i<res.length;i++) {
             if(flag&&res[i]==0) continue;
             else {
                 flag = false;
                 sb.append((int)res[i]);
             }
        }
        return sb.toString();
    }


    private static String add(String n1, String n2){
        char[] res = new char[Math.max(n1.length(),n2.length())];
        int jinwei = 0;
        for(int i=0;i<res.length;i++){
            int nn1 = i<n1.length()?(n1.charAt(n1.length()-i-1)-'0'):0;
            int nn2 = i<n2.length()?(n2.charAt(n2.length()-1-i)-'0'):0;
            res[res.length-i-1] = (char)((nn1+nn2+jinwei)%10);
            jinwei = (nn1+nn2+jinwei)/10;
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(int i=0;i<res.length;i++) {
            if(flag&&res[i]==0) continue;
            else {
                flag = false;
                sb.append((int)res[i]);
            }
        }
        return sb.toString();
    }
}
