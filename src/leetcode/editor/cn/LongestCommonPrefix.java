//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串
package leetcode.editor.cn;

public class  LongestCommonPrefix{
    public static void main(String[] args){
        Solution solution = new LongestCommonPrefix().new Solution();
        String [] strs = {"cc","c"};
        String [] strs1 = {"dog","racecar","car"};
        String [] strs2 = {"dog","dogger","dogggg"};
        String s = solution.longestCommonPrefix(strs);
        String s1 = solution.longestCommonPrefix(strs1);
        String s2 = solution.longestCommonPrefix(strs2);
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
    }
    


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ret = "";
        if(strs.length<=0)return "";
        if(strs.length==1) return strs[0];
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(i == strs[j].length() ||strs[0].charAt(i)!=strs[j].charAt(i)){
                    ret = strs[0].substring(0,i);
                    return ret;
                }
            }
        }
        return strs[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
