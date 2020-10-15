package leetcode.editor.cn;
//验证回文字符串 Ⅱ
//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 276 👎 0

public class ValidPalindromeIi{
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
        solution.validPalindrome("abc");
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        boolean b = true;
    public boolean validPalindrome(String s) {
        int l = 0,r = s.length()-1;
        while (l<r){
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if(lc==rc){
                l++;
                r--;
            }else if(b){
                b = false;
                return validPalindrome(s.substring(l+1,r+1))||validPalindrome(s.substring(l,r));
            }else{
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}