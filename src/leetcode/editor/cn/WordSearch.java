package leetcode.editor.cn;
//单词搜索
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1018 👎 0

public class WordSearch{
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        //char[][] board = {{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}};
        //[["A","B","C","E"],
        // ["S","F","C","S"],
        // ["A","D","E","E"]]
        /*char[][] board = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };*/
        char[][] board = {
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'},
                {'A','A','A','A','A','A'}};

        String word = "AAAAAAAAAAAAAAB";
        System.out.println(solution.exist(board, word));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean b = false;
        boolean[][] arr = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    b = dfs(board,word,i,j,0,arr);
                    if (b) {
                        return b;
                    }
                }
            }
        }
        return b;
    }

    private boolean dfs(char[][] board, String word, int i,int j, int index,boolean [][] arr) {
        if (board[i][j] == word.charAt(index)){
            if (index == word.length()-1) {
                return true;
            }
            arr[i][j] = true;
            if (i + 1<board.length&&!arr[i + 1][j]) {
                if (dfs(board, word, i + 1, j, index + 1,arr)) {
                    return true;
                }
            }
            if (i - 1>-1&&!arr[i - 1][j]) {
                if (dfs(board, word, i - 1, j, index + 1,arr)) {
                    return true;
                }
            }
            if (j + 1<board[i].length&&!arr[i][j + 1]) {
                if (dfs(board, word, i, j + 1, index + 1,arr)) {
                    return true;
                }
            }
            if (j - 1>-1&&!arr[i][j - 1]) {
                if (dfs(board, word, i, j - 1, index + 1,arr)) {
                    return true;
                }
            }
            arr[i][j] = false;
            return false;
        }
        return false;
    }
}
}