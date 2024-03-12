package leetcode.editor.cn;
//字符串相乘
//multiply-strings	
//43
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// 👍 1326 👎 0

import java.util.Objects;

//Java：字符串相乘
public class MultiplyStrings{
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        // TO TEST
        solution.multiply("5", "408");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if (Objects.equals(num1, "0") || Objects.equals(num2, "0")) {
            return "0";
        }
        int[] retArr = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            char c1 = num1.charAt(i);
            if (Objects.equals(c1, '0')) {
                continue;
            }
            int pre = 0;
            int[] arr = new int[num2.length() + num1.length()];
            for (int j = num2.length() -1; j >=0; j--) {
                char c2 = num2.charAt(j);
                if (Objects.equals(c2, '0')) {
                    arr[arr.length - 1 -(num1.length()-1-i) -(num2.length()-1-j) ] = pre;
                    pre = 0;
                    continue;
                }
                int n1 = c1 - '0';
                int n2 = c2 - '0';
                int mul = n1 * n2 + pre;
                arr[arr.length - 1 -(num1.length()-1-i) -(num2.length()-1-j) ] = mul % 10;
                pre = mul / 10;
            }
            if (pre>0) {
                arr[arr.length - num2.length() - (num1.length() - i)] = pre;
            }
            pre = 0;
            for (int j = arr.length -1; j >=0 ; j--) {
                int sum = retArr[j] + arr[j] + pre;
                retArr[j] = sum % 10;
                pre = sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        for (int i = 0; i < retArr.length; i++) {
            if (retArr[i] == 0 && !start) {
            } else {
                start = true;
                sb.append(retArr[i]);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}