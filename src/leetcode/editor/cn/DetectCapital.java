package leetcode.editor.cn;
//检测大写字母
//给定一个单词，你需要判断单词的大写使用是否正确。 
//
// 我们定义，在以下情况时，单词的大写用法是正确的： 
//
// 
// 全部字母都是大写，比如"USA"。 
// 单词中所有字母都不是大写，比如"leetcode"。 
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。 
// 
//
// 否则，我们定义这个单词没有正确使用大写字母。 
//
// 示例 1: 
//
// 
//输入: "USA"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "FlaG"
//输出: False
// 
//
// 注意: 输入是由大写和小写拉丁字母组成的非空单词。 
// Related Topics 字符串 
// 👍 109 👎 0

public class DetectCapital{
    public static void main(String[] args) {
        Solution solution = new DetectCapital().new Solution();
        System.out.println(solution.detectCapitalUse("USA"));
        System.out.println(solution.detectCapitalUse("Usa"));
        System.out.println(solution.detectCapitalUse("UsA"));
        System.out.println(solution.detectCapitalUse("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFf"));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean detectCapitalUse(String word) {
        boolean isUpBegin = false;
        boolean isContainsLow = false;
        boolean isContainsUp = false;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(i==0){
                if(c>=65&&c<=90){
                    isUpBegin = true;
                }
            }
            if(!isContainsLow){
                if(c>=97&&c<=122){
                    isContainsLow = true;
                }
            }
            if(i!=0&&!isContainsUp){
                if(c>=65&&c<=90){
                    isContainsUp = true;
                }
            }
        }
        return !(isContainsLow&&isContainsUp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}