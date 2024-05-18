package leetcode.editor.cn;
//完成所有任务的最少时间
//minimum-time-to-complete-all-tasks	
//2589
//你有一台电脑，它可以 同时 运行无数个任务。给你一个二维整数数组 tasks ，其中 tasks[i] = [starti, endi, 
//durationi] 表示第 i 个任务需要在 闭区间 时间段 [starti, endi] 内运行 durationi 个整数时间点（但不需要连续）。 
//
// 当电脑需要运行任务时，你可以打开电脑，如果空闲时，你可以将电脑关闭。 
//
// 请你返回完成所有任务的情况下，电脑最少需要运行多少秒。 
//
// 
//
// 示例 1： 
//
// 输入：tasks = [[2,3,1],[4,5,1],[1,5,2]]
//输出：2
//解释：
//- 第一个任务在闭区间 [2, 2] 运行。
//- 第二个任务在闭区间 [5, 5] 运行。
//- 第三个任务在闭区间 [2, 2] 和 [5, 5] 运行。
//电脑总共运行 2 个整数时间点。
// 
//
// 示例 2： 
//
// 输入：tasks = [[1,3,2],[2,5,3],[5,6,2]]
//输出：4
//解释：
//- 第一个任务在闭区间 [2, 3] 运行
//- 第二个任务在闭区间 [2, 3] 和 [5, 5] 运行。
//- 第三个任务在闭区间 [5, 6] 运行。
//电脑总共运行 4 个整数时间点。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tasks.length <= 2000 
// tasks[i].length == 3 
// 1 <= starti, endi <= 2000 
// 1 <= durationi <= endi - starti + 1 
// 
//
// 👍 59 👎 0

public class MinimumTimeToCompleteAllTasks {
    public static void main(String[] args) {
        Solution solution = new MinimumTimeToCompleteAllTasks().new Solution();
        // TO TEST
        int [][] arr = {{4,5,1},{1,5,2},{2,3,1}};
        System.out.println(solution.findMinimumTime(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinimumTime(int[][] tasks) {
            int res = 0;
            for (int i = 1; ; i++) {
                boolean finished = true, run = false;
                for (int[] task : tasks) {
                    if (task[2]>0&&task[1] - i + 1 == task[2]) {
                        run = true;
                    }
                    if (i <= task[1]) {
                        finished = false;
                    }
                }
                if (finished) {
                    break;
                }
                if (run) {
                    for (int j = 0; j < tasks.length; j++) {
                        if (i >= tasks[j][0] && i <= tasks[j][1] && tasks[j][2] > 0) {
                            tasks[j][2]--;
                        }
                    }
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}