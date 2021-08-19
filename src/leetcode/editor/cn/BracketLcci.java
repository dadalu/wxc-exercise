package leetcode.editor.cn;
//括号
//括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。 
//
// 说明：解集不能包含重复的子集。 
//
// 例如，给出 n = 3，生成结果为： 
//
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 81 👎 0

import java.util.ArrayList;
import java.util.List;

public class BracketLcci{
    public static void main(String[] args) {
        Solution solution = new BracketLcci().new Solution();
        solution.generateParenthesis(
                3
        );
    }

//leetcode submit region begin(Prohibit modification and deletion)
/*class Solution {
    public List<String> generateParenthesis(int n) {

    }
}*/

    /**
     *暴力法
      */
 /*   class Solution{
        public List<String> generateParenthesis(int n){
            List<String> list = new ArrayList<>();
            generate(new StringBuilder(), 0, 0, list,n);
            return list;
        }

        public void generate(StringBuilder sb, int l, int r, List<String> retList,int max) {
            if (sb.length() == max * 2) {
                retList.add(sb.toString());
                return;
            }
            if (l < max) {
                sb.append('(');
                generate(sb,l+1,r,retList,max);
                sb = sb.deleteCharAt(sb.length() - 1);
            }
            if (r < l) {
                sb.append(')');
                generate(sb,l,r+1,retList,max);
                sb = sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
*/

    /**
     * 回溯法
     */
    /*class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        char[] arr = new char[2*n];
        generate(arr, 0, list);
        return list;
    }
    public void generate(char[] res,int index,List<String> retList) {
        if (index == res.length) {
            if (isvalid(res)) {
                retList.add(new String(res));
            }
        } else {
            res[index] = '(';
            generate(res, index + 1, retList);
            res[index] = ')';
            generate(res, index + 1, retList);
        }
    }

    public boolean isvalid(char[] chars) {
        int balance = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}*/
/**
 * 递归法
 */
class Solution{
    ArrayList[] cache;
    public List<String> generateParenthesis(int n) {
        cache = new ArrayList[100];
        List<String> list = generate(n);
        return list;
    }

    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left: generate(c)) {
                    for (String right: generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}