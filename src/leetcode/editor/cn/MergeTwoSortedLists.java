//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

package leetcode.editor.cn;

import java.util.List;

public class  MergeTwoSortedLists{
    public static void main(String[] args){
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(4);
        ListNode node = solution.mergeTwoLists(l1,l2);
        System.out.println(node);
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
public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    @Override
    public String toString(){
        StringBuilder s =new StringBuilder();
        ListNode l = this;
        while(l!=null){
            s.append(this.val);
            l = l.next;
        }
        return s.toString();
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node= new ListNode(0);
        ListNode preNode= node;
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        while (l1!=null&&l2!=null){

            if(l1.val<l2.val){
                node.next = new ListNode(l1.val);
                l1 = l1.next;
                node = node.next;

            }else{
                node.next = new ListNode(l2.val);
                l2 = l2.next;
                node = node.next;
            }
        }
        if(l1==null){
            node.next = l2;
        }else{
            node.next = l1;
        }
        return preNode.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
