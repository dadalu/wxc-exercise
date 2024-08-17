package leetcode.editor.cn;
//二叉树的直径
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 492 👎 0

public class DiameterOfBinaryTree{
    TreeNode node = new TreeNode(1);

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        Solution solution = new DiameterOfBinaryTree().new Solution();
        System.out.println(solution.diameterOfBinaryTree(node));
        
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
    int len = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return len;
        if(root.left==null&&root.right==null) return len;
        dia(root);
        return len-1;
    }
    public int dia(TreeNode root){
        if(root == null){
            return 0;
        }
        int lDep = dia(root.left);

        int rDep = dia(root.right);

        len = Math.max(len,lDep+rDep+1);
        return Math.max(lDep,rDep)+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}