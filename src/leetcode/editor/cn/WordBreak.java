package leetcode.editor.cn;
//单词拆分
//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1130 👎 0

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak{
    public static void main(String[] args) {
        Solution solution = new WordBreak().new Solution();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        solution.wordBreak("wxc", list);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        //return wordBreak(s, new HashSet<>(wordDict), 0);

        return wordBreak(s, new HashSet<>(wordDict), 0,new Boolean[s.length()]);
    }
    //1.暴力,超时
    public boolean wordBreak(String s, HashSet<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreak(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }
    //回溯
    public boolean wordBreak(String s, HashSet<String> wordDict, int start,Boolean[] dp) {
        if (start == s.length()) {
            return true;
        }
        if (dp[start] != null) {
            return dp[start];
        }
        for (int i = start+1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start,i))) {
                if (wordBreak(s, wordDict, i,dp)) {
                    return dp[start] = true;
                }
            }
        }
        return dp[start] = false;
    }
    //动态规划
    /*public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }*/

}
//leetcode submit region end(Prohibit modification and deletion)

}