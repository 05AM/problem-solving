import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int[][] newBoard = new int[board.length][board.length];

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board.length; col++) {
                if(board[row][col] == 1) {
                    // 자기자신
                    newBoard[row][col] = 1;

                    // -1 행
                    if(row - 1 >= 0) {
                        newBoard[row - 1][col] = 2;
                        if(col - 1 >= 0)
                            newBoard[row - 1][col - 1] = 2;
                        if(col + 1 < board.length)
                            newBoard[row - 1][col + 1] = 2;
                    }
                    // 0 행
                    if(col - 1 >= 0)
                        newBoard[row][col - 1] = 2;
                    if(col + 1 < board.length)
                        newBoard[row][col + 1] = 2;

                    // 1 행
                    if(row + 1 < board.length) {
                        newBoard[row + 1][col] = 2;
                        if(col - 1 >= 0)
                            newBoard[row + 1][col - 1] = 2;
                        if(col + 1 < board.length)
                            newBoard[row + 1][col + 1] = 2;
                    }
                }
            }
        }

        return (int) Arrays.stream(newBoard)
                .mapToInt(arr -> (int) Arrays.stream(arr).filter(i -> i == 0).count())
                .sum();
    }
}