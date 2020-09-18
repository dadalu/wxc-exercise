package leetcode.editor.cn;
//数字的补数
//给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。 
//
// 
//
// 
// 
//
// 示例 1: 
//
// 输入: 5
//输出: 2
//解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
// 
//
// 示例 2: 
//
// 输入: 1
//输出: 0
//解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
// 
//
// 
//
// 注意: 
//
// 
// 给定的整数保证在 32 位带符号整数的范围内。 
// 你可以假定二进制数不包含前导零位。 
// 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同 
// 
// Related Topics 位运算 
// 👍 176 👎 0

import java.util.ArrayList;
import java.util.List;

public class NumberComplement{
    public static void main(String[] args) {
        Solution solution = new NumberComplement().new Solution();
        System.out.println(solution.findComplement(2));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findComplement(int num) {
        List<Integer> list = new ArrayList<>();
        int ret =0;
        while (num!=0){
            int temp = num%2;
            if(temp==0){
                list.add(0,1);
            }else{
                list.add(0,0);
            }
            num/=2;
        }
        for (int i = 0; i < list.size(); i++) {
            ret+=list.get(i)*Math.pow(2,(list.size()-1-i));
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}