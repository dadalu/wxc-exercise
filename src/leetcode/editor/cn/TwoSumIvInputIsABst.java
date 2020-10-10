package leetcode.editor.cn;
//两数之和 IV - 输入 BST
//给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。 
//
// 案例 1: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 9
//
//输出: True
// 
//
// 
//
// 案例 2: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 28
//
//输出: False
// 
//
// 
// Related Topics 树 
// 👍 181 👎 0

import java.util.HashSet;
import java.util.Set;

public class TwoSumIvInputIsABst{
    public static void main(String[] args) {
        Solution solution = new TwoSumIvInputIsABst().new Solution();
        
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
    Set<Integer> set = new HashSet();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)return false;
        int sub = k-root.val;
        if(set.contains(sub)){
            return true;
        }else{
            set.add(root.val);
            return findTarget(root.left,k)||findTarget(root.right,k);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}