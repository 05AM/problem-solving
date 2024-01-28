import java.util.Scanner;
import java.util.Stack;

public class Main {
    private int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        for (int pos : moves) {
            for (int row = 0; row < board.length; row++) {
                // 가장 위의 인형을 만났을 때
                if (board[row][pos - 1] != 0) {
                    int dollNo = board[row][pos - 1];
                    board[row][pos - 1] = 0;

                    if (!basket.isEmpty() && basket.peek() == dollNo) {
                        basket.pop();
                        answer += 2;
                    } else {
                        basket.push(dollNo);
                    }
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
        }

        int m = in.nextInt();
        int[] moves = new int[m];

        for (int i = 0; i < m; i++) {
            moves[i] = in.nextInt();
        }

        System.out.println(T.solution(board, moves));
    }
}
