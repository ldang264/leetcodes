package q00036m;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidSudoku {
    public static void main(String[] args) {
        IsValidSudoku ivs = new IsValidSudoku();
        char[][] s1 = new char[][] {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(ivs.isValidSudoku(s1));
        char[][] s2 = new char[][] {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(ivs.isValidSudoku(s2));
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Character> es = new HashSet<>(8);
        for (int i = 0; i < board.length; i++) {
            if (!validRow(board[i], es)) {
                return false;
            }
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.') {
                    if (es.contains(board[j][i])) {
                        return false;
                    }
                    es.add(board[j][i]);
                }
            }
            es.clear();
            if (i % 3 == 0) {
                for (int j = 0; j <= 6; j += 3) {
                    if (board[i][j] != '.') {
                        es.add(board[i][j]);
                    }
                    if (board[i][j + 1] != '.') {
                        if (es.contains(board[i][j + 1])) {
                            return false;
                        }
                        es.add(board[i][j + 1]);
                    }
                    if (board[i][j + 2] != '.') {
                        if (es.contains(board[i][j + 2])) {
                            return false;
                        }
                        es.add(board[i][j + 2]);
                    }
                    if (board[i + 1][j] != '.') {
                        if (es.contains(board[i + 1][j])) {
                            return false;
                        }
                        es.add(board[i + 1][j]);
                    }
                    if (board[i + 1][j + 1] != '.') {
                        if (es.contains(board[i + 1][j + 1])) {
                            return false;
                        }
                        es.add(board[i + 1][j + 1]);
                    }
                    if (board[i + 1][j + 2] != '.') {
                        if (es.contains(board[i + 1][j + 2])) {
                            return false;
                        }
                        es.add(board[i + 1][j + 2]);
                    }
                    if (board[i + 2][j] != '.') {
                        if (es.contains(board[i + 2][j])) {
                            return false;
                        }
                        es.add(board[i + 2][j]);
                    }
                    if (board[i + 2][j + 1] != '.') {
                        if (es.contains(board[i + 2][j + 1])) {
                            return false;
                        }
                        es.add(board[i + 2][j + 1]);
                    }
                    if (board[i + 2][j + 2] != '.') {
                        if (es.contains(board[i + 2][j + 2])) {
                            return false;
                        }
                    }
                    es.clear();
                }
            }
        }
        return true;
    }

    private boolean validRow(char[] row, Set<Character> es) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] != '.') {
                if (es.contains(row[i])) {
                    return false;
                }
                es.add(row[i]);
            }
        }
        es.clear();
        return true;
    }

}
