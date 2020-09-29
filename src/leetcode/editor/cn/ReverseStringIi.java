package leetcode.editor.cn;
//反转字符串 II
//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例: 
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 
//
// 提示： 
//
// 
// 该字符串只包含小写英文字母。 
// 给定字符串的长度和 k 在 [1, 10000] 范围内。 
// 
// Related Topics 字符串 
// 👍 92 👎 0

public class ReverseStringIi{
    public static void main(String[] args) {
        Solution solution = new ReverseStringIi().new Solution();
        System.out.println(solution.reverseStr("abcdefg", 2));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int l=0,r=0;
        while(len-r>k){
            r+=2*k;
            for (int i = r-k-1; i >= l; i--) {
                sb.append(s.charAt(i));
            }
            if(len<r){
                for (int i = l+k; i < len; i++) {
                    sb.append(s.charAt(i));
                }
            }else{
                for (int i = l+k; i < r; i++) {
                    sb.append(s.charAt(i));
                }
            }
            l=r;
        }
            for (int i = len-1; i >=l; i--) {
                sb.append(s.charAt(i));
            }


        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}