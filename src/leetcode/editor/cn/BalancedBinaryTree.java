//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;


public class  BalancedBinaryTree{
    public static void main(String[] args){
        Solution solution = new BalancedBinaryTree().new Solution();
        TreeNode node = new TreeNode(1);
        node.left= new TreeNode(2);
        node.right= new TreeNode(2);
        node.left.left= new TreeNode(3);
        node.left.right= new TreeNode(3);
        node.left.left.left= new TreeNode(4);
        node.left.left.right= new TreeNode(4);
        boolean b = solution.isBalanced(node);
        System.out.println(b);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**二刷
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
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        if(root.left==null&&root.right==null)return true;
        return isBalanced(root.left)&&isBalanced(root.right)&&Math.abs(heigh(root.left)-heigh(root.right))<2;
    }
    int heigh(TreeNode node){
        if(node==null){
            return -1;
        }
        int lheigh = heigh(node.left);
        int rheigh = heigh(node.right);
        return Math.max(lheigh,rheigh)+1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
