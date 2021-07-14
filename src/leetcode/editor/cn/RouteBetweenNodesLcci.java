package leetcode.editor.cn;
//节点间通路
//节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。 
//
// 示例1: 
//
//  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
// 输出：true
// 
//
// 示例2: 
//
//  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [
//1, 3], [2, 3], [3, 4]], start = 0, target = 4
// 输出 true
// 
//
// 提示： 
//
// 
// 节点数量n在[0, 1e5]范围内。 
// 节点编号大于等于 0 小于 n。 
// 图中可能存在自环和平行边。 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 
// 👍 37 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RouteBetweenNodesLcci{
    public static void main(String[] args) {
        Solution solution = new RouteBetweenNodesLcci().new Solution();
        int[][] arr = {{0, 1}, {0, 3}, {0, 10}, {0, 18}, {1, 2}, {1, 7}, {1, 11}, {1, 12}, {2, 4}, {2, 5}, {2, 13}, {2, 16}, {3, 6}, {3, 8}, {4, 9}, {5, 17}, {7, 20}, {7, 22}, {8, 10}, {10, 19}, {11, 15}, {13, 14}, {14, 21}, {15, 23}, {19, 24}, {20, 22}};
        int[][] arr1 = {{0, 1}, {0, 3}, {0, 6}, {0, 7}, {0, 28}, {1, 2}, {2, 44}, {2, 59}, {3, 4}, {3, 13}, {3, 14}, {3, 17}, {4, 5}, {4, 8}, {4, 10}, {4, 11}, {5, 16}, {5, 20}, {5, 25}, {6, 29}, {6, 36}, {6, 41}, {7, 9}, {7, 21}, {7, 37}, {9, 12}, {9, 19}, {9, 30}, {10, 39}, {12, 18}, {12, 22}, {12, 34}, {13, 32}, {14, 15}, {14, 35}, {15, 24}, {15, 51}, {16, 23}, {16, 27}, {17, 61}, {20, 31}, {21, 63}, {22, 33}, {23, 42}, {24, 26}, {24, 40}, {25, 60}, {27, 46}, {29, 48}, {29, 49}, {30, 45}, {30, 53}, {31, 38}, {33, 47}, {33, 55}, {33, 57}, {34, 52}, {37, 58}, {39, 43}, {39, 44}, {43, 62}, {46, 56}, {47, 50}, {51, 54}};
        int[][] arr2 = {{0, 1}, {1, 2}, {1, 3}, {1, 10}, {1, 11}, {1, 4}, {2, 4}, {2, 6}, {2, 9}, {2, 10}, {2, 4}, {2, 5}, {2, 10}, {3, 7}, {3, 7}, {4, 5}, {4, 11}, {4, 11}, {4, 10}, {5, 7}, {5, 10}, {6, 8}, {7, 11}, {8, 10}};
        System.out.println(solution.findWhetherExistsPath(12, arr2, 2, 3));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Set set;
        for (int i = 0; i < graph.length; i++) {
            set = map.getOrDefault(graph[i][0], new HashSet<>());
            set.add(graph[i][1]);
            map.put(graph[i][0], set);
        }
        return dfs(start, target);
    }

    public boolean dfs(Integer start,Integer end) {
        if (map.get(start) == null) {
            return false;
        }
        boolean b = false;
        Set<Integer> res = map.get(start);
        if (res.contains(end)) {
            return true;
        } else {
            for (Integer i : res) {
                b = dfs(i, end);
                if (b == true) {
                    return true;
                }
            }
        }
        return b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}