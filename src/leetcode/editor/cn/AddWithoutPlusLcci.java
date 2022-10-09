package leetcode.editor.cn;
//不用加号的加法
//设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// Related Topics 位运算 数学 
// 👍 46 👎 0

public class AddWithoutPlusLcci{
    public static void main(String[] args) {
        Solution solution = new AddWithoutPlusLcci().new Solution();
        System.out.println(solution.add(3, 5));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int add(int a, int b) {
        int sum = 0, bit = 0;
        while (b != 0) {
            bit = a & b;
            sum = a^b;
            a = sum;
            b = bit << 1;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}