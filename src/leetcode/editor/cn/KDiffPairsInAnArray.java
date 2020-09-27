package leetcode.editor.cn;
//数组中的K-diff数对
//给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j
// 都是数组中的数字，且两数之差的绝对值是 k. 
//
// 示例 1: 
//
// 
//输入: [3, 1, 4, 1, 5], k = 2
//输出: 2
//解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
//尽管数组中有两个1，但我们只应返回不同的数对的数量。
// 
//
// 示例 2: 
//
// 
//输入:[1, 2, 3, 4, 5], k = 1
//输出: 4
//解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
// 
//
// 示例 3: 
//
// 
//输入: [1, 3, 1, 5, 4], k = 0
//输出: 1
//解释: 数组中只有一个 0-diff 数对，(1, 1)。
// 
//
// 注意: 
//
// 
// 数对 (i, j) 和数对 (j, i) 被算作同一数对。 
// 数组的长度不超过10,000。 
// 所有输入的整数的范围在 [-1e7, 1e7]。 
// 
// Related Topics 数组 双指针 
// 👍 96 👎 0

import java.util.*;

public class KDiffPairsInAnArray {
    public static void main(String[] args) {
        Solution solution = new KDiffPairsInAnArray().new Solution();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(solution.findPairs(arr, 0));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPairs(int[] nums, int k) {
            if(k<0)return 0;
            int count = 0;
            Map<Integer, Integer> map = new HashMap();
            for (int i = 0; i < nums.length; i++) {
                if (map.get(nums[i]) != null) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }
            for(Integer key:map.keySet()){
                if(k!=0){
                    if(map.containsKey(key+k)){
                        count++;
                    }
                }else{
                    if(map.get(key)>=2){
                        count++;
                    }
                }

            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}