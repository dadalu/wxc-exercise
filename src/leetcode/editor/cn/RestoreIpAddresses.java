package leetcode.editor.cn;
//复原 IP 地址
//restore-ip-addresses	
//93
//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// 👍 1410 👎 0

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses{
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        // TO TEST
        String str = "0000";
        solution.restoreIpAddresses(str);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        String s;
        List<String> ret = new ArrayList<>();
        public List<String> restoreIpAddresses(String s) {
        this.s = s;
        if (s.length() < 4 || s.length() > 12) {
            return ret;
        }
            List<String> temp = new ArrayList<>();
            findNextIndex(0, 0,temp);
        return ret;
    }


        private void findNextIndex( int sed,int start,List<String> temp) {
            if (sed == 4 && start == s.length()) {
                ret.add(String.join(".", temp));
            } else if (start == s.length()||sed>4) {
                return;
            }
            if (start<s.length()&&s.charAt(start) == '0') {
                temp.add(s.substring(start, start + 1));
                findNextIndex(sed + 1, start + 1,temp);
                temp.remove(temp.size() - 1);
            } else {
                for (int i = start; i < start + 3; i++) {
                    if (i >= s.length()) {
                        break;
                    }
                    String sub = s.substring(start, i + 1);
                    if (Integer.parseInt(sub) <= 255) {
                        temp.add(sub);
                        findNextIndex(sed + 1, i + 1,temp);
                        temp.remove(temp.size() - 1);
                    }
                }
            }
        }

}


//leetcode submit region end(Prohibit modification and deletion)

}