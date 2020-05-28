//统计所有小于非负整数 n 的质数的数量。 
//
// 示例: 
//
// 输入: 10
//输出: 4
//解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
// Related Topics 哈希表 数学

package leetcode.editor.cn;
public class  CountPrimes{
    public static void main(String[] args){
        Solution solution = new CountPrimes().new Solution();
        solution.countPrimes(10);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        int count =0;
        for (int i = 0; i < n; i++) {
            if(isPrime(i))count++;
        }
        return count;
    }
    boolean isPrime(int x) {
        if (x<2) return false;
        for (int i=2;i*i<=x;i++)
            if (x%i==0) return false;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
