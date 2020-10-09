package leetcode.editor.cn;
//合并二叉树
//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 
// 👍 544 👎 0

public class MergeTwoBinaryTrees{
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();
        TreeNode lnode = new TreeNode(1);
         lnode.left = new TreeNode(3);
         lnode.right = new TreeNode(2);
         lnode.left.left = new TreeNode(5);
        TreeNode rnode = new TreeNode(2);
         rnode.left = new TreeNode(1);
         rnode.right = new TreeNode(3);
         rnode.left.right = new TreeNode(4);
         rnode.right.right = new TreeNode(7);
        TreeNode node = solution.mergeTrees(lnode,rnode);
        System.out.println(node);
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
    TreeNode ret;
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode node = null;
        if(t1==null&&t2==null){
            node = null;
        }else if(t1==null){
            node = t2;
        }else if(t2==null){
            node = t1;
        }else{
            node = new TreeNode(t1.val+t2.val);
            node.left = mergeTrees(t1.left,t2.left);
            node.right = mergeTrees(t1.right,t2.right);
        }

        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}