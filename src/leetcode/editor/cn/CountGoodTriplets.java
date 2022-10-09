package leetcode.editor.cn;
//统计好三元组
//给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。 
//
// 如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。 
//
// 
// 0 <= i < j < k < arr.length 
// |arr[i] - arr[j]| <= a 
// |arr[j] - arr[k]| <= b 
// |arr[i] - arr[k]| <= c 
// 
//
// 其中 |x| 表示 x 的绝对值。 
//
// 返回 好三元组的数量 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
//输出：4
//解释：一共有 4 个好三元组：[(3,0,1), (3,0,1), (3,1,1), (0,1,1)] 。
// 
//
// 示例 2： 
//
// 输入：arr = [1,1,2,2,3], a = 0, b = 0, c = 1
//输出：0
//解释：不存在满足所有条件的三元组。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= arr.length <= 100 
// 0 <= arr[i] <= 1000 
// 0 <= a, b, c <= 1000 
// 
// Related Topics 数组 枚举 
// 👍 25 👎 0

import java.util.Arrays;

public class CountGoodTriplets{
    public static void main(String[] args) {
        Solution solution = new CountGoodTriplets().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int i,j,k;
        int cnt=0;
        int arrSize = arr.length;
        for(i=0;i<arrSize-2;i++) {
            for(j=i+1;j<arrSize-1;j++)
            {
                if(Math.abs(arr[i]-arr[j])>a) {
                    continue;           //提前判断，提高效率。
                }
                for(k=j+1;k<arrSize;k++)
                {
                    if(Math.abs(arr[j]-arr[k])>b)     //提前判断，提高效率
                    {
                        continue;
                    }
                    if((Math.abs(arr[i]-arr[j])<=a)&&(Math.abs(arr[j]-arr[k])<=b)&&(Math.abs(arr[i]-arr[k])<=c)) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}