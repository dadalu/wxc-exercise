package leetcode.editor.cn;
//字符的最短距离
//给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。 
//
// 示例 1: 
//
// 
//输入: S = "loveleetcode", C = 'e'
//输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
// 
//
// 说明: 
//
// 
// 字符串 S 的长度范围为 [1, 10000]。 
// C 是一个单字符，且保证是字符串 S 里的字符。 
// S 和 C 中的所有字母均为小写字母。 
// 
// 👍 162 👎 0

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShortestDistanceToACharacter{
    public static void main(String[] args) {
        Solution solution = new ShortestDistanceToACharacter().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] ret = new int[S.length()];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i)==C){
                set.add(i);
            }
        }
        for (int i = 0; i < S.length(); i++) {
            int min = Integer.MAX_VALUE;
            for (Integer in :
                    set) {
                min = Math.min(min,Math.abs(i-in));
            }
            ret[i] = min;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}