//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组
package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  MergeIntervals{
    public static void main(String[] args){
        Solution solution = new MergeIntervals().new Solution();
        int[][] a = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
        Object[] obj = solution.merge(a);
        System.out.println(obj.toString());
    }
    


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public Object[] merge(int[][] intervals) {

        int len = intervals.length;
        List<int[]> retNums= new ArrayList<>();
        if (intervals == null || intervals.length == 0){
            return retNums.toArray(new int[0][]);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i <= len-1; i++) {
            int j=i;
            while(j+1 <= len-1&&intervals[j][1]>=intervals[j+1][0]){
                j++;
            }
            int left = intervals[i][0];
            int right = intervals[i][1];
            if(right<intervals[j][1]){
                right=intervals[j][1];
            }
            retNums.add(new int[]{left,right});
            i=j;
        }
        return retNums.toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
