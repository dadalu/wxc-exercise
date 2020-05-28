//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表

package leetcode.editor.cn;
public class  RemoveLinkedListElements{
    public static void main(String[] args){
        Solution solution = new RemoveLinkedListElements().new Solution();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 =listNode;

        for (int i = 0; i < 8; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        ListNode node = solution.removeElements(listNode1,6);
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
      ListNode(int x) { val = x; }
}
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        while (head!=null){
            if(head.val==val){
                head = head.next;
            }else{
                break;
            }
        }
        ListNode node = head;
        while(head!=null&&head.next!=null){
            if(head.next.val==val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
