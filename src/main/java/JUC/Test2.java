package JUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class Test2 {
    private static volatile int n = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while(true){
                if(n!=0) break;
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        n = 1;
        System.out.println(n);
        Integer a1 = 2222;
        Integer a2 = Integer.valueOf("2222");
        System.out.println(a1==a2);
    }
}
