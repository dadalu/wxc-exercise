package leetcode.editor.cn;
//二叉树的后序遍历
//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 550 👎 0

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal{
    public static void main(String[] args) {

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> retList = new ArrayList<>();

        if (root == null) {
            return retList;
        }
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        list1.add(root);
        while (list1.size() > 0) {
            TreeNode node = list1.remove(list1.size() - 1);
            if (node.left != null) {
                list1.add(node.left);
            }
            if (node.right != null) {
                list1.add(node.right);
            }
            list2.add(node);
        }
        while (list2.size() > 0) {
            TreeNode node = list2.remove(list2.size() - 1);
            retList.add(node.val);
        }
        return retList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}