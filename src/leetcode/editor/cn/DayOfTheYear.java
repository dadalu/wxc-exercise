package leetcode.editor.cn;
//一年中的第几天
//给你一个按 YYYY-MM-DD 格式表示日期的字符串 date，请你计算并返回该日期是当年的第几天。 
//
// 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。 
//
// 
//
// 示例 1： 
//
// 输入：date = "2019-01-09"
//输出：9
// 
//
// 示例 2： 
//
// 输入：date = "2019-02-10"
//输出：41
// 
//
// 示例 3： 
//
// 输入：date = "2003-03-01"
//输出：60
// 
//
// 示例 4： 
//
// 输入：date = "2004-03-01"
//输出：61 
//
// 
//
// 提示： 
//
// 
// date.length == 10 
// date[4] == date[7] == '-'，其他的 date[i] 都是数字。 
// date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日。 
// 
// Related Topics 数学 字符串 
// 👍 36 👎 0

import java.util.HashSet;
import java.util.Set;

public class DayOfTheYear{
    public static void main(String[] args) {
        Solution solution = new DayOfTheYear().new Solution();
        solution.dayOfYear("2003-03-01");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int dayOfYear(String date) {
        int num = 0;
        String[] strs = date.split("-");
        Set<Integer> longMonth = new HashSet<>() ;
        longMonth.add(1);
        longMonth.add(3);
        longMonth.add(5);
        longMonth.add(7);
        longMonth.add(8);
        longMonth.add(10);
        longMonth.add(12);
        Set<Integer> shrtMonth = new HashSet<>();
        shrtMonth.add(4);
        shrtMonth.add(6);
        shrtMonth.add(9);
        shrtMonth.add(11);
        for (int i = 1; i < Integer.valueOf(strs[1]); i++) {
            if (longMonth.contains(i)) {
                num += 31;
            }
            if (shrtMonth.contains(i)) {
                num += 30;
            }
            if (i == 2) {
                if ((Integer.valueOf(strs[0]) % 100 == 0 && Integer.valueOf(strs[0]) % 400 == 0) || (Integer.valueOf(strs[0]) % 100 != 0 && Integer.valueOf(strs[0]) % 4 == 0)) {
                    num += 29;
                } else {
                    num += 28;
                }
            }
        }
        num += Integer.valueOf(strs[2]);
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}