package leetcode.editor.cn;
//词典中最长的单词
//给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返
//回答案中字典序最小的单词。 
//
// 若无答案，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 输入：
//words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释： 
//单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
// 
//
// 示例 2： 
//
// 输入：
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释：
//"apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
// 
//
// 
//
// 提示： 
//
// 
// 所有输入的字符串都只包含小写字母。 
// words数组长度范围为[1,1000]。 
// words[i]的长度范围为[1,30]。 
// 
// Related Topics 字典树 哈希表 
// 👍 105 👎 0

import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary{
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionary().new Solution();
        String[] strings={"b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"};
        solution.longestWord(strings);
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestWord(String[] words) {
        int max = 0;
        String retStr = "";
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean f = true;
            for (int j = 0; j < word.length(); j++) {
                if(!set.contains(word.substring(0,j+1))){
                    f = false;
                    break;
                }
            }
            if(f){
                if(word.length()>max){
                    retStr = word;
                    max = retStr.length();
                }else if(word.length()==max){
                    retStr = retStr.compareTo(word)<0?retStr:word;
                    max = retStr.length();
                }
            }

        }
        return retStr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}