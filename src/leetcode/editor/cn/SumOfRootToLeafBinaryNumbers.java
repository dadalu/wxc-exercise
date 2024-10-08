package leetcode.editor.cn;
//从根到叶的二进制数之和
//给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 ->
// 0 -> 1，那么它表示二进制数 01101，也就是 13 。 
//
// 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。 
//
// 返回这些数字之和。题目数据保证答案是一个 32 位 整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,0,1,0,1,0,1]
//输出：22
//解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：root = [1,1]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 树中的结点数介于 1 和 1000 之间。 
// Node.val 为 0 或 1 。 
// 
// Related Topics 树 
// 👍 85 👎 0

public class SumOfRootToLeafBinaryNumbers{
    public static void main(String[] args) {
        Solution solution = new SumOfRootToLeafBinaryNumbers().new Solution();
        /*TreeNode node = new TreeNode(1);
        node.left = new TreeNode(0);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(1);
        solution.sumRootToLeaf(node);*/
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        rootToLeaf(root,0);
        return sum;
    }
    public void rootToLeaf(TreeNode root,int cur) {
        if (root == null) {
            return;
        }
        if (root.left == null&&root.right == null) {
            sum+=root.val+cur*2;
        } else {
            rootToLeaf(root.left,cur*2+root.val);
            rootToLeaf(root.right,cur*2+root.val);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}