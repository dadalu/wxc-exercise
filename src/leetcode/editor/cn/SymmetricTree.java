//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索

package leetcode.editor.cn;

import java.util.LinkedList;

public class  SymmetricTree{
    public static void main(String[] args){
        Solution solution = new SymmetricTree().new Solution();
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
    /**
     * 递归解法
     * @param root
     * @return
     */
    /*public boolean isSymmetric(TreeNode root) {

        return isSymmetric(root,root);
    }
    public  boolean isSymmetric(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null){
            return true;
        }
        if(node1==null||node2==null){
            return false;
        }
        return node1.val==node2.val&&isSymmetric(node1.left,node2.right)&&isSymmetric(node1.right,node2.left);
    }*/
    /**
     * 迭代
     */
    public boolean isSymmetric(TreeNode root) {

        LinkedList<TreeNode> list = new LinkedList();
        list.add(root);
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
