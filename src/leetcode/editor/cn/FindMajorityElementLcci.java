package leetcode.editor.cn;
//主要元素
//数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1
//) 的解决方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,5,9,5,9,5,5,5]
//输出：5 
//
// 示例 2： 
//
// 
//输入：[3,2]
//输出：-1 
//
// 示例 3： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2 
// Related Topics 数组 计数 
// 👍 84 👎 0

import java.util.HashMap;
import java.util.Map;

public class FindMajorityElementLcci{
    public static void main(String[] args) {
        Solution solution = new FindMajorityElementLcci().new Solution();
        int[] arr = {2,2,2,2,1,1,1};
        solution.majorityElement(arr);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map =new HashMap<>();
        for (int n :
                nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Map.Entry<Integer, Integer> e = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()
        ) {
            e = e == null ? entry : e.getValue() > entry.getValue() ? e : entry;
        }
        return e.getValue() >= (nums.length+1) / 2 ? e.getKey() : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}