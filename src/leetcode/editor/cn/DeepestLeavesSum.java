package leetcode.editor.cn;
//层数最深叶子节点的和
//给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//输出：15
// 
//
// 示例 2： 
//
// 
//输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：19
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 之间。 
// 1 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 133 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DeepestLeavesSum{
    public static void main(String[] args) {
        Solution solution = new DeepestLeavesSum().new Solution();
        
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
    public int deepestLeavesSum(TreeNode root) {
        List<TreeNode> list = List.of(root);
        return gfs(list);
    }

    private int gfs(List<TreeNode> list) {
        List<TreeNode> newList = new ArrayList<>();
        list.forEach(item ->{
            if (item.left != null) {
                newList.add(item.left);
            }
            if (item.right != null) {
                newList.add(item.right);
            }
        });
        if (newList.isEmpty()) {
            AtomicInteger ret = new AtomicInteger();
            list.forEach(item -> ret.addAndGet(item.val));
            return ret.get();
        } else {
            return gfs(newList);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}