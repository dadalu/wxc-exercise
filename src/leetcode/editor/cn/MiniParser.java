package leetcode.editor.cn;
//迷你语法分析器
//给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。 
//
// 列表中的每个元素只可能是整数或整数嵌套列表 
//
// 提示：你可以假定这些字符串都是格式良好的： 
//
// 
// 字符串非空 
// 字符串不包含空格 
// 字符串只包含数字0-9、[、-、,、] 
// 
//
// 
//
// 示例 1： 
//
// 给定 s = "324",
//
//你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
// 
//
// 示例 2： 
//
// 给定 s = "[123,[456,[789]]]",
//
//返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
//
//1. 一个 integer 包含值 123
//2. 一个包含两个元素的嵌套列表：
//    i.  一个 integer 包含值 456
//    ii. 一个包含一个元素的嵌套列表
//         a. 一个 integer 包含值 789
// 
// Related Topics 栈 字符串 
// 👍 59 👎 0

import java.util.ArrayList;
import java.util.List;

public class MiniParser{
    public static void main(String[] args) {
        Solution solution = new MiniParser().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

class Solution {
    /*char[] chars;
    int cur = 0;
    public NestedInteger deserialize(String s) {
        chars = s.toCharArray();
        //本身不是一个集合而是一个整数的情况
        if(chars[0]!='[') return new NestedInteger(Integer.valueOf(s));
        //调用递归函数返回根集合
        return getNest();
    }
    public NestedInteger getNest(){
        NestedInteger nest = new NestedInteger();
        int num = 0;//num用于缓存用逗号分割的整数类型的值
        boolean negative = false;//当前记录的整数是不是负数
        while(cur!=chars.length-1){
            cur ++;
            if(chars[cur]==',') continue;
            if(chars[cur]=='[') nest.add(getNest());//遇到[递归获取子集合
            else if(chars[cur]==']') return nest;
            else if(chars[cur]=='-') negative = true;
            else{//是数字的情况
                if(negative) num = 10*num - (chars[cur]-48);
                else num = 10*num + (chars[cur]-48);
                //如果下一个字符是,或者]说明当前数字已经记录完了，需要加入集合中
                if(chars[cur+1]==','||chars[cur+1]==']'){
                    nest.add(new NestedInteger(num));
                    num = 0;
                    negative = false;
                }
            }
        }
        return null;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}