package leetcode.editor.cn;
//K 个一组翻转链表
/**
给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 

 k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 

 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 

 

 示例 1： 
 
 
输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
 

 示例 2： 

 

 
输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]
 

 
提示：

 
 链表中的节点数目为 n 
 1 <= k <= n <= 5000 
 0 <= Node.val <= 1000 
 

 

 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 

 
 

 Related Topics 递归 链表 👍 1824 👎 0

*/
public class ReverseNodesInKGroup{
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        solution.reverseKGroup(node, 2);
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
    /*public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode last = head;
        ListNode cur = head;
        ListNode ret = null;
        while (cur != null) {
            int r = k;
            ListNode rNode=cur;
            while (r>1) {
                rNode = rNode.next;
                if (rNode == null) {
                    r = -1;
                    break;
                }
                r--;
            }
            if (r != -1) {
                ListNode pre = null;
                int r1 = k;
                ListNode nextLast = cur;
                while (cur != null && r1 > 0) {
                    ListNode next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                    r1--;
                }
                if (ret == null) {
                    ret = pre;
                } else {
                    last.next = pre;
                    last = nextLast;
                }
            } else {
                if (ret == null) {
                    ret = cur;
                } else {
                    last.next = cur;
                }
                break;
            }
        }
        return ret;
    }*/
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        ListNode start = head;
        ListNode end = head;
        while (end != null) {
            for (int i = 1; i < k&&end!=null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode next = end.next;
            end.next = null;
            ListNode last = start;
            pre.next = reverse(start);
            pre = last;
            last.next = next;
            start = next;
            end = next;
        }

        return node.next;
    }

    private ListNode reverse(ListNode start) {
        ListNode pre = null;
        while (start != null) {
            ListNode next = start.next;
            start.next = pre;
            pre = start;
            start = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}