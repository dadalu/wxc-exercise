//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组

package leetcode.editor.cn;
public class  PlusOne{
    public static void main(String[] args){
        Solution solution = new PlusOne().new Solution();
        int [] nums = new int[]{8,9,9,9};
        int [] nums1=solution.plusOne(nums);
        System.out.println(nums1);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        if(digits[0]==0){
            digits[0]=1;
            return digits;
        }
        int count = digits.length-1;
        //增加标志，判断数字是否已经经过加计算
        boolean isAdded = false;
        //当该位置的数据为9时
        while (digits[count]==9&&!isAdded){
            //如果当前位置为0
            if(count==0){
                //生成一个长度为digits.length+1数组，将digits数组拷贝到新数组2-末尾的位置
                int [] nums = new int[digits.length+1];
                for (int i = 1; i <=digits.length; i++) {
                    nums[i]=digits[i-1];
                }
                digits = nums;
                //将第一位置1，第二位置0，相当于9+1=1，0
                digits[0]=1;
                digits[1]=0;
                return digits;
            }
            //将该位置置0
            digits[count--]=0;
            //如果上一位不为9，将标志反转，即结束循环
            if(digits[count]!=9){
                digits[count]+=1;
                isAdded=true;
            }else{
                continue;
            }
        }
        if(!isAdded){
            digits[digits.length-1]+=1;
        }
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
