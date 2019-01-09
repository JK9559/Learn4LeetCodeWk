package wkang.learn.part0;

/**
 * @author kangwei
 * @date 2018/12/28
 * https://leetcode.com/problems/valid-sudoku/
 * 验证当前数独是否合法，比较每个有值位置在当前行 当前列 当前宫是否填入过
 */
public class Problem036 {

    public static boolean isValidSudoku(char[][] board) {

        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] sub = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ('.' != board[i][j]) {
                    int num = board[i][j] - '1';
                    if (row[i][num] || col[num][j] || sub[(i / 3) * 3 + j / 3][num]) {
                        return false;
                    }
                    row[i][num] = true;
                    col[num][j] = true;
                    sub[(i / 3) * 3 + j / 3][num] = true;
                }
            }

        }
        return true;
    }


    public static void main(String[] args) {
        //isValidSudoku();
    }

}
