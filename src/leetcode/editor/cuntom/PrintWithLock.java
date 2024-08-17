package leetcode.editor.cuntom;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintWithLock {
    public static void main(String[] args) {
        PrintThread printThread = new PrintThread();
        new Thread(()->printThread.print(10, "A")).start();
        new Thread(()->printThread.print(10, "B")).start();
        new Thread(()->printThread.print(10, "C")).start();
    }
    public static class PrintThread {
        Lock lock = new ReentrantLock();
        String cur = "A";
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        public void print(int times,String str){
            while (times > 0) {
                lock.lock();
                try {
                    while (!str.equals(cur)) {
                            switch (str) {
                                case "A":
                                    conditionA.await();
                                    break;
                                case "B":
                                    conditionB.await();
                                    break;
                                case "C":
                                    conditionC.await();
                                    break;
                            }
                    }
                    System.out.println(str);
                    times--;
                    switch (str) {
                        case "A":
                            cur = "B";
                            conditionB.signal();
                            break;
                        case "B":
                            cur = "C";
                            conditionC.signal();
                            break;
                        case "C":
                            cur = "A";
                            conditionA.signal();
                            break;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    lock.unlock();
                }
            }
        }
    }

}
