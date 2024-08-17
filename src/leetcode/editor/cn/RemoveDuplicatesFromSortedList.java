//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表

package leetcode.editor.cn;

public class  RemoveDuplicatesFromSortedList{
    public static void main(String[] args){
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        ListNode node = new ListNode(1);
        ListNode tempNode = node;
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        /*for (int i = 0; i < 100; i++) {
            node.next = new ListNode(i/3);
            node = node.next;
        }*/
        ListNode retNode = solution.deleteDuplicates(tempNode);
        System.out.println(retNode);
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
public static  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if(head==null) return null;
        if(head.next==null) return head;
        ListNode node = head;
        while (head.next!=null){
            if(head.val==head.next.val){
                head.next = head.next.next;
                continue;
            }else{
                head = head.next;
            }
        }
        return node;
    }
    }
}

