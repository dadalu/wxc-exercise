package leetcode.editor.cn;
//千位分隔数
//给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。 
//
// 
//
// 示例 1： 
//
// 输入：n = 987
//输出："987"
// 
//
// 示例 2： 
//
// 输入：n = 1234
//输出："1.234"
// 
//
// 示例 3： 
//
// 输入：n = 123456789
//输出："123.456.789"
// 
//
// 示例 4： 
//
// 输入：n = 0
//输出："0"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n < 2^31 
// 
// Related Topics 字符串 
// 👍 10 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThousandSeparator{
    public static void main(String[] args) {
        Solution solution = new ThousandSeparator().new Solution();
        solution.thousandSeparator(0);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String thousandSeparator(int n) {
        List<Integer> list = new LinkedList<>();
        if (n == 0) {
            return "0";
        }
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        int count = (list.size() - 1)/3;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (count > 0) {
            sb.insert(0,list.remove(0));
            i++;
            if (i == 3) {
                count--;
                sb.insert(0,".");
                i = 0;
            }
        }
        while (list.size() > 0) {
            sb.insert(0,list.remove(0));
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}