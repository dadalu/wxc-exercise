//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串

package leetcode.editor.cn;
public class  LengthOfLastWord{
    public static void main(String[] args){
        Solution solution = new LengthOfLastWord().new Solution();
        int n = solution.lengthOfLastWord("hello world                ");
        System.out.println(n);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        if(s==""||"".equals(s)){
            return 0;
        }
        char[] c = s.toCharArray();
        boolean f = false;
        int n = 0;
        for (int i = c.length-1; i >= 0; i--) {
            if(c[i]==' '&&f==false){
                continue;
            }else if(c[i]!=' '){
                f =true;
                n++;
            }else if(c[i]==' '&&f==true){
                break;
            }
        }
        return n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
