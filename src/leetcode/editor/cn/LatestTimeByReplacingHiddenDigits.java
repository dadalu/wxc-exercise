package leetcode.editor.cn;
//替换隐藏数字得到的最晚时间
//latest-time-by-replacing-hidden-digits	
//1736
//给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。 
//
// 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。 
//
// 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。 
//
// 
//
// 示例 1： 
//
// 
//输入：time = "2?:?0"
//输出："23:50"
//解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
// 
//
// 示例 2： 
//
// 
//输入：time = "0?:3?"
//输出："09:39"
// 
//
// 示例 3： 
//
// 
//输入：time = "1?:22"
//输出："19:22"
// 
//
// 
//
// 提示： 
//
// 
// time 的格式为 hh:mm 
// 题目数据保证你可以由输入的字符串生成有效的时间 
// 
// Related Topics 贪心算法 字符串 
// 👍 9 👎 0

//Java：替换隐藏数字得到的最晚时间
public class LatestTimeByReplacingHiddenDigits{
    public static void main(String[] args) {
        Solution solution = new LatestTimeByReplacingHiddenDigits().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String maximumTime(String time) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            if (c == '?') {
                switch (i) {
                    case 0:
                        if (time.charAt(1) == '?' || time.charAt(1) < '4') {
                            sb.append(2);
                        } else {
                            sb.append(1);
                        }
                        break;
                    case 1:
                        if (time.charAt(0) == '?' || time.charAt(0) == '2') {
                            sb.append(3);
                        } else {
                            sb.append(9);
                        }
                        break;
                    case 3:
                        sb.append(5);
                        break;
                    case 4:
                        sb.append(9);
                        break;

                }
            } else {
                sb.append(c);

            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}