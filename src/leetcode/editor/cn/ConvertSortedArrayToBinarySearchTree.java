//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索

package leetcode.editor.cn;
public class  ConvertSortedArrayToBinarySearchTree{
    public static void main(String[] args){
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        TreeNode node = solution.sortedArrayToBST(nums);
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
    public TreeNode sortedArrayToBST(int[] nums) {
        int r=nums.length-1;
        int l=0;
        return BST(nums,l,r);
    }

    private TreeNode BST(int[] nums,int l,int r){
        if(l>r)return null;
        int p = l+(r-l)/2;
        TreeNode node = new TreeNode(nums[p]);
        node.left = BST(nums,l,p-1);
        node.right = BST(nums,p+1,r);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
