package leetcode.editor.cn;
//字符串中的第一个唯一字符
//first-unique-character-in-a-string	
//387
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 254 👎 0

import java.util.HashMap;
import java.util.Map;

//Java：字符串中的第一个唯一字符
public class FirstUniqueCharacterInAString{
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
        System.out.println(solution.firstUniqChar("dacca"));
        //System.out.println(solution.firstUniqChar("loveleetcode"));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap();
        if("".equals(s))return -1;
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i))!=null){
                map.put(s.charAt(i),-1);
            }else{
                map.put(s.charAt(i),i);
            }
        }
        Integer ret =null;
        for (char c:map.keySet()
             ) {
            if(map.get(c)==-1){
                continue;
            }else if(ret==null) {
                ret = map.get(c);
            }else if(map.get(c)<ret){
                ret = map.get(c);
            }
        }
        return ret!=null?ret:-1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}