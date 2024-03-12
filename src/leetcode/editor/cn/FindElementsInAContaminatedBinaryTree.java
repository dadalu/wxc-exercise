package leetcode.editor.cn;
//在受污染的二叉树中查找元素
//find-elements-in-a-contaminated-binary-tree	
//1261
//给出一个满足下述规则的二叉树： 
//
// 
// root.val == 0 
// 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 
//1 
// 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x 
//+ 2 
// 
//
// 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。 
//
// 请你先还原二叉树，然后实现 FindElements 类： 
//
// 
// FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。 
// bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：
//["FindElements","find","find"]
//[[[-1,null,-1]],[1],[2]]
//输出：
//[null,false,true]
//解释：
//FindElements findElements = new FindElements([-1,null,-1]); 
//findElements.find(1); // return False 
//findElements.find(2); // return True 
//
// 示例 2： 
//
// 
//
// 输入：
//["FindElements","find","find","find"]
//[[[-1,-1,-1,-1,-1]],[1],[3],[5]]
//输出：
//[null,true,true,false]
//解释：
//FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
//findElements.find(1); // return True
//findElements.find(3); // return True
//findElements.find(5); // return False 
//
// 示例 3： 
//
// 
//
// 输入：
//["FindElements","find","find","find","find"]
//[[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
//输出：
//[null,true,false,false,true]
//解释：
//FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
//findElements.find(2); // return True
//findElements.find(3); // return False
//findElements.find(4); // return False
//findElements.find(5); // return True
// 
//
// 
//
// 提示： 
//
// 
// TreeNode.val == -1 
// 二叉树的高度不超过 20 
// 节点的总数在 [1, 10^4] 之间 
// 调用 find() 的总次数在 [1, 10^4] 之间 
// 0 <= target <= 10^6 
// 
//
// 👍 59 👎 0

import java.util.*;

//Java：在受污染的二叉树中查找元素
public class FindElementsInAContaminatedBinaryTree{
    public static void main(String[] args) {
//        List<Integer> data = Arrays.asList(-1, -1, -1, null, null, -1, -1, -1, -1, -1, -1, null, -1, null, -1, -1, null, -1, -1, -1, null, null, -1, -1, -1, -1, -1, null, -1, null, null, null, null, -1, null, -1, null, null, null, null, -1, null, null, null, -1, -1, -1, -1, -1, -1);
//        TreeNode root = deserialize(data);
//        FindElements findElements = new FindElements(root);
//        boolean find = findElements.find(23);
    }
    // 解析实体数据并实例化二叉树
//    public static TreeNode deserialize(List<Integer> data) {
//        if (data == null || data.isEmpty()) {
//            return null;
//        }
//
//        TreeNode root = new TreeNode(data.get(0));
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        int i = 1;
//        while (!queue.isEmpty() && i < data.size()) {
//            TreeNode node = queue.poll();
//            if (data.get(i) != null) {
//                node.left = new TreeNode(data.get(i));
//                queue.offer(node.left);
//            }
//            i++;
//            if (i < data.size() && data.get(i) != null) {
//                node.right = new TreeNode(data.get(i));
//                queue.offer(node.right);
//            }
//            i++;
//        }
//        return root;
//    }
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
  class FindElements {
    private TreeNode node;
    int i = 0;
     Set<Integer> set = new HashSet<>();
    public FindElements(TreeNode root) {
        root.val = 0;
        set.add(0);
        this.node = root;
        gen(root);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }

    private void gen(TreeNode root) {
        if (root.left != null) {
            root.left.val = root.val * 2 + 1;
            set.add(root.left.val);
            gen(root.left);
        }
        if (root.right != null) {
            root.right.val = root.val * 2 + 2;
            set.add(root.right.val);
            gen(root.right);
        }
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
//leetcode submit region end(Prohibit modification and deletion)

}