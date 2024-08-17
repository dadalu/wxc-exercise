package leetcode.editor.cn;

//你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下： 
//
// 
// 你写出一个秘密数字，并请朋友猜这个数字是多少。 
// 朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位属于数字猜对了但是位置不对
//（称为“Cows”, 奶牛）。 
// 朋友根据提示继续猜，直到猜出秘密数字。 
// 
//
// 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用 B 表示奶牛。 
//
// 
// xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。 
// yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。 
// 
//
// 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。 
//
// 
//
// 示例 1: 
//
// 输入: secret = "1807", guess = "7810"
//输出: "1A3B"
//解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。 
//
// 示例 2: 
//
// 输入: secret = "1123", guess = "0111"
//输出: "1A1B"
//解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。 
//
// 
//
// 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。 
// Related Topics 哈希表 
// 👍 85 👎 0

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows{
    public static void main(String[] args) {
        Solution solution = new BullsAndCows().new Solution();
        System.out.println(solution.getHint("1122","0001"));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getHint(String secret, String guess) {
        Map map = new HashMap();
        char[] chars = secret.toCharArray();
        char[] chars1 = guess.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(i,chars[i]);
        }
        int x = 0;
        int y = 0;
        int size = map.size();
        for (int i = 0; i < chars1.length; i++) {
            if(map.get(i).equals(chars1[i])){
                x++;
                map.remove(i);
                chars1[i]=' ';
            }
        }
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != ' '&&map.containsValue(chars1[i])) {
                for (int j = 0; j < size; j++) {
                    if(map.get(j)!=null&&map.get(j).equals(chars1[i])){
                        map.remove(j);
                        y++;
                        break;
                    }
                }
            }
        }
        return x+"A"+y+"B";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}