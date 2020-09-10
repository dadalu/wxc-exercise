package leetcode.editor.cn;

//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 255 👎 0

public class AddStrings{
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
        String s1 ="9133";
        String s2 ="0";
        System.out.println(solution.addStrings(s1, s2));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        if(num1==null||"".equals(num1)){
            return num2;
        }
        if(num2==null||"".equals(num2)){
            return num1;
        }
        int length1 = num1.length();
        int length2 = num2.length();
        int slen = length1>=length2?length2:length1;
        int llen = length1<=length2?length2:length1;
        String max = length1>=length2?num1:num2;
        if(length1==length2){
            max =null;
        }
        StringBuffer sb = new StringBuffer();
        int flag = 0;
        for (int i = 0; i < slen; i++) {
            int i1 =  Character.getNumericValue(num1.charAt(length1-1-i));
            int i2 = Character.getNumericValue(num2.charAt(length2-1-i));
            sb.insert(0,(i1+i2+flag)%10);
            flag = (i1+i2+flag)/10;
        }
        if(max!=null){
            for (int i = 0; i <=llen-slen-1; i++) {
                int i1 = Character.getNumericValue(max.charAt(llen-slen-1-i));
                sb.insert(0,(i1+flag)%10);
                flag = (i1+flag)/10;
            }
        }
        if(flag!=0){
            sb.insert(0,flag);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}