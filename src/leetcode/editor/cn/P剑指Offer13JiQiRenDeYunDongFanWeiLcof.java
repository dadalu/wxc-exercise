package leetcode.editor.cn;
//机器人的运动范围	
//ji-qi-ren-de-yun-dong-fan-wei-lcof	
//剑指 Offer 13
//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 133 👎 0

//Java：机器人的运动范围
public class P剑指Offer13JiQiRenDeYunDongFanWeiLcof{
    public static void main(String[] args) {
        Solution solution = new P剑指Offer13JiQiRenDeYunDongFanWeiLcof().new Solution();
        int ret=solution.movingCount(1,2,1);
        // TO TEST
        System.out.println(ret);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0,0,m,n,k,visited);
    }
    public int dfs(int i,int j,int m, int n, int k,boolean[][] visited){
        if(i<0||j<0||i>m-1||j>n-1||i/10+i%10+j/10+j%10>k){
            return 0;
        }
        if(visited[i][j]){
            return 0;
        }else{
            visited[i][j]=true;
        }
        return dfs(i+1,j,m,n,k,visited)
                +dfs(i-1,j,m,n,k,visited)
                +dfs(i,j+1,m,n,k,visited)
                +dfs(i,j-1,m,n,k,visited)+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
