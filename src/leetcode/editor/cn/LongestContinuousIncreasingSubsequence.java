package leetcode.editor.cn;
//最长连续递增序列
//给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。 
//
// 
//
// 示例 1: 
//
// 输入: [1,3,5,4,7]
//输出: 3
//解释: 最长连续递增序列是 [1,3,5], 长度为3。
//尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。 
// 
//
// 示例 2: 
//
// 输入: [2,2,2,2,2]
//输出: 1
//解释: 最长连续递增序列是 [2], 长度为1。
// 
//
// 
//
// 注意：数组长度不会超过10000。 
// Related Topics 数组 
// 👍 118 👎 0

public class LongestContinuousIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestContinuousIncreasingSubsequence().new Solution();
        int[] arr = {1,2,3,5,4,7};
        System.out.println(solution.findLengthOfLCIS(arr));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0)return 0;
        int l=0,r=1;
        int max = 0;
        while(r<nums.length) {
            if(nums[r-1]<nums[r]){
                r++;
            }else{
                max = Math.max(max,r-l);
                l=r;
                r++;
            }
        }
        return Math.max(max,r-l);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}