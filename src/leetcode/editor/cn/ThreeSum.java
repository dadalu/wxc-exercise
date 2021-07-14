//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针

package leetcode.editor.cn;

import java.util.*;

public class  ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] arr = {-2, 0, 0,2,2};
        solution.threeSum(arr);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0) {
                break;
            }
            if(i>0&&nums[i]==nums[i-1]) {
                continue;
            }
            int L =i + 1;
            int R =nums.length - 1;

            while(L < R){
                int sum = nums[i]+nums[L]+nums[R];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while(L<R&&nums[L]==nums[L+1]) {
                        L++;
                    }
                    while(L<R&&nums[R]==nums[R-1]) {
                        R--;
                    }
                    L++;
                    R--;
                }
                else{
                    if(sum<0) {
                        L++;
                    } else {
                        R--;
                    }
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
