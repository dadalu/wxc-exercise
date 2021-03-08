package leetcode.editor.cn;
//划分字母区间
//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例： 
//
// 
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心算法 双指针 
// 👍 379 👎 0

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartitionLabels{
    public static void main(String[] args) {
        Solution solution = new PartitionLabels().new Solution();
        solution.partitionLabels("ababcbacadefegdehijhklij");
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ret = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        int gap = 0;
        for (int i = 0; i <= S.length(); i++) {
            int l=i,r=i;

            if(i>gap||gap==S.length()-1&&i==S.length()-1){
                ret.add(gap);
                set.clear();
                if(i==S.length()){
                    break;
                }
            }
            char c = S.charAt(i);

            if(!set.contains(c)){
                set.add(c);
                while (r<S.length()){
                    if(S.charAt(r)==c) {
                        l=r;
                    }
                    r++;
                }
                gap = Math.max(gap,l);
            }
        }
        for (int i = ret.size()-1; i >0; i--) {
            int temp = ret.remove(i);
            if (temp - ret.get(i - 1) != 0) {
                ret.add(i,temp-ret.get(i-1));

            }
        }
        ret.add(0,ret.remove(0)+1);
        return ret;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}