package leetcode.editor.cn;
//无重叠区间
//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心算法 
// 👍 233 👎 0

public class NonOverlappingIntervals{
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals().new Solution();
        int[][] arr = {{1,100},{11,22},{1,11},{2,12}};
        int[][] arr1 = {{0,2},{1,3},{2,4},{3,5},{4,6}};
        solution.eraseOverlapIntervals(arr1);
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i+1; j < intervals.length; j++) {
                if(intervals[i][1]>intervals[j][1]){
                    int[] temp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }
        int count = 0;
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<intervals[index][1]){
                count++;
            }else{
                index=i;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}