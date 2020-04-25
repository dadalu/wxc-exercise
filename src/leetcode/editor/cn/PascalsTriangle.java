//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class  PascalsTriangle{
    public static void main(String[] args){
        Solution solution = new PascalsTriangle().new Solution();
        solution.generate(5);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> retList = new ArrayList();

        if(numRows==0) return retList;

        for (int i = 0; i < numRows; i++) {
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
        return retList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
