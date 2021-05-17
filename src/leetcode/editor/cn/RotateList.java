package leetcode.editor.cn;
//旋转链表
//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 557 👎 0

public class RotateList{
    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        /*node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);*/
        solution.rotateRight(node, 2);
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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null||head.next==null) {
            return head;
        }
        int i = 0;
        ListNode l = head;
        ListNode r = head;
        while (head != null) {
            head = head.next;
            i++;
        }
        k %= i;
        if (k == 0) {
            return r;
        }
        int j = 1;
        while (j < i-k) {
            r = r.next;
            j++;
        }
        ListNode pre = r;
        r = r.next;
        pre.next = null;
        ListNode cur = r;
        while (cur.next!= null) {
            cur = cur.next;
        }
        cur.next = l;
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}