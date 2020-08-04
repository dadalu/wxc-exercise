package leetcode.editor.cn;
//各位相加	
//add-digits	
//258
//给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。 
//
// 示例: 
//
// 输入: 38
//输出: 2 
//解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
// 
//
// 进阶: 
//你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？ 
// Related Topics 数学 
// 👍 261 👎 0

//Java：各位相加
public class P258AddDigits{
    public static void main(String[] args) {
        Solution solution = new P258AddDigits().new Solution();
        int num = solution.addDigits(38);
        System.out.println(num);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int addDigits(int num) {
        /*if(num/10==0)return num;
        int num1 = 0;
        while(num/10>0){
            num1+=num/10;
            num%=10;
        }
        num1+=num;
        return addDigits(num1);*/
        return (num-1)%9+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
