package leetcode.editor.cn;
//从中序与后序遍历序列构造二叉树
//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 521 👎 0

import java.util.ArrayList;
import java.util.List;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        
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
public class TreeNode {
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return new TreeNode();
        } else if (postorder.length == 1) {
            return new TreeNode(postorder[0]);
        }
        List<Integer> post = new ArrayList<>();
        for (int i = 0; i < postorder.length; i++) {
            post.add(postorder[i]);
        }
        List<Integer> in = new ArrayList<>();
        for (int i = 0; i < inorder.length; i++) {
            in.add(inorder[i]);
        }
        return dfs(in,post);
    }
    public TreeNode dfs(List<Integer> in, List<Integer> post) {
        List<Integer> leftPre = new ArrayList<>();
        List<Integer> leftIn = new ArrayList<>();
        Integer val = null;
        while (!in.isEmpty()) {
            val = in.remove(0);
            if (val - post.get(post.size()-1)==0) {
                break;
            }
            leftIn.add(val);
        }
        TreeNode root = null;

        if (!post.isEmpty()) {
            root = new TreeNode(post.remove(post.size()-1));
        } else {
            return root;
        }

        for (int i = 0; i < leftIn.size(); i++) {
            leftPre.add(post.remove(0));
        }
        root.left = dfs(leftIn, leftPre);
        root.right = dfs(in, post);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}