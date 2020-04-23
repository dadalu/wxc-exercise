//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串

package leetcode.editor.cn;
public class  ImplementStrstr{
    public static void main(String[] args){
        Solution solution = new ImplementStrstr().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*public int strStr(String haystack, String needle) {
        //语言自带解法
        //return haystack.indexOf(needle);

    }*/
    //KMP算法
    public  int[] cal_next(String str) {				// 计算关于 模式串 的 next 数组
        int len = str.length(), next[] = new int[len];
        next[0] = -1;
        int i = 0, j = 1;									// i j 分别是前后缀指针
        while(j < len) {
            if(i == -1 || str.charAt(i) == str.charAt(j)) {
                i++;
                j++;
                if(j < len) next[j] = i;
            } else i = next[i];
        }
        return next;
    }

    public  int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(haystack.length() == 0) return -1;
        int[] next = cal_next(needle);						// 计算 needle 的前后缀
        int i = 0, j = 0, len = haystack.length(), subLen = needle.length();
        while(i < len) {
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if(j == subLen) return i - j;				// needle 指针走到末尾，说明匹配成功
            } else j = next[j];
        }
        return -1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
