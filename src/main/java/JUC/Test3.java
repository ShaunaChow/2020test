package JUC;

import java.util.Scanner;

/**
 * @Author Shauna.Chou
 * @Date 2020/9/21 2:45
 * @E-Mail z1023778132@icloud.com
 */
public class Test3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(true) {
            String s1 = s.nextLine();
            String[] split = s1.split(" ");
            String res = "";
            for (String ss : split) {
                if(ss==null||ss.equals(""))
                    continue;
                res += "\t" + ss;
            }
            System.out.println(res);
        }
    }
}
