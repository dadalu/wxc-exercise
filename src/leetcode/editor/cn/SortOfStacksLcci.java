package leetcode.editor.cn;
//栈排序
//栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：pu
//sh、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。 
//
// 示例1: 
//
//  输入：
//["SortedStack", "push", "push", "peek", "pop", "peek"]
//[[], [1], [2], [], [], []]
// 输出：
//[null,null,null,1,null,2]
// 
//
// 示例2: 
//
//  输入： 
//["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
//[[], [], [], [1], [], []]
// 输出：
//[null,null,null,null,null,true]
// 
//
// 说明: 
//
// 
// 栈中的元素数目在[0, 5000]范围内。 
// 
// Related Topics 栈 设计 单调栈 
// 👍 39 👎 0

import java.util.ArrayList;
import java.util.List;

public class SortOfStacksLcci{
    public static void main(String[] args) {

    }

//leetcode submit region begin(Prohibit modification and deletion)
class SortedStack {
    List<Integer> stack;
    List<Integer> tempStack;
    public SortedStack() {
        stack = new ArrayList<>();
        tempStack = new ArrayList<>();
    }
    
    public void push(int val) {
        while (!isEmpty()&&peek() < val) {
            tempStack.add(stack.remove(stack.size() - 1));
        }
        stack.add(val);
        while (!tempStack.isEmpty()) {
            stack.add(tempStack.remove(tempStack.size() - 1));
        }
    }
    
    public void pop() {
        if (isEmpty()) {
            return;
        }
        stack.remove(stack.size() - 1);
    }
    
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return stack.get(stack.size() - 1);
    }
    
    public boolean isEmpty() {
        return stack.size() == 0;
    }
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}