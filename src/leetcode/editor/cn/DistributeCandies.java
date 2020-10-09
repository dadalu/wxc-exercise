package leetcode.editor.cn;
//分糖果
//给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的
//种类数。 
//
// 示例 1: 
//
// 
//输入: candies = [1,1,2,2,3,3]
//输出: 3
//解析: 一共有三种种类的糖果，每一种都有两个。
//     最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
// 
//
// 示例 2 : 
//
// 
//输入: candies = [1,1,2,3]
//输出: 2
//解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
// 
//
// 注意: 
//
// 
// 数组的长度为[2, 10,000]，并且确定为偶数。 
// 数组中数字的大小在范围[-100,000, 100,000]内。
// 
// 
// 
// 
// Related Topics 哈希表 
// 👍 84 👎 0


import java.util.*;

public class DistributeCandies{
    public static void main(String[] args) {
        Solution solution = new DistributeCandies().new Solution();
        int[] arr1 = {1,1,2,3,3,4,4,5,5,6,6,7};
        int[] arr2 = {1,1,2,2,3,3};
        int[] arr3 = {1,1,2,3};
        int[] arr4 = {0,0,14,0,10,0,0,0};
        System.out.println(solution.distributeCandies(arr1));
        System.out.println(solution.distributeCandies(arr2));
        System.out.println(solution.distributeCandies(arr3));
        System.out.println(solution.distributeCandies(arr4));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int distributeCandies(int[] candies) {
        HashSet < Integer > set = new HashSet< >();
        for (int candy: candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}