package leetcode.editor.cn;
//回文链表
//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 996 👎 0

import java.util.List;

public class PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        solution.isPalindrome(node);
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode node = head;
        ListNode l = node;
        ListNode r = node;
        ListNode pre = null;
        //1 2 3 4 5 6 7 8 9 10 11
        while (r != null && r.next != null) {
            pre = l;
            l = l.next;
            r = r.next.next;
        }
        ListNode lPre = null;
        while (l != null) {
            ListNode next = l.next;
            l.next = lPre;
            lPre = l;
            l = next;
        }
        while (lPre != null) {
            if (lPre.val != node.val) {
                return false;
            }
            lPre = lPre.next;
            node = node.next;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}