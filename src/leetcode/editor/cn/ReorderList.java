package leetcode.editor.cn;
//重排链表
//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 580 👎 0

public class ReorderList{
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next.next.next = new ListNode(8);
        node.next.next.next.next.next.next.next.next = new ListNode(9);
        node.next.next.next.next.next.next.next.next.next = new ListNode(10);
        //node.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
        solution.reorderList(node);
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
 * 1 2 3 4 5 6
 */
public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode tail = new ListNode();
        while (fast != null) {
            if (fast.next == null) {
                tail = slow;
                slow = slow.next;
                break;
            }
            fast = fast.next.next;
            tail = slow;
            slow = slow.next;
        }
        tail.next = null;
        ListNode pre = null;
        ListNode cur = slow;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode left = head;
        ListNode temp;
        while (pre != null&&left!=null) {
            next = left.next;
            left.next = pre;
            temp = pre.next;
            pre.next = next;
            pre = temp;
            left = next;
        }
        System.out.println(head);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}