package leetcode.editor.cn;
//交换链表中的节点
//给你链表的头节点 head 和一个整数 k 。 
//
// 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
//输出：[7,9,6,6,8,7,3,0,9,5]
// 
//
// 示例 3： 
//
// 
//输入：head = [1], k = 1
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：head = [1,2], k = 1
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：head = [1,2,3], k = 2
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目是 n 
// 1 <= k <= n <= 105 
// 0 <= Node.val <= 100 
// 
// Related Topics 链表 
// 👍 19 👎 0

public class SwappingNodesInALinkedList{
    public static void main(String[] args) {
        Solution solution = new SwappingNodesInALinkedList().new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        solution.swapNodes(node, 2);
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if (head.next == null) {
            return head;
        }
        ListNode leftPre = new ListNode(),rightPre = new ListNode();
        ListNode rightSlow = head,rightFast = head;
        ListNode left,right;
        ListNode ret = leftPre;
        leftPre.next = head;
        rightPre.next = head;
        int rp = 0;
        int lp = 1;
        while (rightFast != null) {
            if (lp == k) {
                rightFast = rightFast.next;
            } else {
                leftPre = rightFast;
                rightFast = rightFast.next;
                lp++;
            }

            if (rp == k) {
                rightPre = rightSlow;
                rightSlow = rightSlow.next;
            } else {
                rp++;
            }
        }
        left = leftPre.next;
        right = rightPre.next;
        int temp = left.val;
        left.val = right.val;
        right.val = temp;

        return ret.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}