//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class  PascalsTriangleIi{
    public static void main(String[] args){
        Solution solution = new PascalsTriangleIi().new Solution();
        solution.getRow(3);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> retList = new ArrayList();


        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            if(i!=0){
                List<Integer> tepList = retList.get(i-1);
                for (int j = 0; j <retList.size(); j++) {
                    if(j<tepList.size()-1){
                        list.add(tepList.get(j)+tepList.get(j+1));
                    }else{
                        list.add(1);
                    }
                }
            }
            retList.add(list);
        }
        return retList.get(rowIndex);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
