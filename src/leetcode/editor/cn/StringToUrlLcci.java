package leetcode.editor.cn;
//URL化
//URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，
//请使用字符数组实现，以便直接在数组上操作。） 
//
// 
//
// 示例 1： 
//
// 
//输入："Mr John Smith    ", 13
//输出："Mr%20John%20Smith"
// 
//
// 示例 2： 
//
// 
//输入："               ", 5
//输出："%20%20%20%20%20"
// 
//
// 
//
// 提示： 
//
// 
// 字符串长度在 [0, 500000] 范围内。 
// 
// Related Topics 字符串 
// 👍 42 👎 0

public class StringToUrlLcci{
    public static void main(String[] args) {
        Solution solution = new StringToUrlLcci().new Solution();
        solution.replaceSpaces("Mr John Smith    ", 13);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        int len = length;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                len += 2;
            }
        }
        char[] newChars = new char[len];
        int offerset = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                newChars[i + offerset] = '%';
                offerset++;
                newChars[i + offerset] = '2';
                offerset++;
                newChars[i + offerset] = '0';
            } else {
                newChars[i + offerset] = chars[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < newChars.length; i++) {
            sb.append(newChars[i]);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}