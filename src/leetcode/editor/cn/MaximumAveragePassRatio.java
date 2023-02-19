package leetcode.editor.cn;
//最大平均通过率	
//maximum-average-pass-ratio	
//1792
//一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 classes ，其中 classes[i] = [
//passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。 
//
// 给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。你需要给这 
//extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。 
//
// 一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。 
//
// 请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10⁻⁵ 以内的结果都会视为正确结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：classes = [[1,2],[3,5],[2,2]], extraStudents = 2
//输出：0.78333
//解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
// 
//
// 示例 2： 
//
// 
//输入：classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
//输出：0.53485
// 
//
// 
//
// 提示： 
//
// 
// 1 <= classes.length <= 10⁵ 
// classes[i].length == 2 
// 1 <= passi <= totali <= 10⁵ 
// 1 <= extraStudents <= 10⁵ 
// 
//
// Related Topics 贪心 数组 堆（优先队列） 👍 80 👎 0

import java.util.*;

//Java：最大平均通过率
public class MaximumAveragePassRatio{
    public static void main(String[] args) {
        Solution solution = new MaximumAveragePassRatio().new Solution();
        int[][] arr = {{1, 2}, {3, 5}, {2, 2}};
        System.out.println(solution.maxAverageRatio(arr, 2));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            double d1 = (double) (o1[0] + 1) / (double) (o1[1] + 1) - (double) o1[0] / (double) o1[1];
            double d2 = (double) (o2[0] + 1) / (double) (o2[1] + 1) - (double) o2[0] / (double) o2[1];
            if (d1 == d2) {
                return 0;
            } else if (d1 > d2) {
                return -1;
            } else {
                return 1;
            }
        });
        for (int i = 0; i < classes.length; i++) {
            priorityQueue.add(classes[i]);
        }
        int[] newPoll;
        for (int i = 0; i < extraStudents; i++) {
            int[] poll = priorityQueue.poll();
            newPoll = new int[]{poll[0] + 1, poll[1] + 1};
            priorityQueue.add(newPoll);
        }
        double total = 0;
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            total += 1.0*poll[0] / poll[1];
        }
        return total / classes.length;
    }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
