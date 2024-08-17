package leetcode.editor.cn;
//至少是其他数字两倍的最大数
//在一个给定的数组nums中，总是存在一个最大元素 。 
//
// 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。 
//
// 如果是，则返回最大元素的索引，否则返回-1。 
//
// 示例 1: 
//
// 输入: nums = [3, 6, 1, 0]
//输出: 1
//解释: 6是最大的整数, 对于数组中的其他整数,
//6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
// 
//
// 
//
// 示例 2: 
//
// 输入: nums = [1, 2, 3, 4]
//输出: -1
//解释: 4没有超过3的两倍大, 所以我们返回 -1.
// 
//
// 
//
// 提示: 
//
// 
// nums 的长度范围在[1, 50]. 
// 每个 nums[i] 的整数范围在 [0, 100]. 
// 
// Related Topics 数组 
// 👍 71 👎 0

public class LargestNumberAtLeastTwiceOfOthers{
    public static void main(String[] args) {
        Solution solution = new LargestNumberAtLeastTwiceOfOthers().new Solution();
        int[] arr = {1,2,16,35,44,100,27,0};
        System.out.println(solution.dominantIndex(arr));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int dominantIndex(int[] nums) {
        if(nums.length==1)return 0;
        int[] arr = new int[101];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = i;
        }
        int k = 1;
        int max = -1;
        int p = arr.length-1;
        while(k<=2&&p>=0){
            if(arr[p]!=-1){

                if(max==-1){
                    max = p;
                }else{
                    if (max >= p * 2) {
                        return arr[max];
                    } else {
                        return -1;
                    }
                }
                k++;
                p--;
            }else{
                p--;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}