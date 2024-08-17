package leetcode.editor.cn;
//两个数组的交集	
//intersection-of-two-arrays	
//349
//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 220 👎 0

import java.util.HashSet;
import java.util.Set;

//Java：两个数组的交集
public class IntersectionOfTwoArrays{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        solution.intersection(nums1,nums2);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] ret = new int[nums1.length];
        int p =0;
        Set set = new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                ret[p]=nums2[i];
                set.remove(nums2[i]);
                p++;
            }
        }
        int[] retP = new int[p];
        for (int i = 0; i <p; i++) {
            retP[i] =ret[i];
        }
        return retP;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
