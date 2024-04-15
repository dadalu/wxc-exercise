package leetcode.editor.cn;
//组合
//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 👍 699 👎 0

import java.util.ArrayList;
import java.util.List;

public class Combinations{
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        System.out.println(solution.combine(4, 2));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    int max = 0;
    public List<List<Integer>> combine(int n, int k) {
        max = n;
        dfs(new ArrayList<>(),1,k);
        return ret;
    }
    public void dfs(List<Integer> list,Integer start,Integer k) {

        if (k == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }
        if (max - start < k-1) {
            return;
        }
        for (int i = start; i <= max; i++) {
            list.add(i);
            dfs(list,i+1,k-1);
            list.remove(list.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}