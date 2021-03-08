package leetcode.editor.cn;
//第 k 个数
//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
// Related Topics 堆 队列 数学 
// 👍 43 👎 0

import java.util.*;

public class GetKthMagicNumberLcci{
    public static void main(String[] args) {
        Solution solution = new GetKthMagicNumberLcci().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getKthMagicNumber(int k) {
        PriorityQueue<Long> PriorityQueue = new PriorityQueue<>();
        Set<Long> list = new HashSet<>();
        PriorityQueue.add(1L);
        while ( true ) {
            Long val = PriorityQueue.poll();
            if ( !list.contains(val) ) {
                list.add(val);
                PriorityQueue.add( val * 3 );
                PriorityQueue.add( val * 5 );
                PriorityQueue.add( val * 7 );
            }
            if ( list.size() == k ) {
                return val.intValue();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}