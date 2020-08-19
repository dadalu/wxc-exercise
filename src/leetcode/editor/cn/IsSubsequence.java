package leetcode.editor.cn;
//判断子序列
//is-subsequence	
//392
//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"ae
//c"不是）。 
//
// 示例 1: 
//s = "abc", t = "ahbgdc" 
//
// 返回 true. 
//
// 示例 2: 
//s = "axc", t = "ahbgdc" 
//
// 返回 false. 
//
// 后续挑战 : 
//
// 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码
//？ 
//
// 致谢: 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
// Related Topics 贪心算法 二分查找 动态规划 
// 👍 305 👎 0

//Java：判断子序列
public class IsSubsequence{
    public static void main(String[] args) {
        Solution solution = new IsSubsequence().new Solution();
        //String s = "", t = "abc";
        String s1 = "axc", t1 = "ahbgdc" ;
        System.out.println(solution.isSubsequence(s1, t1));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //双指针解法
    /*public boolean isSubsequence(String s, String t) {
        if("".equals(s))return true;
        if("".equals(t))return false;
        for (int i = 0; i < s.length();) {
            for (int j = 0; j < t.length();) {
                if(s.charAt(i)==t.charAt(j)){
                    i++;
                    j++;
                }else{
                    j++;
                }
                if(i==s.length())return true;
                if(j==t.length())return false;
            }
        }
        return false;
    }*/
        /**
         * 动态规划解法
         * dp[i][j]=dp[i+1][j]  ;t[i]<>j
         *         =i           ;t[i]=j
         */

    public boolean isSubsequence(String s, String t) {

        int n = s.length();
        int m = t.length();
        int[][] arr = new int[m+1][26];
        for (int i = 0; i < 26; i++) {
            arr[m][i] = m;
        }
        for (int i = m-1; i >=0; i--) {
            for (int j = 0; j < 26; j++) {
                if(t.charAt(i)==j+'a'){
                    arr[i][j] = i;
                }else{
                    arr[i][j] = arr[i+1][j];
                }
            }
        }
        int add =0;
        for (int i = 0; i < n; i++) {
            if(arr[add][s.charAt(i)-'a']==m){
                return false;
            }
            add = arr[add][s.charAt(i)-'a']+1;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}