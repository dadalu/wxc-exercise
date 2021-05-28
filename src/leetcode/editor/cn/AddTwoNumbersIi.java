package leetcode.editor.cn;
//两数相加 II
//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表 
// 👍 383 👎 0

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbersIi{
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        solution.addTwoNumbers(l1, l2);
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        ListNode l1cur = l1;
        ListNode l2cur = l2;
        int l1Len = 0;
        int l2Len = 0;
        while (l1cur != null) {
            l1cur = l1cur.next;
            l1Len++;
        }
        while (l2cur != null) {
            l2cur = l2cur.next;
            l2Len++;
        }
        ListNode temp;
        if (l1Len < l2Len) {
            temp = l1;
            l1 = l2;
            l2 = temp;
        }
        int sub = Math.abs(l1Len - l2Len);
        while (sub > 0) {
            list.add(l1.val);
            l1 = l1.next;
            sub--;
        }
        while (l1 != null) {
            int sum = l1.val + l2.val;
            int div = sum / 10;
            int rem = sum % 10;
            if (div > 0) {
                Integer pre = null;
                List<Integer> tempList = new ArrayList<>();
                tempList.add(rem);
                while (!list.isEmpty()) {
                    pre = list.remove(list.size() - 1);
                    pre += div;
                    div = pre / 10;
                    rem = pre % 10;
                    tempList.add(rem);
                }
                if (div >0) {
                    list.add(div);
                }
                while (!tempList.isEmpty()) {
                    list.add(tempList.remove(tempList.size()-1));
                }
            } else {
                list.add(rem);
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode node = new ListNode();
        ListNode ret = node;
        for (int i = 0; i < list.size(); i++) {
            node.next = new ListNode(list.get(i));
            node = node.next;
        }
        return ret.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}