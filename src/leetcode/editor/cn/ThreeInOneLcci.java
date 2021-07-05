package leetcode.editor.cn;
//三合一
//三合一。描述如何只用一个数组来实现三个栈。 
//
// 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。s
//tackNum表示栈下标，value表示压入的值。 
//
// 构造函数会传入一个stackSize参数，代表每个栈的大小。 
//
// 示例1: 
//
//  输入：
//["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
//[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
// 输出：
//[null, null, null, 1, -1, -1, true]
//说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
// 
//
// 示例2: 
//
//  输入：
//["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
//[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
// 输出：
//[null, null, null, null, 2, 1, -1, -1]
// 
// Related Topics 栈 设计 数组 
// 👍 35 👎 0

public class ThreeInOneLcci{

//leetcode submit region begin(Prohibit modification and deletion)
class TripleInOne {
    int[] arr;
    int[] curindex;
    public TripleInOne(int stackSize) {
        arr = new int[stackSize*3];
        curindex = new int[3];
    }

    public void push(int stackNum, int value) {
        if (curindex[stackNum]>= arr.length/3) {
            return;
        }
        arr[curindex[stackNum]+stackNum*arr.length/3] = value;
        curindex[stackNum]++;
    }

    public int pop(int stackNum) {
        int topVal = peek(stackNum);
        if (curindex[stackNum] > 0)
            curindex[stackNum] -= 1;
        return topVal;
    }

    public int peek(int stackNum) {
        if (curindex[stackNum] == 0)
            return -1;
        return arr[stackNum*arr.length/3+curindex[stackNum]-1];
    }
    
    public boolean isEmpty(int stackNum) {
        return curindex[stackNum] == 0;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
//leetcode submit region end(Prohibit modification and deletion)

}