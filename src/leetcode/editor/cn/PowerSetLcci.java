package leetcode.editor.cn;
//幂集
//幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
//  输入： nums = [1,2,3]
// 输出：
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// 
// Related Topics 位运算 数组 回溯 
// 👍 70 👎 0

import java.util.ArrayList;
import java.util.List;

public class PowerSetLcci{
    public static void main(String[] args) {
        Solution solution = new PowerSetLcci().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //普通解法
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = ret.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList<>(ret.get(j));
                list.add(nums[i]);
                ret.add(list);
            }
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}