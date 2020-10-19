package leetcode.editor.cn;
//数组的度
//degree-of-an-array	
//697
//给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 示例 1: 
//
// 
//输入: [1, 2, 2, 3, 1]
//输出: 2
//解释: 
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2: 
//
// 
//输入: [1,2,2,3,1,4,2]
//输出: 6
// 
//
// 注意: 
//
// 
// nums.length 在1到50,000区间范围内。 
// nums[i] 是一个在0到49,999范围内的整数。 
// 
// Related Topics 数组 
// 👍 174 👎 0

import java.util.*;

//Java：数组的度
public class DegreeOfAnArray{
    public static void main(String[] args) {
        Solution solution = new DegreeOfAnArray().new Solution();
        int[] arr = {1,2,2,3,4};
        System.out.println(solution.findShortestSubArray(arr));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])!=null){
                map.get(nums[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i],list);
            }
        }
        int max=0;
        int maxLen=0;
        Iterator<List<Integer>> iterator = map.values().iterator();
        while (iterator.hasNext()){
            List<Integer> list = iterator.next();
            if(list.size()>max){
                max = list.size();
                maxLen = list.get(list.size()-1)-list.get(0)+1;
            }else if(list.size()==max){
                maxLen = Math.min(maxLen,list.get(list.size()-1)-list.get(0)+1);
            }
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}