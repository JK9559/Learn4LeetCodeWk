package wkang.learn.part1;

/**
 * @author kangwei
 * @date 2018/12/29
 * https://leetcode.com/problems/sudoku-solver/
 * 暴力破解数独
 * 如果行数下标到了MAX_VAL 说明填完了，返回true
 * 如果列数下标到了MAX_VAL 说明这列填完了，返回下一行的下标0元素
 * 如果要填的数是空，则依次从1开始尝试填入数字验证可以填之后填下一个数字，如果验证不通过，则还原为空
 */
public class Problem037 {

    private static final int MAX_VAL = 9;
    private static final int MAX_SUB = 3;
    private static final char BLANK = '.';

    public void solveSudoku(char[][] board) {
        if (solveSudokuByQ(board, 0, 0)) {
            for (int i = 0; i < MAX_VAL; i++) {
                System.out.println("--------------------------");
                for (int j = 0; j < MAX_VAL; j++) {
                    System.out.print(board[i][j]+"|");
                }
            }
        }
    }

    public boolean solveSudokuByQ(char[][] board, int i, int j) {
        if (MAX_VAL == i) {
            return true;
        }
        if (MAX_VAL == j) {
            return solveSudokuByQ(board, i + 1, 0);
        }
        if (BLANK == board[i][j]) {
            for (int val = 1; val <= MAX_VAL; val++) {
                board[i][j] = (char) (val + '0');
                if (isVal(board, i, j)) {
                    if (solveSudokuByQ(board, i, j + 1)) {
                        return true;
                    }
                }
                board[i][j] = BLANK;
            }
        } else {
            if (solveSudokuByQ(board, i, j + 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean isVal(char[][] board, int i, int j) {
        for (int row = 0; row < MAX_VAL; row++) {
            if (row != i && board[row][j] == board[i][j]) {
                return false;
            }
        }
        for (int col = 0; col < MAX_VAL; col++) {
            if (col != j && board[i][col] == board[i][j]) {
                return false;
            }
        }
        for (int row = i / MAX_SUB * MAX_SUB; row < i / MAX_SUB * MAX_SUB + MAX_SUB; row++) {
            for (int col = j / MAX_SUB * MAX_SUB; col < j / MAX_SUB * MAX_SUB + MAX_SUB; col++) {
                if (row != i && col != j && board[row][col] == board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] abc = {
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '3', '6', '.', '.', '.', '.', '.'},
                {'.', '7', '.', '.', '9', '.', '2', '.', '.'},
                {'.', '5', '.', '.', '.', '7', '.', '.', '.'},
                {'.', '.', '.', '.', '4', '5', '7', '.', '.'},
                {'.', '.', '.', '1', '.', '.', '.', '3', '.'},
                {'.', '.', '1', '.', '.', '.', '.', '6', '8'},
                {'.', '.', '8', '5', '.', '.', '.', '1', '.'},
                {'.', '9', '.', '.', '.', '.', '4', '.', '.'}};
        Problem037 pro = new Problem037();
        long startTime = System.currentTimeMillis();
        pro.solveSudoku(abc);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + "ms");
    }

}
