package leetcode.editor.cn;
//二叉搜索树节点最小距离
//给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。 
//
// 
//
// 示例： 
//
// 输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树节点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \    
//    1   3  
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。 
//
// 
//
// 注意： 
//
// 
// 二叉树的大小范围在 2 到 100。 
// 二叉树总是有效的，每个节点的值都是整数，且不重复。 
// 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 
//相同 
// 
// Related Topics 树 递归 
// 👍 94 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumDistanceBetweenBstNodes {
    public static void main(String[] args) {
        Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
        //96,12,null,null,13,null,52,29,null,null,null
        TreeNode root = new TreeNode(96);
        root.left = new TreeNode(12);
        root.left.right = new TreeNode(13);
        root.left.right.right = new TreeNode(52);
        root.left.right.right.left = new TreeNode(29);
        solution.minDiffInBST(root);

    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        List<Integer> list = new ArrayList<>();

        public int minDiffInBST(TreeNode root) {
            min(root);
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < list.size(); i++) {
                min = Math.min(min,list.get(i)-list.get(i-1));
            }
            return min;
        }
        private void min(TreeNode root) {
            if(root.left!=null){
                min(root.left);
            }
            list.add(root.val);
            if(root.right!=null){
                min(root.right);
            }
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}