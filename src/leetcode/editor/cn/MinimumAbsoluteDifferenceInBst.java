package leetcode.editor.cn;
//二叉搜索树的最小绝对差
//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 
// 👍 139 👎 0

import java.util.*;

public class MinimumAbsoluteDifferenceInBst{
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
        //236,104,701,null,227,null,911
        //543,384,652,null,445,null,699
        //1476,1054,null,1,null,null,215,null,745


    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    List<Integer> list = new ArrayList();
    public int getMinimumDifference(TreeNode root) {
        min(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min,list.get(i)-list.get(i-1));
        }
        return min;
    }
    public void min(TreeNode root){
        if(root!=null){
            getMinimumDifference(root.left);
            list.add(root.val);
            getMinimumDifference(root.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}