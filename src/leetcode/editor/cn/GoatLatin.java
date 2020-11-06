package leetcode.editor.cn;
//山羊拉丁文
//给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。 
//
// 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。 
//
// 山羊拉丁文的规则如下： 
//
// 
// 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。 
// 例如，单词"apple"变为"applema"。 
// 
// 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。 
// 例如，单词"goat"变为"oatgma"。 
// 
// 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。 
// 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。 
// 
//
// 返回将 S 转换为山羊拉丁文后的句子。 
//
// 示例 1: 
//
// 
//输入: "I speak Goat Latin"
//输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
// 
//
// 示例 2: 
//
// 
//输入: "The quick brown fox jumped over the lazy dog"
//输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaa
//aaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
// 
//
// 说明: 
//
// 
// S 中仅包含大小写字母和空格。单词间有且仅有一个空格。 
// 1 <= S.length <= 150。 
// 
// Related Topics 字符串 
// 👍 46 👎 0

import java.util.HashSet;
import java.util.Set;

public class GoatLatin{
    public static void main(String[] args) {
        Solution solution = new GoatLatin().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String toGoatLatin(String S) {
        Set<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        String[] strings = S.split(" ");
        String ret = "";
        for (int i = 0; i < strings.length; i++) {
            ret+=" ";
            String str = strings[i];
            char c = str.charAt(0);
            if(set.contains(c)){
                str = str+"ma";
                for (int j = 0; j <=i ; j++) {
                    str+="a";
                }
            }else{
                str = str.substring(1)+c;
                str = str+"ma";
                for (int j = 0; j <=i ; j++) {
                    str+="a";
                }
            }
            ret+=str;

        }
        return ret.substring(1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}