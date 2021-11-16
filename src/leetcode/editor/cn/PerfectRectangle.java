package leetcode.editor.cn;
//完美矩形
//给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是
// (xi, yi) ，右上顶点是 (ai, bi) 。 
//
// 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。 
// 
//
// 示例 1： 
//
// 
//输入：rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
//输出：true
//解释：5 个矩形一起可以精确地覆盖一个矩形区域。 
// 
//
// 示例 2： 
//
// 
//输入：rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
//输出：false
//解释：两个矩形之间有间隔，无法覆盖成一个矩形。 
//
// 示例 3： 
//
// 
//输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[3,2,4,4]]
//输出：false
//解释：图形顶端留有空缺，无法覆盖成一个矩形。 
//
// 示例 4： 
//
// 
//输入：rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
//输出：false
//解释：因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。 
//
// 
//
// 提示： 
//
// 
// 1 <= rectangles.length <= 2 * 104 
// rectangles[i].length == 4 
// -105 <= xi, yi, ai, bi <= 105 
// 
// Related Topics 数组 扫描线 
// 👍 190 👎 0

import java.util.HashMap;
import java.util.Map;

public class PerfectRectangle {
    public static void main(String[] args) {
        Solution solution = new PerfectRectangle().new Solution();
        //int[][] arr = {{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
        int[][] arr = {{0,0,1,1},{0,0,1,1},{1,1,2,2},{1,1,2,2}};
        System.out.println(solution.isRectangleCover(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isRectangleCover(int[][] rectangles) {
            int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE, minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
            int area = 0;
            Map<Point, Integer> map = new HashMap<>();
            for (int i = 0; i < rectangles.length; i++) {
                minX = Math.min(minX, rectangles[i][0]);
                minY = Math.min(minY, rectangles[i][1]);
                maxX = Math.max(maxX, rectangles[i][2]);
                maxY = Math.max(maxY, rectangles[i][3]);
                Point point = new Point(rectangles[i][0], rectangles[i][1]);
                map.put(point, map.getOrDefault(point, 0) + 1);
                point = new Point(rectangles[i][2], rectangles[i][3]);
                map.put(point, map.getOrDefault(point, 0) + 1);
                point = new Point(rectangles[i][0], rectangles[i][3]);
                map.put(point, map.getOrDefault(point, 0) + 1);
                point = new Point(rectangles[i][2], rectangles[i][1]);
                map.put(point, map.getOrDefault(point, 0) + 1);
                area += (rectangles[i][3] - rectangles[i][1]) * (rectangles[i][2] - rectangles[i][0]);
            }
            int sum = (maxX - minX) * (maxY - minY);
            if (sum != area) {
                return false;
            }
            Point mPoint = new Point(maxX, maxY);
            if (map.getOrDefault(mPoint,0) != 1) {
                return false;
            }
            map.remove(mPoint);
            mPoint = new Point(maxX, minY);
            if (map.getOrDefault(mPoint,0) != 1) {
                return false;
            }
            map.remove(mPoint);
            mPoint = new Point(minX, minY);
            if (map.getOrDefault(mPoint,0) != 1) {
                return false;
            }
            map.remove(mPoint);
            mPoint = new Point(minX, maxY);
            if (map.getOrDefault(mPoint,0) != 1) {
                return false;
            }
            map.remove(mPoint);
            for (Integer i : map.values()) {
                if (i != 2 && i != 4) {
                    return false;
                }
            }
            return true;
        }
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x + y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point point2 = (Point) obj;
                return this.x == point2.x && this.y == point2.y;
            }
            return false;
        }
    }
}