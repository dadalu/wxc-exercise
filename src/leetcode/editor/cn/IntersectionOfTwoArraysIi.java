package leetcode.editor.cn;
//两个数组的交集 II	
//intersection-of-two-arrays-ii	
//350
//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 377 👎 0

import java.util.HashMap;
import java.util.Map;

//Java：两个数组的交集 II
public class IntersectionOfTwoArraysIi{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] ret = solution.intersect(nums1,nums2);
        System.out.println(ret);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int l = nums1.length>nums2.length?nums1.length:nums2.length;
        int[] ret = new int[l];
        int p =0;
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums1.length; i++) {
            int num = map.get(nums1[i])==null?1:map.get(nums1[i])+1;
            map.put(nums1[i],num);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(map.get(nums2[i])!=null&&map.get(nums2[i])>0){
                ret[p]=nums2[i];
                map.put(nums2[i],map.get(nums2[i])-1);
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
