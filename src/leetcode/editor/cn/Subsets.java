package leetcode.editor.cn;
//子集
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1312 👎 0

import java.util.ArrayList;
import java.util.List;

public class Subsets{
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        int[] arr = {1,2,3,4,5};
        System.out.println(solution.subsets(arr));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,ret, new ArrayList<>(),0);
        return ret;
    }

    private void dfs(int[] nums, List<List<Integer>> ret, List<Integer> es, int index) {
        if (index == nums.length) {
            ret.add(new ArrayList<>(es));
            return;
        }

        List<Integer> temp=  new ArrayList<>(es);
        temp.add(nums[index]);
        dfs(nums,ret, temp,index+1);
        dfs(nums,ret, es,index+1);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}