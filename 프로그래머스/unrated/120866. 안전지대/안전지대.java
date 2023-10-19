import java.util.*;

class Solution {
    public int solution(int[][] board) {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board.length; col++) {
                if(board[row][col] == 1) {
                    setArea(board, row, col);
                }
            }
        }

        return (int) Arrays.stream(board)
            .mapToInt(arr -> (int) Arrays.stream(arr).filter(i -> i == 0).count())
            .sum();
    }
    
    public void setArea(int[][] board, int row, int col) {
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                try {
                    if(board[row + i][col + j] == 0)
                        board[row + i][col + j] = 2;
                } catch(Exception e) {
                }
            }
        }
    }
}