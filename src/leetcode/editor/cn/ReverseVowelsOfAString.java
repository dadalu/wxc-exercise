package leetcode.editor.cn;
//反转字符串中的元音字母	
//reverse-vowels-of-a-string	
//345
//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 示例 1: 
//
// 输入: "hello"
//输出: "holle"
// 
//
// 示例 2: 
//
// 输入: "leetcode"
//输出: "leotcede" 
//
// 说明: 
//元音字母不包含字母"y"。 
// Related Topics 双指针 字符串 
// 👍 111 👎 0

//Java：反转字符串中的元音字母
public class ReverseVowelsOfAString{
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
        String s = solution.reverseVowels("leetcode");
        System.out.println(s);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l=0,r=chars.length-1;
        while (l<r){
            if(!isVowels(chars[l])){
                l++;
                continue;
            }
            if(!isVowels(chars[r])){
                r--;
                continue;
            }
            char temp = chars[l];
            chars[l]=chars[r];
            chars[r]=temp;
            l++;
            r--;
        }
        return String.copyValueOf(chars);
    }
    boolean isVowels(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')return true;
        if(c=='A'||c=='E'||c=='I'||c=='O'||c=='U')return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
