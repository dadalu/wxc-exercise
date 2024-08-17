package leetcode.editor.cn;
//找不同
//find-the-difference	
//389
//给定两个字符串 s 和 t，它们只包含小写字母。 
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例: 
//
// 输入：
//s = "abcd"
//t = "abcde"
//
//输出：
//e
//
//解释：
//'e' 是那个被添加的字母。
// 
// Related Topics 位运算 哈希表 
// 👍 149 👎 0

import java.util.HashMap;
import java.util.Map;

//Java：找不同
public class FindTheDifference{
    public static void main(String[] args) {
        Solution solution = new FindTheDifference().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        char c = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < t.length(); i++) {
            if(map.get(t.charAt(i))==null||map.get(t.charAt(i))==0){
                return t.charAt(i);
            }else if(map.get(t.charAt(i))>0){
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
            }
        }
        return c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}