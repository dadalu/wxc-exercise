package leetcode.editor.cn;
//所有可能的真二叉树
//all-possible-full-binary-trees	
//894
//给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。 
//
// 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。 
//
// 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 7
//输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0
//,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：[[0,0,0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// 👍 379 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：所有可能的真二叉树
public class AllPossibleFullBinaryTrees{
    public static void main(String[] args) {
        Solution solution = new AllPossibleFullBinaryTrees().new Solution();
        // TO TEST
        solution.allPossibleFBT(7);
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
    List<TreeNode> list = new ArrayList<>();
    List<TreeNode> bfsList = new ArrayList<>();
    TreeNode root;
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return list;
        }
        root = new TreeNode(0);
        if (n - 1 == 0) {
            return list;
        }
        bfsList.add(root);
        allPossibleFBT(root, n - 1);
        return list;
    }
    public void allPossibleFBT(TreeNode node, int n) {
        while (bfsList.size() > 0) {
            TreeNode tail = bfsList.remove(list.size() - 1);
            if (n > 0) {
                tail.left = new TreeNode(0);
                tail.right = new TreeNode(0);
            } else {
                list.add(copy(tail));
            }
        }



    }

    public TreeNode copy(TreeNode node) {
        TreeNode ret = new TreeNode(0);
        if (node.left != null) {
            ret.left = copy(node.left);
        }
        if (node.right != null) {
            ret.right = copy(node.right);
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}