package leetcode.editor.cn;
//有效的回旋镖
//给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
// 
//
// 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。 
//
// 
//
// 示例 1： 
//
// 
//输入：points = [[1,1],[2,3],[3,2]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：false 
//
// 
//
// 提示： 
// 
//
// 
// points.length == 3 
// points[i].length == 2 
// 0 <= xi, yi <= 100 
// 
// Related Topics 几何 数组 数学 👍 87 👎 0

import java.util.ArrayList;
import java.util.List;

public class ValidBoomerang {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isBoomerang(int[][] points) {
            List<Double> list = new ArrayList<>();
            for (int i = 0; i < points.length; i++) {
                int offset = (i + 1)% points.length;
                if (points[offset][0] == points[i][0] && points[offset][1] == points[i][1]) {
                    return false;
                }
                double y = points[offset][1] - points[i][1];
                double x = points[offset][0] - points[i][0];
                Double rate =  x == 0 ? null : y / x;
                list.add(rate);
            }
            return list.size() == list.stream().distinct().count();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}