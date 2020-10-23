package leetcode.editor.cn;
//二进制表示中质数个计算置位
//给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。 
//
// （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。） 
//
// 示例 1: 
//
// 
//输入: L = 6, R = 10
//输出: 4
//解释:
//6 -> 110 (2 个计算置位，2 是质数)
//7 -> 111 (3 个计算置位，3 是质数)
//9 -> 1001 (2 个计算置位，2 是质数)
//10-> 1010 (2 个计算置位，2 是质数)
// 
//
// 示例 2: 
//
// 
//输入: L = 10, R = 15
//输出: 5
//解释:
//10 -> 1010 (2 个计算置位, 2 是质数)
//11 -> 1011 (3 个计算置位, 3 是质数)
//12 -> 1100 (2 个计算置位, 2 是质数)
//13 -> 1101 (3 个计算置位, 3 是质数)
//14 -> 1110 (3 个计算置位, 3 是质数)
//15 -> 1111 (4 个计算置位, 4 不是质数)
// 
//
// 注意: 
//
// 
// L, R 是 L <= R 且在 [1, 10^6] 中的整数。 
// R - L 的最大值为 10000。 
// 
// Related Topics 位运算 
// 👍 49 👎 0

public class PrimeNumberOfSetBitsInBinaryRepresentation{
    public static void main(String[] args) {
        Solution solution = new PrimeNumberOfSetBitsInBinaryRepresentation().new Solution();
        System.out.println(solution.countPrimeSetBits(990,1048));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimeSetBits(int L, int R) {
        int ret = 0;
        for (int i = L; i <= R; i++) {
            int cur = i;
            int count = 0;
            while (cur!=0){
                if (cur % 2 == 1) {
                    count++;
                }
                cur/=2;
            }
            if (isPrimeNumber(count)) {
                ret++;
            }
        }
        return ret;
    }
    public boolean isPrimeNumber(int number){
        if(number==1)return false;
        int root = (int) Math.sqrt(number);
        for (int i = root; i >1 ; i--) {
            if(number%i==0){
                return false;
            }
        }
        System.out.println(number);
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}