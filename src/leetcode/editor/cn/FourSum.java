package leetcode.editor.cn;
//四数之和
//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意：答案中不可以包含重复的四元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [], target = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 898 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum{
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        int[] arr = {4,-9,-2,-2,-7,9,9,5,10,-10,4,5,2,-4,-2,4,-9,5};
        solution.fourSum(arr, -13);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List retList = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {

                if (j > i+1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length-1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        List<Integer> subList = new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[j]);
                        subList.add(nums[l]);
                        subList.add(nums[r]);
                        retList.add(subList);
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r-1] == nums[r]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if(sum>target){
                        r--;
                    } else if(sum<target){
                        l++;
                    }
                }

            }
        }
        return retList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}