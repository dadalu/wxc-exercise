package leetcode.editor.cn;
//包含min函数的栈
//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计 
// 👍 93 👎 0

import java.util.ArrayList;
import java.util.List;

public class BaoHanMinhanShuDeZhanLcof{


//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    /** initialize your data structure here. */
    List<Integer> list = new ArrayList<>();
    List<Integer> list1 = new ArrayList<>();
    Integer min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        list.add(x);
        min = Math.min(min, x);
    }

    public void pop() {
        int r = list.remove(list.size() - 1);
        if (r == min) {
            min = Integer.MAX_VALUE;
            while (list.size() > 0) {
                int r1 = list.remove(list.size() - 1);
                list1.add(r1);
                min = Math.min(min, r1);
            }
            while (list1.size() > 0) {
                int r2 = list1.remove(list1.size() - 1);
                list.add(r2);
            }
        }
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int min() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}