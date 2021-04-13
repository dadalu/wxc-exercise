package leetcode.editor.cn;
//有序数组中出现次数超过25%的元素
//给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。 
//
// 请你找到并返回这个整数 
//
// 
//
// 示例： 
//
// 
//输入：arr = [1,2,2,6,6,6,6,7,10]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^4 
// 0 <= arr[i] <= 10^5 
// 
// Related Topics 数组 
// 👍 42 👎 0

public class ElementAppearingMoreThan25InSortedArray{
    public static void main(String[] args) {
        Solution solution = new ElementAppearingMoreThan25InSortedArray().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findSpecialInteger(int[] arr) {
        int max = arr[arr.length - 1]+1;
        int[] frenquency = new int[max];
        for (int i = 0; i < arr.length; i++) {
            frenquency[arr[i]]++;
        }
        for (int i = 0; i < frenquency.length; i++) {
            if (frenquency[i] * 4 > arr.length) {
                return i;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}