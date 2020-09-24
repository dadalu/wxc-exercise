package leetcode.editor.cn;
//七进制数
//给定一个整数，将其转化为7进制，并以字符串形式输出。 
//
// 示例 1: 
//
// 
//输入: 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: -7
//输出: "-10"
// 
//
// 注意: 输入范围是 [-1e7, 1e7] 。 
// 👍 59 👎 0

public class Base7{
    public static void main(String[] args) {
        Solution solution = new Base7().new Solution();
        System.out.println(solution.convertToBase7(7));
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToBase7(int num) {
        if(num==0)return "0";
        boolean flag =false;
        StringBuilder builder = new StringBuilder();
        if(num<0){
            flag = true;
            num = Math.abs(num);
        }
        while (num!=0){
            int cur = num%7;
            num/=7;
            builder.insert(0,cur);
        }
        if(flag){
            builder.insert(0,"-");
        }
        return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}