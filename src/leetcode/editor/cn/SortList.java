package leetcode.editor.cn;
//排序链表
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 811 👎 0

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class SortList{
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next =null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode h = new ListNode();
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val > right.val) {
                h.next = right;
                right = right.next;
            } else {
                h.next = left;
                left = left.next;
            }
            h = h.next;
        }
        h.next = left==null?right:left;
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}