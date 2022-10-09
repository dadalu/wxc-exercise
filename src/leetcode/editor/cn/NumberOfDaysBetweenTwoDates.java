package leetcode.editor.cn;
//日期之间隔几天
//请你编写一个程序来计算两个日期之间隔了多少天。 
//
// 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。 
//
// 
//
// 示例 1： 
//
// 输入：date1 = "2019-06-29", date2 = "2019-06-30"
//输出：1
// 
//
// 示例 2： 
//
// 输入：date1 = "2020-01-15", date2 = "2019-12-31"
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 给定的日期是 1971 年到 2100 年之间的有效日期。 
// 
// Related Topics 数学 字符串 
// 👍 33 👎 0

public class NumberOfDaysBetweenTwoDates{
    public static void main(String[] args) {
        Solution solution = new NumberOfDaysBetweenTwoDates().new Solution();
        String date1 = "2019-06-30";
        String date2 = "2019-06-29";
        /*String date1 = "2020-01-15";
        String date2 = "2018-12-29";*/

        System.out.println(solution.daysBetweenDates(date1, date2));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int daysBetweenDates(String date1, String date2) {
        int count = 0;
        int[] days = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        int[] leapDays = new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};
        if (date1.compareTo(date2) >0) {
            return daysBetweenDates(date2, date1);
        }
        String[] time1 = date1.split("-");
        String[] time2 = date2.split("-");
        if (Integer.valueOf(time1[0]) < Integer.valueOf(time2[0])) {
            int year1 = Integer.valueOf(time1[0]);
            int year2 = Integer.valueOf(time2[0]);
            for (int i = year1+1; i < year2; i++) {
                if (i % 400 == 0 || (i % 100 != 0 && i % 4 == 0)) {
                    count += 366;
                } else {
                    count += 365;
                }
            }
            int month1 = Integer.valueOf(time1[1]);
            int day1 = Integer.valueOf(time1[2]);
            count -= day1;
            if (year1 % 400 == 0 || (year1 % 100 != 0 && year1 % 4 == 0)) {
                for (int i = month1; i <= 12; i++) {
                    count += leapDays[i];
                }
            } else {
                for (int i = month1; i <= 12; i++) {
                    count += days[i];
                }
            }
            int month2 = Integer.valueOf(time2[1]);
            int day2 = Integer.valueOf(time2[2]);
            if (year2 % 400 == 0 || (year2 % 100 != 0 && year2 % 4 == 0)) {
                for (int i = 1; i < month2; i++) {
                    count += leapDays[i];
                }
            } else {
                for (int i = 1; i < month2; i++) {
                    count += days[i];
                }
            }
            count += day2;
        } else if (Integer.valueOf(time1[0]).equals(Integer.valueOf(time2[0]))) {
            int year1 = Integer.valueOf(time1[0]);
            int month1 = Integer.valueOf(time1[1]);
            int day1 = Integer.valueOf(time1[2]);
            int month2 = Integer.valueOf(time2[1]);
            int day2 = Integer.valueOf(time2[2]);
            if (month1 == month2) {
                count = day2 - day1;
            } else {
                count -= day1;
                if (year1 % 400 == 0 || (year1 % 100 != 0 && year1 % 4 == 0)) {
                    for (int i = month1; i < month2; i++) {
                        count += leapDays[i];
                    }
                } else {
                    for (int i = month1; i < month2; i++) {
                        count += days[i];
                    }
                }
                count += day2;
            }

        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}