package leetcode.editor.cn;
//最长递增子序列
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 
// 👍 1919 👎 0

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        /*int[] nums = {4,5,6,5,8,7,4,8,4,1,3};
        solution.sort(nums);
        */
        int[] nums = {10,9,2,5,3,7,101,18};
        //solution.lengthOfLIS(nums);
        new PrintThread2().print();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sort(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0||nums.length==1){
            return nums.length;
        }
        int[] tempArr = new int[nums.length];
        tempArr[0]=1;
        for(int i=1;i<nums.length;i++){
            int temp = nums[i];
            tempArr[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<temp){
                    tempArr[i]=Math.max(tempArr[i],tempArr[j]+1);
                }
            }
        }
        int max = tempArr[0];
        for(int i=1;i<tempArr.length;i++){
            max = Math.max(max,tempArr[i]);
        }
        return max;
    }

}
    public static class ThreadDemo{
        private int num = 0;
        private Object lock = new Object();
        public void threadLoop(int N){
            for(int i =0;i<N;i++){
                Thread thread = new Thread(new PrintThread1(i,N));
                thread.start();
            }
        }


        class MyThread extends Thread{

            public void run(){
                synchronized(lock){
                    while(num<=100){
                        lock.notifyAll();
                        if (num > 100) {
                            break;
                        }
                        try{
                            Thread.sleep(100);
                        }catch(Exception e){

                        }
                            System.out.println(Thread.currentThread().getName() + ":" + num);
                            num++;
                            try{
                                lock.wait();
                            }catch(Exception e){

                            }
                        }
                    }
                }

        }
        class PrintThread1 implements Runnable {
            private Integer threadNo;
            private Integer total;
            public PrintThread1(Integer threadNo,Integer total) {
                this.threadNo = threadNo;
                this.total = total;
            }

            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        while (num % total != this.threadNo) {
                            if (num >= 101) {
                                break;
                            }
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        if (num >= 101) {
                            break;
                        }
                        System.out.println("thread-" + this.threadNo + ":" + num);
                        num++;

                        lock.notifyAll();
                    }
                }
            }
        }
    }


    public static class PrintThread{
        private int global = 0;
        private Object lock = new Object();

        public void print() {
            for (int i = 0; i < 3; i++) {
                new Thread(new MyThread(i)).start();
            }
        }

       class MyThread implements Runnable {
            private int c;
            public MyThread(int c) {
                this.c = c;
            }

            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        while (global%3 != c) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                        if (global % 3 == 0) {
                            System.out.println(Thread.currentThread()+"A");
                        } else if (global % 3 == 1) {
                            System.out.println(Thread.currentThread()+"B");
                        }else{
                            System.out.println(Thread.currentThread()+"C");
                        }
                        global++;
                        lock.notifyAll();
                    }
                }
            }
        }
    }

    public static class PrintThread2{
        private int global = 0;
        private Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        public void print() {
            new Thread(new MyThread("A",0,conditionA,conditionB)).start();
            new Thread(new MyThread("B",1,conditionB,conditionC)).start();
            new Thread(new MyThread("C",2,conditionC,conditionA)).start();
        }

        class MyThread implements Runnable {
            private String s;
            private int n;
            private Condition cur;
            Condition next;
            public MyThread(String s,int n,Condition cur,Condition next) {
                this.n = n;
                this.s = s;
                this.cur = cur;
                this.next = next;
            }

            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        while (global % 3 != n) {
                            cur.await();
                        }
                        System.out.println(Thread.currentThread() + s);
                        global++;
                        next.signal();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }
    }

}

//leetcode submit region end(Prohibit modification and deletion)

