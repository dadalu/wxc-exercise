//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class  MinStack{
    /*public static void main(String[] args){
        Solution solution = new MinStack().new Solution();
    }*/
    
//leetcode submit region begin(Prohibit modification and deletion)


    /** initialize your data structure here. */
    int top;
    List<Integer> entity;
    public MinStack() {
        top = 0;
        entity = new ArrayList();
    }
    
    public void push(int x) {
        if(top>=entity.size()){
            List newEntity = new ArrayList(entity.size()*2);
            for (int i = 0; i < entity.size(); i++) {
                newEntity.add(entity.get(i));
            }
            entity = newEntity;
        }
        entity.add(x);
        top++;
    }
    
    public void pop() {
        entity.remove(entity.size()-1);
        top--;
    }
    
    public int top() {
        return entity.get(entity.size()-1);
    }
    
    public int getMin() {
        int min = entity.get(0);
        for (int i = 1; i < entity.size(); i++) {
            if(min>entity.get(i)){
                min = entity.get(i);
            }
        }
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


