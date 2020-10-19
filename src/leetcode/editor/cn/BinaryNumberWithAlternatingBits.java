package leetcode.editor.cn;
//交替位二进制数
//binary-number-with-alternating-bits	
//693
//给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。 
//
// 示例 1: 
//
// 
//输入: 5
//输出: True
//解释:
//5的二进制数是: 101
// 
//
// 示例 2: 
//
// 
//输入: 7
//输出: False
//解释:
//7的二进制数是: 111
// 
//
// 示例 3: 
//
// 
//输入: 11
//输出: False
//解释:
//11的二进制数是: 1011
// 
//
// 示例 4: 
//
// 
//输入: 10
//输出: True
//解释:
//10的二进制数是: 1010
// 
// Related Topics 位运算 
// 👍 80 👎 0

//Java：交替位二进制数
public class BinaryNumberWithAlternatingBits{
    public static void main(String[] args) {
        Solution solution = new BinaryNumberWithAlternatingBits().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean hasAlternatingBits(int n) {
        if(n<3){
            return true;
        }
        int pre = -1;
        while(n/2>0){
            if(pre==-1){
                pre = n%2;
                n/=2;
            }else{
                if(n%2==pre){
                    return false;
                }else {
                    pre = n%2;
                    n=n/2;
                }
            }

        }
        return n!=pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}