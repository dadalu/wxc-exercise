package leetcode.editor.cn;
//最小高度树
//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。示例: 给定有序数组: [-10,-3,0,5,9], 一个可能
//的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：           0          / \        -3 
//  9        /   /      -10  5 Related Topics 树 深度优先搜索 
// 👍 74 👎 0

public class MinimumHeightTreeLcci{
    public static void main(String[] args) {
        Solution solution = new MinimumHeightTreeLcci().new Solution();
        int[] arr = {-10,-3,0,5,9};
        solution.sortedArrayToBST(arr);
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
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    TreeNode root = null;
    public TreeNode sortedArrayToBST(int[] nums) {
        return BST(0, nums.length-1, nums);
    }

    private TreeNode BST(int l,int r,int[]nums) {

        if (l <= r) {
            int mid = l + (r - l) / 2;
            TreeNode current = new TreeNode(nums[mid]);
            current.left = BST(l,mid-1,nums);
            current.right = BST(mid+1,r,nums);
            return current;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}