/*
//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
//
// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法

package leetcode.editor.cn;
public class  MedianOfTwoSortedArrays{
    public static void main(String[] args){
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1+len2;

        if(nums1[nums1.length-1]<nums2[nums2.length-1]||nums2[nums2.length-1]<nums1[nums1.length-1]){
            if(len1<len2){
                if(len%2==0){

                }else{
                   return
                }
            }else{

            }
        }
        while(len1<nums1.length-1)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
*/
