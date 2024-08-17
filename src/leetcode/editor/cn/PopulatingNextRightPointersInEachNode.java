package leetcode.editor.cn;
//填充每个节点的下一个右侧节点指针
//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 
//next 指针连接，'#' 标志着每一层的结束。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量少于 4096 
// -1000 <= node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 535 👎 0

public class PopulatingNextRightPointersInEachNode{
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNode().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
class Solution {
    //额外空间解法
    /*Map<Integer, List<Node>> map = new HashMap<>();
    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        dfs(root,0);
        for (List<Node> list:map.values()
             ) {
            for (int i = 1; i < list.size(); i++) {
                list.get(i - 1).next = list.get(i);
            }
        }
        return root;
    }
    public void dfs(Node root,int level) {
        if (root == null) {
            return;
        }
        List<Node> list = map.get(level);
        if (list == null) {
            list = new ArrayList<>();
            list.add(root);
            map.put(level, list);
        } else {
            list.add(root);
        }
        level++;
        dfs(root.left, level);
        dfs(root.right, level);
    }*/
    //层序遍历解法
    /*public Node connect(Node root){
        if (root == null) {
            return root;
        }
        List<Node> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Node node = list.remove(0);
                if (i < size - 1) {
                    node.next = list.get(0);
                }
                if (node.left != null) {
                    list.add(node.left);
                    list.add(node.right);
                }
            }
        }
        return root;
    }*/
    //利用指针解法
    public Node connect(Node root){
        if (root == null) {
            return root;
        }
        Node l = root;
        while (l.left != null) {
            Node head = l;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            l = l.left;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}