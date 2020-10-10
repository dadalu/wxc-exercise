package leetcode.editor.cn;
//错误的集合
//集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重
//复。 
//
// 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,2,4]
//输出: [2,3]
// 
//
// 注意: 
//
// 
// 给定数组的长度范围是 [2, 10000]。 
// 给定的数组是无序的。 
// 
// Related Topics 哈希表 数学 
// 👍 126 👎 0

import java.util.Set;
import java.util.TreeSet;

public class SetMismatch{
    public static void main(String[] args) {
        Solution solution = new SetMismatch().new Solution();
        int[] arr = {1,2,3,4,4,6};
        int[] arr1 = {1,1};
        System.out.println(solution.findErrorNums(arr1)[0]);
        System.out.println(solution.findErrorNums(arr1)[1]);

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] retArr = new int[2];
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            boolean b = set.add(nums[i]);
            if(!b){
                retArr[0] = nums[i];
            }
        }
        int pre = 0;
        boolean f = false;
        for (Integer i:set) {
            if(++pre!=i){
                retArr[1] = pre;
                f = true;
                break;
            }else{
                continue;
            }
        }
        if(!f)retArr[1] = pre+1;
        return retArr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}