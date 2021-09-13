package leetcode.editor.cn;
//子集 II
//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// 
// 
// 
// Related Topics 位运算 数组 回溯 👍 648 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsIi{
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        int[] arr = {1,2,2,3,4,5,5,4};
        System.out.println(solution.subsetsWithDup(arr));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, retList, new ArrayList<>(), 0,false);
        return retList;
    }

    private void dfs(int[] nums, List<List<Integer>> retList, List<Integer> list, int index,boolean preChoose) {

        if (index == nums.length) {
            retList.add(new ArrayList<>(list));
            return;
        }
        dfs(nums, retList, list, index + 1,false);
        if (!preChoose&&index > 0 && nums[index] == nums[index - 1]) {
            return;
        }
        list.add(nums[index]);
        dfs(nums, retList, list, index + 1,true);
        list.remove(list.size() - 1);
    }



    /*public void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        dfs(false, cur + 1, nums);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        t.add(nums[cur]);
        dfs(true, cur + 1, nums);
        t.remove(t.size() - 1);
    }*/

}
//leetcode submit region end(Prohibit modification and deletion)

}