package leetcode.editor.cn;
//没有重复元素集合的全排列
//给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。 
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
//
// 
//
// 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/ 
// Related Topics 数组 回溯 
// 👍 7 👎 0

import java.util.ArrayList;
import java.util.List;

public class VvJkup{
    public static void main(String[] args) {
        Solution solution = new VvJkup().new Solution();
        int[] arr = {1,2,3};
        System.out.println(solution.permute(arr));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        List<Integer> curList = new ArrayList<>();
        dfs(curList,nums);
        return list;
    }
    public void dfs(List<Integer> curList,int[] nums) {
        if (curList.size() == nums.length) {
            list.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == false) {
                curList.add(nums[i]);
                visited[i] = true;
                dfs(curList, nums);
                curList.remove(curList.size() - 1);
                visited[i] = false;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}