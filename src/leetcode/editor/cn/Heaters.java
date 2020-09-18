package leetcode.editor.cn;
//供暖器
//冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。 
//
// 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。 
//
// 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。 
//
// 说明: 
//
// 
// 给出的房屋和供暖器的数目是非负数且不会超过 25000。 
// 给出的房屋和供暖器的位置均是非负数且不会超过10^9。 
// 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。 
// 所有供暖器都遵循你的半径标准，加热的半径也一样。 
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3],[2]
//输出: 1
//解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
// 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4],[1,4]
//输出: 1
//解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
// 
// Related Topics 二分查找 
// 👍 152 👎 0

import java.util.Arrays;

public class Heaters{
    public static void main(String[] args) {
        Solution solution = new Heaters().new Solution();
        int[] houses = {1,2,3};
        int[] heaters = {2};
        System.out.println(solution.findRadius(houses, heaters));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int min = 0;
        int round = 0;
        for (int house:houses
             ) {
            int l = 0;
            int r  = heaters.length-1;
            while(l<=r){
                int mid = l+(r-l)/2;
                if(heaters[mid]>house){
                    r = mid-1;
                }else if(heaters[mid]<house){
                    l = mid+1;
                }else{
                    //仅对round进行标记
                    round = -1;
                    break;
                }
            }
            if(round!=-1){
                if(l>heaters.length-1){
                    round = house-heaters[heaters.length-1];
                }else if(r<0){
                    round = heaters[0]-house;
                }else{
                    round = Math.min(Math.abs(heaters[l]-house),Math.abs(heaters[r]-house));
                }
            }else{
                round =0;
            }

            min = Math.max(min,round);
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}