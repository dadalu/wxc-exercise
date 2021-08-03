package leetcode.editor.cn;
//链表求和
//给定两个用链表表示的整数，每个节点包含一个数位。 
//
// 这些数位是反向存放的，也就是个位排在链表首部。 
//
// 编写函数对这两个整数求和，并用链表形式返回结果。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
// 
//
// 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢? 
//
// 示例： 
//
// 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
// 
// Related Topics 递归 链表 数学 
// 👍 86 👎 0

public class SumListsLcci{
    public static void main(String[] args) {
        Solution solution = new SumListsLcci().new Solution();
        
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode ret = pre;
        ListNode cur = null;

        int f = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + f;
            f = sum / 10;
            sum = sum % 10;
            cur = new ListNode(sum);
            pre.next = cur;
            pre = cur;
            l1 =l1.next;
            l2 =l2.next;
        }

        while (l1 != null) {
            cur = new ListNode((l1.val+f)%10);
            f = (l1.val+f) / 10;
            pre.next = cur;
            pre = cur;
            l1 =l1.next;
        }
        while (l2 != null) {
            cur = new ListNode((l2.val+f) % 10);
            f = (l2.val+f) / 10;
            pre.next = cur;
            pre = cur;
            l2 =l2.next;
        }
        while (l1==null&&l2==null&&f != 0) {
            cur = new ListNode(f);
            f = f / 10;
            pre.next = cur;
            pre = cur;
        }
        return ret.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}