package leetcode.editor.cn;
//移除重复节点
//remove-duplicate-node-lcci	
//面试题 02.01
//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 哈希表 链表 双指针 
// 👍 110 👎 0

import java.util.HashSet;
import java.util.Set;

//Java：移除重复节点
public class RemoveDuplicateNodeLcci{
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateNodeLcci().new Solution();
        // TO TEST
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
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode node = pre;
        while (head != null) {
            if (!set.add(head.val)) {
                pre.next = head.next;
                head.next = null;
                head = pre.next;
            } else {
                pre = head;
                head = head.next;
            }
        }
        return node.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}