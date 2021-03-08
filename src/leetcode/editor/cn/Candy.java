package leetcode.editor.cn;
//分发糖果
//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 相邻的孩子中，评分高的孩子必须获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 示例 1: 
//
// 输入: [1,0,2]
//输出: 5
//解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2: 
//
// 输入: [1,2,2]
//输出: 4
//解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 293 👎 0

public class Candy{
    public static void main(String[] args) {
        Solution solution = new Candy().new Solution();
        int[] arr ={1,3,4,5,2};
        solution.candy(arr);
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        int[] arr = new int[ratings.length];
        arr[0]=1;
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i]>ratings[i-1]){
                arr[i] = arr[i - 1] + 1;
            }else{
                arr[i] = 1;
            }
        }
        for (int i = ratings.length-1; i > 0; i--) {
            if(ratings[i-1]>ratings[i]&&arr[i-1]<=arr[i]){
                arr[i - 1] = arr[i]+1;
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}