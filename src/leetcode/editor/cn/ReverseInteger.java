//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学
package leetcode.editor.cn;
public class  ReverseInteger{
    public static void main(String[] args){
        Solution solution = new ReverseInteger().new Solution();

        int rtn = solution.reverse(-147483648);
        System.out.println(rtn);
    }
    


class Solution {
    public int reverse(int x) {
        boolean flag = false;
        if(x<0){
            x = Math.abs(x);
            if(x<0){
                return 0;
            }
            flag = true;
        }
        if(x<10) return x;
        long rev=0;

        while (x/10>0){
            int off = x%10;
            rev = rev*10+ (long)off;
            x=x/10;
            if(x<10&&x>0) {
                rev = rev * 10 + x;
                if(rev!=(int)rev) return 0;
                if(flag){
                    return (int)-rev;
                }else{
                    return (int)rev;
                }

            }

        }
        if(flag){
            return (int)-rev;
        }else{
            return (int)rev;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
