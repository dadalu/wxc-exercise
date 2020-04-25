//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索

package leetcode.editor.cn;
public class  MinimumDepthOfBinaryTree{
    public static void main(String[] args){
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
        TreeNode node = new TreeNode(3);
        TreeNode node1 = node;
        for (int i = 0; i < 5; i++) {
            node.left=new TreeNode(i+1);
            node=node.left;
        }
       /* node.left = new TreeNode(9);
        node.right = new TreeNode(9);
        *//*node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);*/
        int i = solution.minDepth(node1);
        System.out.println(i);
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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left!=null&&root.right==null) return minDepth(root.left)+1;
        if(root.left==null&&root.right!=null) return minDepth(root.right)+1;
        int lmin=0;
        int rmin=0;


        lmin = minDepth(root.left);
        rmin = minDepth(root.right);
        return Math.min(lmin,rmin)+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
