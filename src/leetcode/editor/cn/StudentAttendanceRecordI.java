package leetcode.editor.cn;
//学生出勤记录 I
//给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符： 
//
// 
// 'A' : Absent，缺勤 
// 'L' : Late，迟到 
// 'P' : Present，到场 
// 
//
// 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。 
//
// 你需要根据这个学生的出勤记录判断他是否会被奖赏。 
//
// 示例 1: 
//
// 输入: "PPALLP"
//输出: True
// 
//
// 示例 2: 
//
// 输入: "PPALLL"
//输出: False
// 
// Related Topics 字符串 
// 👍 52 👎 0

public class StudentAttendanceRecordI{
    public static void main(String[] args) {
        Solution solution = new StudentAttendanceRecordI().new Solution();
        System.out.println(solution.checkRecord("PPALLLP"));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
        boolean b = true;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='A'){
                a++;
            }
            if(s.charAt(i)=='L'){
                l++;
                if(l>2){
                    b = false;
                }
            }else{
                l=0;
            }
        }
        return a<2&&b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}