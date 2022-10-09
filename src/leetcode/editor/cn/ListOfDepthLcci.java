package leetcode.editor.cn;
//特定深度节点链表
//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。 
//
// 
//
// 示例： 
//
// 输入：[1,2,3,4,5,null,7,8]
//
//        1
//       /  \ 
//      2    3
//     / \    \ 
//    4   5    7
//   /
//  8
//
//输出：[[1],[2,3],[4,5,7],[8]]
// 
// Related Topics 树 广度优先搜索 链表 二叉树 
// 👍 54 👎 0

import java.util.*;

public class ListOfDepthLcci{
    public static void main(String[] args) {
        Solution solution = new ListOfDepthLcci().new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);
        treeNode.left.left.left = new TreeNode(8);
        solution.listOfDepth(treeNode);
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
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    List<ListNode> list = new ArrayList<>();
    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (tree != null) {
            queue.add(tree);
        }
        gfs(queue);
        return list.toArray(new ListNode[list.size()]);
    }

    public void gfs(Queue<TreeNode> queue) {
        Queue<TreeNode> nextQueue = new ArrayDeque<>();
        ListNode node = new ListNode(0);
        ListNode pre = node;
        TreeNode treeNode;
        while (!queue.isEmpty()) {
            treeNode = queue.poll();
            node.next = new ListNode(treeNode.val);
            node = node.next;
            if (treeNode.left != null) {
                nextQueue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                nextQueue.add(treeNode.right);
            }
        }
        list.add(pre.next);
        if (!nextQueue.isEmpty()) {
            gfs(nextQueue);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}