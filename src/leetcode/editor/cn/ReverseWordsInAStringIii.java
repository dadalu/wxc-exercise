package leetcode.editor.cn;
//反转字符串中的单词 III
//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 245 👎 0

public class ReverseWordsInAStringIii{
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int k = i;
            if(s.charAt(i)==' '){
                for (int j = k-1; j >= p; j--) {
                    sb.append(s.charAt(j));
                }
                sb.append(s.charAt(i));
                p=k+1;
            }
            if(k==s.length()-1){
                for (int j = k; j >= p; j--) {
                    sb.append(s.charAt(j));
                }
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}