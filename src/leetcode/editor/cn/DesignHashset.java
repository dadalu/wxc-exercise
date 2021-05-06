package leetcode.editor.cn;
//设计哈希集合
//不使用任何内建的哈希表库设计一个哈希集合 
//
// 具体地说，你的设计应该包含以下的功能 
//
// 
// add(value)：向哈希集合中插入一个值。 
// contains(value) ：返回哈希集合中是否存在这个值。 
// remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。 
// 
//
// 
//示例: 
//
// MyHashSet hashSet = new MyHashSet();
//hashSet.add(1);         
//hashSet.add(2);         
//hashSet.contains(1);    // 返回 true
//hashSet.contains(3);    // 返回 false (未找到)
//hashSet.add(2);          
//hashSet.contains(2);    // 返回 true
//hashSet.remove(2);          
//hashSet.contains(2);    // 返回  false (已经被删除)
// 
//
// 
//注意： 
//
// 
// 所有的值都在 [0, 1000000]的范围内。 
// 操作的总数目在[1, 10000]范围内。 
// 不要使用内建的哈希集合库。 
// 
// Related Topics 设计 哈希表 
// 👍 67 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DesignHashset{
    public static void main(String[] args) {
    }

//leetcode submit region begin(Prohibit modification and deletion)
static class MyHashSet {
    private List<Integer>[] entry;
    private double factor = 0.75;
    private int length;
    private int size = 0;
    /** Initialize your data structure here. */
    public MyHashSet() {
        if(entry==null){
            length = 16;
            entry = new List[length];
        }
    }
    
    public void add(int key) {
        int tempKey = key;
        if(key>=entry.length){
            tempKey = key%entry.length;
        }
        if(entry[tempKey]!=null){
            if(contains(key)){
                return;
            }
            entry[tempKey].add(key);
        }else {
            List list = new LinkedList();
            list.add(key);
            entry[tempKey]=list;
        }
        size++;
        if(size>2*length){
            expansion(entry);
        }
    }
    
    public void remove(int key) {
        int tempKey = key;
        if(key>=entry.length){
            tempKey = key%entry.length;
        }
        List<Integer> list = entry[tempKey];
        if(list!=null){
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i)==key){
                    list.remove(i);
                    size--;
                    break;
                }
            }
        }

    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(entry==null){
            return false;
        }
        int tempKey = key;
        if(key>=entry.length){
            tempKey = key%entry.length;
        }
        List<Integer> list = entry[tempKey];
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i)==key){
                    return true;
                }
            }
        }

        return false;
    }
    public void expansion(List<Integer>[] lists){
        entry = new List[length*2+1];
        length = length*2+1;
        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null){
                for (int j = 0; j < lists[i].size(); j++) {
                    this.add(lists[i].get(j));
                }
            }

        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
//leetcode submit region end(Prohibit modification and deletion)

}