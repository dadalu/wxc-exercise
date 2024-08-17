package leetcode.editor.cuntom;



public class ThreadJoin2 {

    static class PrintChar implements Runnable {
        private char character;
        private int times;

        public PrintChar(char character, int times) {
            this.character = character;
            this.times = times;
        }

        @Override
        public void run() {
            for (int i = 0; i < times; i++) {
                System.out.println(character);
                try {
                    // 模拟打印后短暂等待，以便清晰看到轮流效果
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // 创建三个线程分别打印"A"、"B"、"C"
        Thread threadA = new Thread(new PrintChar('A', 5));
        Thread threadB = new Thread(new PrintChar('B', 5));
        Thread threadC = new Thread(new PrintChar('C', 5));

        // 启动线程A
        threadA.start();

        // 等待线程A完成后再启动线程B
        try {
            threadA.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadB.start();

        // 等待线程B完成后再启动线程C
        try {
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadC.start();

        // 注意：这里没有等待threadC，如果需要确保所有线程执行完毕再结束main线程，应该在threadC后面也调用join()
        try {
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有字符打印完毕。");
    }
}
