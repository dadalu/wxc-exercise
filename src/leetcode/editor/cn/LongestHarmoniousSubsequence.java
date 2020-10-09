package leetcode.editor.cn;
//最长和谐子序列
//和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。 
//
// 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,2,5,2,3,7]
//输出: 5
//原因: 最长的和谐数组是：[3,2,2,2,3].
// 
//
// 说明: 输入的数组长度最大不超过20,000. 
// Related Topics 哈希表 
// 👍 125 👎 0

import java.util.*;

public class LongestHarmoniousSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestHarmoniousSubsequence().new Solution();
        int[] arr = {1,3,2,2,5,2,3,7};
        System.out.println(solution.findLHS(arr));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLHS(int[] nums) {
        int maxlen = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])!=null){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
            //maxlen = Math.max(maxlen,map.get(nums[i]));
            if(map.containsKey(nums[i]-1)){
                maxlen = Math.max(maxlen,map.get(nums[i])+map.get(nums[i]-1));
            }
            if(map.containsKey(nums[i]+1)){
                maxlen = Math.max(maxlen,map.get(nums[i])+map.get(nums[i]+1));
            }
        }

        return maxlen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}