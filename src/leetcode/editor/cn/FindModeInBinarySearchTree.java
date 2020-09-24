package leetcode.editor.cn;
//二叉搜索树中的众数
//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 201 👎 0

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        solution.findMode(root);
        
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
    int val,count,max;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        if(root==null) return new int[0];
        mid(root);
        int[] retArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            retArr[i] = list.get(i);
        }
        return retArr;
    }
    public void mid(TreeNode root){
        TreeNode cur = root,pre =null;
        if(cur.left!=null){
            mid(cur.left);
        }
        update(root.val);
        if(cur.right!=null){
            mid(cur.right);
        }
    }
    public void update(int val){
        if(this.val ==val){
            count++;
        }else{
            count = 1;
            this.val = val;
        }
        if(count==max){
            list.add(val);
        }else if(count>max){
            max = count;
            list.clear();
            list.add(val);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}