package leetcode.editor.cn;
//距离相等的条形码
//在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。 
//
// 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。 
//
// 
//
// 示例 1： 
//
// 输入：[1,1,1,2,2,2]
//输出：[2,1,2,1,2,1]
// 
//
// 示例 2： 
//
// 输入：[1,1,1,1,2,2,3,3]
//输出：[1,3,1,3,2,1,2,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= barcodes.length <= 10000 
// 1 <= barcodes[i] <= 10000 
// 
//
// 
// Related Topics 堆 排序 
// 👍 58 👎 0

import java.util.*;

public class DistantBarcodes{
    public static void main(String[] args) {
        Solution solution = new DistantBarcodes().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < barcodes.length; i++) {
            map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue((o1,o2)-> map.get(o2) - map.get(o1));
        for (Integer num:map.keySet()) {
            queue.offer(num);
        }
        while (queue.size()>1) {
            int f = queue.poll();
            int s = queue.poll();
            map.put(f, map.get(f) - 1);
            map.put(s, map.get(s) - 1);
            if (map.get(f) <= 0) {
                map.remove(f);
            }else {
                queue.offer(f);
            }
            if (map.get(s) <= 0) {
                map.remove(s);
            }else {
                queue.offer(s);
            }
            list.add(f);
            list.add(s);
        }
        if(!queue.isEmpty())
        list.add(queue.poll());
        for (int i = 0; i < list.size(); i++) {
            barcodes[i] = list.get(i);
        }
        return barcodes;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}