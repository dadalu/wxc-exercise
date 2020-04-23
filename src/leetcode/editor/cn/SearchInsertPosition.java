//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找

package leetcode.editor.cn;
public class  SearchInsertPosition{
    public static void main(String[] args){
        Solution solution = new SearchInsertPosition().new Solution();
        int[] nums = {1,4,6,7,8,9};
        System.out.println(solution.searchInsert(nums,6));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target<=nums[0]){
            return 0;
        }
        if(target>nums[nums.length-1]){
            return nums.length;
        }
        if(target==nums[nums.length-1]){
            return nums.length-1;
        }
        int top = 0;
        int trail = nums.length-1;
        while (trail-top>1){

            if(target>nums[(top+trail)/2]){
                top = (top+trail)/2;
            }else if(target<nums[(top+trail)/2]){
                trail=(top+trail)/2;
            }else if(target==nums[(top+trail)/2]){
                return (top+trail)/2;
            }
        }
        return top+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
