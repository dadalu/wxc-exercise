package leetcode.editor.cn;
//全排列
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1538 👎 0

import java.util.ArrayList;
import java.util.List;

public class Permutations{
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        int[] arr = {1, 2, 3};
        System.out.println(solution.permute(arr));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list1.add(nums[i]);
        }
        dfs(list1,list, new ArrayList<>());
        return list;
    }
    public void dfs(List<Integer> nums,List<List<Integer>> list,List<Integer> childList) {
        if (nums.isEmpty()) {
            list.add(childList);
            return;
        }
        List<Integer> tempList;
        List<Integer> newList;
        for (int i = 0; i < nums.size(); i++) {
            tempList = new ArrayList<>(childList);
            tempList.add(nums.get(i));
            newList = new ArrayList<>(nums);
            newList.remove(i);
            dfs(newList,list, tempList);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}