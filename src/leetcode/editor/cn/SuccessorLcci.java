package leetcode.editor.cn;
//后继者
//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。 
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//输出: null 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 69 👎 0

public class SuccessorLcci{
    public static void main(String[] args) {
        Solution solution = new SuccessorLcci().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {1qaz x-+-
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    TreeNode pre = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        return middleTraversal(root,p);
    }

    public TreeNode middleTraversal(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        TreeNode node = null;
        node = middleTraversal(root.left,p);
        if (node != null) {
            return node;
        }
        if (pre != null && pre.val == p.val) {
            return root;
        }
        pre = root;
        node = middleTraversal(root.right,p);
        if (node != null) {
            return node;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}