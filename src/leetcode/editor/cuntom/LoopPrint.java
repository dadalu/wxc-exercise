package leetcode.editor.cuntom;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LoopPrint {
    public int times;
    public int state = 0;
    public Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public LoopPrint(int times) {
        this.times = times;
    }

    public void printA() {
        print("A", conditionA, conditionB, 0);
    }
    public void printB() {
        print("B", conditionB, conditionC, 1);
    }
    public void printC() {
        print("C", conditionC, conditionA, 2);
    }

    public void print(String p, Condition condition, Condition next, int targetState) {
        for (int i = 0; i < times;) {
            lock.lock();
            try {
                while (state % 3 != targetState) {
                    condition.await();
                }
                System.out.println(Thread.currentThread() + ":" + p);
                i++;
                state++;
                next.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        LoopPrint loopPrint = new LoopPrint(10);
        new Thread(loopPrint::printA).start();
        new Thread(loopPrint::printB).start();
        new Thread(loopPrint::printC).start();
    }
}
