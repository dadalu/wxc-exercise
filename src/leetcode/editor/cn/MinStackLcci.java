package leetcode.editor.cn;
//栈的最小值
//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(
//1)。 示例： MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
// minStack.push(-3); minStack.getMin();   --> 返回 -3. minStack.pop(); minStack.top
//();      --> 返回 0. minStack.getMin();   --> 返回 -2. Related Topics 栈 
// 👍 40 👎 0

import java.util.ArrayList;
import java.util.List;

public class MinStackLcci{


//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

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

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}