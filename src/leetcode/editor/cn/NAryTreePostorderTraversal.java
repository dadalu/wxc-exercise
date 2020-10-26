package leetcode.editor.cn;
//N叉树的后序遍历
//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 105 👎 0

import java.util.ArrayList;
import java.util.List;

public class NAryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreePostorderTraversal().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    List list = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        if(root!=null){
            for (Node node:root.children
            ) {
                postorder(node);
            }
            list.add(root.val);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}