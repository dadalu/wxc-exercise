package leetcode.editor.cn;
//全排列 II
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 794 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        int[] arr = {1, 1, 2};
        System.out.println(solution.permuteUnique(arr));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if (i!=0&&nums.get(i).equals(nums.get(i - 1))) {
                continue;
            }
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