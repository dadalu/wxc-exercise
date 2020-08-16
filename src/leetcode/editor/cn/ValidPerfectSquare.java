package leetcode.editor.cn;
//有效的完全平方数	
//valid-perfect-square	
//367
//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找 
// 👍 158 👎 0

//Java：有效的完全平方数
public class ValidPerfectSquare{
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        System.out.println(solution.isPerfectSquare(16));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num<2)return true;
        long l=2,r=num/2,x;
        while (l<=r){
            x = l+(r-l)/2;
            if(num==x*x){
                return true;
            }else if(num<x*x){
                r = x-1;
            }else{
                l = x+1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
