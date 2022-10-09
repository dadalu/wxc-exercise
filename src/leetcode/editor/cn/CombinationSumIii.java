package leetcode.editor.cn;
//组合总和 III
//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯 👍 351 👎 0

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIii{
    public static void main(String[] args) {
        Solution solution = new CombinationSumIii().new Solution();
        System.out.println(solution.combinationSum3(3, 17));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> retList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1,k, n);
        return retList;
    }

    private void dfs(int index, int k, int n) {
        if (k == 0 && n == 0) {
            retList.add(new ArrayList<>(list));
        }
        for (int i = index; i <= 9; i++) {
            if (n - i < 0) {
                return;
            }
            list.add(i);
            dfs(i+1,k - 1, n - i);
            list.remove(list.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}