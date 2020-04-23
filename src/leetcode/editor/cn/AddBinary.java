//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串

package leetcode.editor.cn;
public class  AddBinary{
    public static void main(String[] args){
        Solution solution = new AddBinary().new Solution();
        String str = solution.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011");
        System.out.println(str);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 主要考虑到每个位的数据累加到进位上
      */
class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        if(len1<len2){
            return addBinary(b,a);
        }
        int flag = 0;
        int j = len2-1;
        StringBuilder builder = new StringBuilder();
        for (int i = len1-1; i >=0 ; i--) {
            if(a.charAt(i)=='1'){
                ++flag;
            }
            if(j>-1&&b.charAt(j--)=='1'){
                ++flag;
            }
            if(flag%2==1){
                builder.append(1);
            }else{
                builder.append(0);
            }
            flag/=2;
        }
        if(flag==1){
            builder.append(1);
        }
        return builder.reverse().toString();



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
