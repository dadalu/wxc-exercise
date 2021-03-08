package leetcode.editor.cn;
//用两个栈实现队列
//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计 
// 👍 186 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

public class YongLiangGeZhanShiXianDuiLieLcof{

//leetcode submit region begin(Prohibit modification and deletion)
class CQueue {

    private Deque<Integer> queue1 = new ArrayDeque<>();
    private Deque<Integer> queue2 = new ArrayDeque<>();
    public CQueue() {

    }
    
    public void appendTail(int value) {
        queue1.push(value);
    }
    
    public int deleteHead() {
        if (queue1.size() < 1) {
            return -1;
        }
        while (queue1.size() > 0) {
            queue2.push(queue1.pollLast());
        }
        int r = queue2.pollLast();
        while (queue2.size() > 0) {
            queue1.push(queue2.pollLast());
        }
        return r;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}