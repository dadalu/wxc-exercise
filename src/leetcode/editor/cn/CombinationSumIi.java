package leetcode.editor.cn;
//组合总和 II
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 684 👎 0

import java.util.*;

public class CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(solution.combinationSum2(arr, 8));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        dfs(candidates,target,list,new ArrayList<>(),0);
        return list;
    }
    public void dfs(int[] candidates, int target,List<List<Integer>> list,List<Integer> childList,Integer index) {
        if (target == 0) {
            List tempList = new ArrayList<>(childList);
            list.add(tempList);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                if(i>index&&candidates[i]==candidates[i-1]){
                    continue;
                }
                childList.add(candidates[i]);
                dfs(candidates,target-candidates[i],list,childList,i+1);
                childList.remove(childList.size()-1);
            }
        }


    }
}

}