package JUC;

import test.Solution;

import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test  {

    public static void main(String[] args) {
        Ticket t = new Ticket();
        new Thread(()->{
            for(int i=0;i<40;i++)
                t.sale();
        }).start();
        new Thread(()->{
            for(int i=0;i<40;i++)
                t.sale();
        }).start();
        new Thread(()->{
            for(int i=0;i<40;i++)
                t.sale();
        }).start();
    }

    private static class Ticket{
        int num = 50;
        Lock lock = new ReentrantLock();
        public void sale(){
            lock.lock();
            if(num>0)
                System.out.println("卖出第"+(num--)+"张，剩余："+num);
            lock.unlock();
        }
    }
}
