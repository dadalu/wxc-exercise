package leetcode.editor.cn;
//有效的字母异位词	题目标题	示例:两数之和
//valid-anagram	题目标记	示例:two-sum
//242	题目编号
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 220 👎 0

import java.util.HashMap;
import java.util.Map;

//Java：有效的字母异位词
public class P242ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new P242ValidAnagram().new Solution();
        //String s = "anagram", t = "nagaram";
        String s = "rat", t = "car";
        System.out.println(solution.isAnagram(s,t));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        if(chars1.length!=chars2.length)return false;
        Map<Character,Integer> map = new HashMap();
        for (char c1:chars1) {
            if(map.get(c1)!=null){
                map.put(c1,map.get(c1)+1);
            }else {
                map.put(c1,1);
            }

        }
        for (char c2:chars2) {
            if(map.get(c2)==null){
                return false;
            }else if(map.get(c2)>0){
                map.put(c2,map.get(c2)-1);
            }else{
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
