package leetcode.editor.cn;
//完美数
//对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。 
//
// 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False 
//
// 
//
// 示例： 
//
// 输入: 28
//输出: True
//解释: 28 = 1 + 2 + 4 + 7 + 14
// 
//
// 
//
// 提示： 
//
// 输入的数字 n 不会超过 100,000,000. (1e8) 
// Related Topics 数学 
// 👍 73 👎 0

public class PerfectNumber{
    public static void main(String[] args) {
        Solution solution = new PerfectNumber().new Solution();
        System.out.println(solution.checkPerfectNumber(6));
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num==0||num==1)return false;
        int sum = 0;
        int sq = new Double(Math.sqrt(num)).intValue();
        while(sq!=0){
            if(num%sq==0){
                sum+=sq;
                if(num/sq!=num){
                    sum+=num/sq;
                }
            }
            sq--;
        }
        return sum==num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}