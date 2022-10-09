package leetcode.editor.cn;
//二进制加法
//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: a = "11", b = "10"
//输出: "101" 
//
// 示例 2: 
//
// 
//输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
//
// 
//
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/ 
// Related Topics 位运算 数学 字符串 模拟 
// 👍 2 👎 0

public class JFETK5{
    public static void main(String[] args) {
        Solution solution = new JFETK5().new Solution();
        solution.addBinary("1010101001101",
                               "101011010");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a=b;
            b = temp;
        }
        int length = b.length() - 1;
        int f = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= b.length(); i++) {
            int tmp = a.charAt(a.length() - i) - '0' + b.charAt(b.length() - i) - '0'+f;
            f = tmp / 2;
            tmp = tmp % 2;
            sb.insert(0, tmp);
        }
        for (int i = b.length()+1; i <= a.length(); i++) {
            int tmp = a.charAt(a.length()-i) - '0'+f;
            f = tmp / 2;
            tmp = tmp % 2;
            sb.insert(0,tmp);
        }
        if (f == 1) {
            sb.insert(0,f);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}