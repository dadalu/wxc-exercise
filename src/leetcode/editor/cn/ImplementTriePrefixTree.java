package leetcode.editor.cn;
//实现 Trie (前缀树)
//implement-trie-prefix-tree	
//208
//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
//写检查。 
//
// 请你实现 Trie 类： 
//
// 
// Trie() 初始化前缀树对象。 
// void insert(String word) 向前缀树中插入字符串 word 。 
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 
//false 。 
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 仅由小写英文字母组成 
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 10⁴ 次 
// 
//
// 👍 1540 👎 0

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：实现 Trie (前缀树)
public class ImplementTriePrefixTree{
    public static void main(String[] args) {
        // TO TEST
        Trie trie = new ImplementTriePrefixTree().new Trie();
        trie.insert("apple");
        boolean b1 = trie.search("apple");
        boolean b2 = trie.search("app");
        boolean b3 = trie.startsWith("app");
        trie.insert("app");
        boolean b5 = trie.search("app");

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        Struct root;

        public Trie() {
            root = new Struct();
        }

        public void insert(String word) {
            Struct struct = root;
            for (int i = 0; i < word.length(); i++) {
                if (struct.getChild().get(word.charAt(i)) != null) {
                    struct = struct.getChild().get(word.charAt(i));
                } else {
                    Struct child = new Struct();
                    child.setCharacter(word.charAt(i));
                    child.setChild(new HashMap<>());
                    struct.getChild().put(word.charAt(i), child);
                    struct = struct.getChild().get(word.charAt(i));
                }
            }
            struct.isEnd = true;
        }

        public boolean search(String word) {
            Struct struct = root;
            for (int i = 0; i < word.length(); i++) {
                if (struct.getChild().get(word.charAt(i)) != null) {
                    struct = struct.getChild().get(word.charAt(i));
                } else {
                    return false;
                }
            }
            return struct.isEnd;
        }

        public boolean startsWith(String prefix) {
            Struct struct = root;
            for (int i = 0; i < prefix.length(); i++) {
                if (struct.getChild().get(prefix.charAt(i)) != null) {
                    struct = struct.getChild().get(prefix.charAt(i));
                } else {
                    return false;
                }
            }
            return true;
        }
    }
    class Struct {
        public Character getCharacter() {
            return character;
        }

        public void setCharacter(Character character) {
            this.character = character;
        }

        public Map<Character, Struct> getChild() {
            return child;
        }

        public void setChild(Map<Character, Struct> child) {
            this.child = child;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        private Character character;
        private Map<Character, Struct> child = new HashMap<>();

        private boolean isEnd;
    }
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
