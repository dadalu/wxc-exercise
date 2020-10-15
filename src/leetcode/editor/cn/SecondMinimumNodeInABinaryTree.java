package leetcode.editor.cn;
//二叉树中第二小的节点
//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。 
//
// 示例 1: 
//
// 输入: 
//    2
//   / \
//  2   5
//     / \
//    5   7
//
//输出: 5
//说明: 最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2: 
//
// 输入: 
//    2
//   / \
//  2   2
//
//输出: -1
//说明: 最小的值是 2, 但是不存在第二小的值。
// 
// Related Topics 树 
// 👍 117 👎 0

public class SecondMinimumNodeInABinaryTree{
    public static void main(String[] args) {
        Solution solution = new SecondMinimumNodeInABinaryTree().new Solution();
        
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
    int min = Integer.MAX_VALUE;
    int smin = Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null){
            return -1;
        }else{
            min=root.val;
            int ret = findSecond(root);
            return min==ret?-1:smin;
        }

    }
    public int findSecond(TreeNode root){
        if(root.left==null){
            return root.val;
        }else{
            if(root.val<root.left.val){
                smin = Math.min(root.left.val,smin);
                int ls = findSecond(root.right);
                if(ls==min){
                    return root.left.val;
                }else{
                    return Math.min(ls,smin);
                }
            }else if(root.val<root.right.val){
                smin = Math.min(root.right.val,smin);
                int rs = findSecond(root.left);
                if(rs==min){
                    return root.right.val;
                }else{
                    return Math.min(rs,smin);
                }
            }else{
                return Math.min(findSecond(root.left),findSecond(root.right));
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}