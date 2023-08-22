package leetcode.editor.cn;
//到最近的人的最大距离
//maximize-distance-to-closest-person	
//849
//给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标
//从 0 开始）。 
//
// 至少有一个空座位，且至少有一人已经坐在座位上。 
//
// 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。 
//
// 返回他到离他最近的人的最大距离。 
//
// 
//
// 示例 1： 
// 
// 
//输入：seats = [1,0,0,0,1,0,1]
//输出：2
//解释：
//如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
//如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
//因此，他到离他最近的人的最大距离是 2 。 
// 
//
// 示例 2： 
//
// 
//输入：seats = [1,0,0,0]
//输出：3
//解释：
//如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
//这是可能的最大距离，所以答案是 3 。
// 
//
// 示例 3： 
//
// 
//输入：seats = [0,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 2 <= seats.length <= 2 * 10⁴ 
// seats[i] 为 0 或 1 
// 至少有一个 空座位 
// 至少有一个 座位上有人 
// 
//
// 👍 260 👎 0

//Java：到最近的人的最大距离
public class MaximizeDistanceToClosestPerson {
    public static void main(String[] args) {
        Solution solution = new MaximizeDistanceToClosestPerson().new Solution();
        // TO TEST
        int[] arr = {1,0,0,1,0,0,0,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0};
        solution.maxDistToClosest(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDistToClosest(int[] seats) {
            boolean isS = false, isE = false;
            int l = -1, r = 0, max = 0;
            while (r <= seats.length) {
                if (r<seats.length&&seats[r] == 0) {
                    r++;
                } else {
                    if (r - l > max||(r==seats.length&&(r - l -1)*2 -1>max)) {
                        if (l == -1) {
                            isS = true;
                        }else {
                            isS = false;
                        }
                        if (r == seats.length) {
                            isE = true;
                        }else {
                            isE = false;
                        }
                        if (isS) {
                            max = Math.max(max, (r - l -1)*2 -1);
                        }else if (isE) {
                            max = Math.max(max, (r - l -1)*2 -1);
                        }else {
                            max = Math.max(max, r - l - 1);
                        }
                    }
                    l = r;
                    r++;
                }
            }
            return max / 2 + max % 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}