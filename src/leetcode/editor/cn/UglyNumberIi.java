package leetcode.editor.cn;
//丑数 II
//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划 
// 👍 463 👎 0

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumberIi{
    public static void main(String[] args) {
        Solution solution = new UglyNumberIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> PriorityQueue = new PriorityQueue<>();
        Set<Long> list = new HashSet<>();
        PriorityQueue.add(1L);
        while ( true ) {
            Long val = PriorityQueue.poll();
            if ( !list.contains(val) ) {
                list.add(val);
                PriorityQueue.add( val * 2 );
                PriorityQueue.add( val * 3 );
                PriorityQueue.add( val * 5 );
            }
            if ( list.size() == n ) {
                return val.intValue();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}