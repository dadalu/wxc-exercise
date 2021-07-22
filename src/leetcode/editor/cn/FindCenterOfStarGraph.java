package leetcode.editor.cn;
//找出星型图的中心节点
//有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。 
//
// 给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 
//所表示星型图的中心节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：edges = [[1,2],[2,3],[4,2]]
//输出：2
//解释：如上图所示，节点 2 与其他每个节点都相连，所以节点 2 是中心节点。
// 
//
// 示例 2： 
//
// 
//输入：edges = [[1,2],[5,1],[1,3],[1,4]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 3 <= n <= 105 
// edges.length == n - 1 
// edges[i].length == 2 
// 1 <= ui, vi <= n 
// ui != vi 
// 题目数据给出的 edges 表示一个有效的星型图 
// 
// Related Topics 图 
// 👍 7 👎 0

import java.util.HashMap;
import java.util.Map;

public class FindCenterOfStarGraph{
    public static void main(String[] args) {
        Solution solution = new FindCenterOfStarGraph().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr;
        for (int i = 0; i < edges.length; i++) {
            arr = edges[i];
            map.put(arr[0], map.getOrDefault(arr[0], 0) + 1);
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry:
             map.entrySet()) {
            if (entry.getValue() == map.size() - 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}