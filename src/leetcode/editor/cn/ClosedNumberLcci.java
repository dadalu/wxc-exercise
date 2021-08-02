package leetcode.editor.cn;
//下一个数
//下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。 
//
// 示例1: 
//
// 
// 输入：num = 2（或者0b10）
// 输出：[4, 1] 或者（[0b100, 0b1]）
// 
//
// 示例2: 
//
// 
// 输入：num = 1
// 输出：[2, -1]
// 
//
// 提示: 
//
// 
// num的范围在[1, 2147483647]之间； 
// 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。 
// 
// Related Topics 位运算 
// 👍 30 👎 0

public class ClosedNumberLcci{
    public static void main(String[] args) {
        Solution solution = new ClosedNumberLcci().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findClosedNumbers(int num) {
        int[] ret = new int[2];
        if (num < 0 || num >= Integer.MAX_VALUE) {
            ret[0] = -1;
            ret[1] = -1;
        } else {
            ret[0] = next(num);
            ret[1] = pre(num);
        }
        return ret;
    }

    public int pre(int n) {
        int temp = n;
        int c0 = 0;
        int c1 = 0;
        while ((temp&1)==1) {
            c1++;
            temp >>= 1;
        }

        if (temp == 0) return -1;

        while (((temp &1)==0) &&(temp!=0)) {
            c0++;
            temp >>=1;
        }

        int p = c0+c1; // 最右边，非拖尾1的位置
        n &= ((~0)<<(p+1)); // 将位0到位p清零

        int mask = (1<<(c1+1)) -1; // (c1+1)个1
        n |= mask << (c0-1);

        return n;
    }

    public int next(int num) {
        int temp = num;
        int c0 = 0;
        int c1 = 0;
        while (((temp & 1) == 0) && (temp != 0)) {
            c0++;
            temp >>=1;
        }
        while ((temp & 1) == 1) {
            c1++;
            temp >>= 1;
        }
        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }
        int p = c1 + c0;
        num |= (1 << p);
        num &= ~((1 << p) - 1);
        num |= (1 << (c1-1)) - 1;
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}