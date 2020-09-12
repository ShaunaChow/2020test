package test;

import java.util.Scanner;

/**
 * @Author Shauna.Chou
 * @Date 2020/9/11 21:05
 * @E-Mail z1023778132@icloud.com
 */
public class T360_2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()){
            String next = s.nextLine();
            if(next==null||next.equals("")) break;
            boolean condition1 = false,condition2 = false,condition3 = false,condition4 = false,condition5 = false;
            for(char c:next.toCharArray()){
                if((!condition1)&&c<='9'&&c>='0') condition1 = true;
                if((!condition2)&&c<='Z'&&c>='A') condition2 = true;
                if((!condition3)&&c<='z'&&c>='a') condition3 = true;
                if((!condition4)&&(c<'0'||(c<'A'&&c>'9')||(c>'Z'&&c<'a')||c>'z')) condition4 = true;
                if((!condition5)&&next.length()>=8) condition5 = true;
            }
            System.out.println((condition1&&condition2&&condition3&&condition4&&condition5)?"Ok":"Not Ok");
        }
    }
}
