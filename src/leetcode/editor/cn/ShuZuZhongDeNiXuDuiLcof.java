/*
//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//

package leetcode.editor.cn;
public class  ShuZuZhongDeNiXuDuiLcof{
    public static void main(String[] args){
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        int[] n ={7,5,6,4};
        int ret = solution.reversePairs(n);
        System.out.println(ret);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {
        int[] sort = new int[nums.length];
        int l = 0,r = nums.length;
        return sort(nums,sort,l,r);
    }
    int sort(int[] nums,int[] sort,int l,int r){
        if(l>r) return 0;
        int pos = l+(r-l)/2;
        int count = sort(nums,sort,l,pos)+sort(nums,sort,pos+1,r);
        int i = l,j=pos+1,m=pos+1;
        while (i<=pos&&j<=r){
            if(nums[i]<=nums[j]){
                sort[pos]=nums[i];
            }
        }
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}
*/
