package leetcode.editor.cn;
//子数组最大平均数 I
//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。 
//
// 示例 1: 
//
// 输入: [1,12,-5,-6,50,3], k = 4
//输出: 12.75
//解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 
//
// 注意: 
//
// 
// 1 <= k <= n <= 30,000。 
// 所给数据范围 [-10,000，10,000]。 
// 
// Related Topics 数组 
// 👍 112 👎 0

import java.io.*;

public class MaximumAverageSubarrayI{
    public static void main(String[] args) {
        Solution solution = new MaximumAverageSubarrayI().new Solution();
        int[] arr = null;
        String jsonStr = "";
        try {
            File jsonFile = new File("E:\\wangxiaocheng\\leetcode\\src\\leetcode\\editor\\testData\\testData.json");
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] chars = jsonStr.split(",");
        arr = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            arr[i] = Integer.valueOf(chars[i]);
        }
        //System.out.println(solution.findMaxAverage(arr, 6514));
        int[] arr1 ={0,4,0,3,2};
        System.out.println(solution.findMaxAverage(arr1, 1));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = 0;
        for (int i = 0; i < k; i++) {
            max += nums[i];
        }
        double cur = max;
        for (int i = 0; i < nums.length-k; i++) {
            cur = cur-nums[i]+nums[i+k];
            max = Math.max(max,cur);
        }
        return max/k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}