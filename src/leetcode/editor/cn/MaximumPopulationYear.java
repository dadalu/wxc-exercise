package leetcode.editor.cn;
//人口最多的年份
//给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。 
//
// 年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内
//。注意，人不应当计入他们死亡当年的人口中。 
//
// 返回 人口最多 且 最早 的年份。 
//
// 
//
// 示例 1： 
//
// 输入：logs = [[1993,1999],[2000,2010]]
//输出：1993
//解释：人口最多为 1 ，而 1993 是人口为 1 的最早年份。
// 
//
// 示例 2： 
//
// 输入：logs = [[1950,1961],[1960,1971],[1970,1981]]
//输出：1960
//解释： 
//人口最多为 2 ，分别出现在 1960 和 1970 。
//其中最早年份是 1960 。 
//
// 
//
// 提示： 
//
// 
// 1 <= logs.length <= 100 
// 1950 <= birthi < deathi <= 2050 
// 
// Related Topics 数组 计数 
// 👍 25 👎 0

public class MaximumPopulationYear{
    public static void main(String[] args) {
        Solution solution = new MaximumPopulationYear().new Solution();
        int[][] logs ={{1966,1968},{1954,2030},{1966,1994},{2030,2044},{1988,2036},{1977,2050},{2036,2046},{1989,2048},{2049,2050},{2008,2019},{2022,2031},{1970,2024},{1957,1996},{1991,2034},{1956,1996},{1959,1969},{2021,2050}};
        solution.maximumPopulation(logs);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumPopulation(int[][] logs) {
        /*Arrays.sort(logs, Comparator.comparingInt(o -> o[0]));
        Map<Integer, Integer> map = new TreeMap<>(Comparator.comparingInt(o -> o));
        Set<Integer> set = new TreeSet<>(Comparator.comparingInt(Integer::intValue));
        for (int i = 0; i < logs.length; i++) {
            map.put(logs[i][0], map.getOrDefault(logs[i][0], 0) + 1);
            set.add(logs[i][0]);
        }

        for (int i = 0; i < logs.length; i++) {
            for (Integer year:set) {
                if (logs[i][1] > year&&logs[i][0] < year) {
                    map.put(year, map.getOrDefault(year, 0) + 1);
                }
            }
        }
        int year = logs[0][0],max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()
        ) {
            if (entry.getValue() > max) {
                max = Math.max(max, entry.getValue());
                year = entry.getKey();
            } else if (entry.getValue() == max) {
                year = Math.min(year, entry.getKey());
            }
        }
        return year;*/
        int[] years = new int[101];
        for (int i = 0; i < logs.length; i++) {
            for (int j = logs[i][0]; j < logs[i][1]; j++) {
                years[j - 1949]++;
            }
        }
        int max = Integer.MIN_VALUE;
        int year = 1949;
        for (int i = 0; i < years.length; i++) {
            if (years[i] > max) {
                max = years[i];
                year = 1949 + i;
            }
        }
        return year;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}