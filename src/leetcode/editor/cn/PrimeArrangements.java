package leetcode.editor.cn;
//质数排列
//请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。 
//
// 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。 
//
// 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。 
//
// 
//
// 示例 1： 
//
// 输入：n = 5
//输出：12
//解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
// 
//
// 示例 2： 
//
// 输入：n = 100
//输出：682289015
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 
// Related Topics 数学 
// 👍 30 👎 0

public class PrimeArrangements{
    public static void main(String[] args) {
        Solution solution = new PrimeArrangements().new Solution();
        System.out.println(solution.numPrimeArrangements(100));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
/*
    public int numPrimeArrangements(int n) {
        int mod = (int) Math.pow(10,9)+7;
        if (n == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            boolean flag = true;                  //1、假设是质数
            for(int j = 2; j <= (int)Math.sqrt(i); j++) {   //Math.squart()取平方根
                if(i % j == 0) {
                    flag = false;              //2、改为不是质数
                    break;
                }
            }
            if(flag) {                         //3、得结论
                count++;
            }
        }
        Long mul = 1L;
        for (int i = 1; i <= count; i++) {
            mul = mul*i%(mod);
        }
        for (int i = 1; i <= n-count; i++) {
            mul = mul*i%(mod);
        }
        return mul.intValue();
    }
*/
    public int numPrimeArrangements(int n) {
        int primeCount =0;
        for(int i=2;i<= n;i++){
            if(isPrime(i)){
                primeCount++;
            }
        }
        return (int)(mul(primeCount)*mul(n-primeCount)%((int)Math.pow(10,9) + 7));
    }
    private boolean isPrime(int num){
        double sqr = Math.sqrt(num);
        for(int i=2;i<=sqr;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    private long mul(int num){
        long ans =1L;
        while(num>0){
            ans=(ans*num)%((int)Math.pow(10,9) + 7);
            num--;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}