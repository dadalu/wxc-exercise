package leetcode.editor.cn;
//合并两个排序的链表
//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 
// 👍 155 👎 0

public class HeBingLiangGePaiXuDeLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
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
class Solution {
    ListNode ret = new ListNode(0);
    ListNode node = ret;
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        dfs(node,l1,l2);
        return ret.next;
    }
    public void dfs(ListNode node,ListNode l1, ListNode l2) {

        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                ListNode l1next = l1.next;
                node = l1;
                dfs(node, l1next, l2);
            } else if (l1.val == l2.val) {
                node.next = l1;
                ListNode l1next = l1.next;
                l1.next = l2;
                ListNode l2next = l2.next;
                node = l2;
                dfs(node, l1next, l2next);
            } else {
                node.next = l2;
                ListNode l2next = l2.next;
                node = l2;
                dfs(node, l2next, l1);
            }
        } else if (l1 != null) {
            node.next = l1;
        } else {
            node.next = l2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}