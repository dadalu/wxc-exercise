package leetcode.editor.cn;
//修剪二叉搜索树
//给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以
//结果应当返回修剪好的二叉搜索树的新的根节点。 
//
// 示例 1: 
//
// 
//输入: 
//    1
//   / \
//  0   2
//
//  L = 1
//  R = 2
//
//输出: 
//    1
//      \
//       2
// 
//
// 示例 2: 
//
// 
//输入: 
//    3
//   / \
//  0   4
//   \
//    2
//   /
//  1
//
//  L = 1
//  R = 3
//
//输出: 
//      3
//     / 
//   2   
//  /
// 1
// 
// Related Topics 树 
// 👍 288 👎 0

public class TrimABinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new TrimABinarySearchTree().new Solution();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(0);
        node.right = new TreeNode(2);
        TreeNode ret = solution.trimBST(node,1,2);
        System.out.println(ret);

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
public static class TreeNode {
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null)return null;
        if(root.val<low){
            root.left = null;
            root =trimBST(root.right,low,high);
        }else if(root.val>high){
            root.right=null;
            root = trimBST(root.left,low,high);
        }else{
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}