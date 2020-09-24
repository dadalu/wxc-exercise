package leetcode.editor.cn;
//键盘行
//给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。 
//
// 
//
// 
//
// 
//
// 示例： 
//
// 输入: ["Hello", "Alaska", "Dad", "Peace"]
//输出: ["Alaska", "Dad"]
// 
//
// 
//
// 注意： 
//
// 
// 你可以重复使用键盘上同一字符。 
// 你可以假设输入的字符串将只包含字母。 
// Related Topics 哈希表 
// 👍 107 👎 0

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyboardRow{
    public static void main(String[] args) {
        Solution solution = new KeyboardRow().new Solution();
        String[] arr = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(solution.findWords(arr));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findWords(String[] words) {
        String s1="qwertyuiop";
        String s2="asdfghjkl";
        String s3="zxcvbnm";
        Set set1 = new HashSet();
        Set set2 = new HashSet();
        Set set3 = new HashSet();
        for (int i = 0; i < s1.length(); i++) {
            set1.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            set2.add(s2.charAt(i));
        }
        for (int i = 0; i < s3.length(); i++) {
            set3.add(s3.charAt(i));
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            Set set =null;
            String s = words[i].toLowerCase();
            if(set1.contains(s.charAt(0)))set = set1;
            if(set2.contains(s.charAt(0)))set = set2;
            if(set3.contains(s.charAt(0)))set = set3;
            for (int j = 0; j < s.length(); j++) {
                if(!set.contains(s.charAt(j))){
                    flag = false;
                    break;
                }
            }
            if(flag)list.add(words[i]);
        }
        String[] retArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            retArr[i]=list.get(i);
        }
        return retArr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}