package leetcode.editor.cuntom;

import java.util.concurrent.Semaphore;

public class PrintABCWithSemaphore {

    private static final int LOOP_COUNT = 10; // 控制打印循环次数

    public static void main(String[] args) {
        Semaphore semaphoreA = new Semaphore(1); // 初始值为1，表示可以获取
        Semaphore semaphoreB = new Semaphore(0); // 初始值为0，表示不能获取
        Semaphore semaphoreC = new Semaphore(0); // 初始值为0，表示不能获取

        new Thread(new PrintTask(semaphoreA, semaphoreB, 'A')).start();
        new Thread(new PrintTask(semaphoreB, semaphoreC, 'B')).start();
        new Thread(new PrintTask(semaphoreC, semaphoreA, 'C')).start();
    }

    static class PrintTask implements Runnable {
        private Semaphore currentSemaphore;
        private Semaphore nextSemaphore;
        private char character;

        public PrintTask(Semaphore current, Semaphore next, char ch) {
            this.currentSemaphore = current;
            this.nextSemaphore = next;
            this.character = ch;
        }

        @Override
        public void run() {
            for (int i = 0; i < LOOP_COUNT; ) { // 这里使用i<LOOP_COUNT确保打印指定次数
                try {
                    currentSemaphore.acquire(); // 获取信号量，打印字符
                    System.out.println(character);
                    i++;
                    Thread.sleep(100); // 可选，为了视觉效果添加的延迟
                    nextSemaphore.release(); // 释放下一个线程的信号量
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }
}
