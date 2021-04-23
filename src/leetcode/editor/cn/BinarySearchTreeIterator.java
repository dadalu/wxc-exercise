package leetcode.editor.cn;
//二叉搜索树迭代器
//实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。 
//
// 调用 next() 将返回二叉搜索树中的下一个最小的数。 
//
// 
//
// 示例： 
//
// 
//
// BSTIterator iterator = new BSTIterator(root);
//iterator.next();    // 返回 3
//iterator.next();    // 返回 7
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 9
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 15
//iterator.hasNext(); // 返回 true
//iterator.next();    // 返回 20
//iterator.hasNext(); // 返回 false 
//
// 
//
// 提示： 
//
// 
// next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。 
// 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。 
// 
// Related Topics 栈 树 设计 
// 👍 344 👎 0


import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator{
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
class BSTIterator {
    private TreeNode root;
    private List<TreeNode> iterator = new ArrayList<>();
    private List<TreeNode> list = new ArrayList<>();
    private int curIndex = -1;
    public BSTIterator(TreeNode root) {
        this.root = root;
        /*if (root != null) {
            middleIterator(root);
        }*/
        while (root != null||!list.isEmpty()) {
            while (root != null) {
                list.add(root);
                root = root.left;
            }
            root = list.remove(list.size() - 1);
            iterator.add(root);
            root = root.right;
        }
    }

    public void middleIterator(TreeNode root) {
        if (root.left != null) {
            middleIterator(root.left);
        }
        iterator.add(root);
        if (root.right != null) {
            middleIterator(root.right);
        }
    }
    
    public int next() {
        if (curIndex == -1) {
            curIndex = 0;
        } else {
            curIndex++;
        }
        return iterator.get(curIndex).val;
    }
    
    public boolean hasNext() {
        return curIndex<iterator.size()-1;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

}