import java.util.List;
import java.util.Scanner;

public class Main {

    static int answer = 0;
    static int n;
    static int[][] map;
    static boolean[][] isVisited;

    enum Direction {
        HORIZONTAL,
        VERTICAL,
        DIAGONAL
        ;

        List<Move> movable; // final 제거

        static {
            HORIZONTAL.movable = List.of(Move.MOVE_HORIZONTAL, Move.MOVE_DIAGONAL);
            VERTICAL.movable   = List.of(Move.MOVE_VERTICAL,   Move.MOVE_DIAGONAL);
            DIAGONAL.movable   = List.of(Move.MOVE_HORIZONTAL, Move.MOVE_VERTICAL, Move.MOVE_DIAGONAL);
        }
    }

    enum Move {
        MOVE_HORIZONTAL(Direction.HORIZONTAL, new int[] {0, 1}),
        MOVE_VERTICAL(Direction.VERTICAL, new int[] {1, 0}),
        MOVE_DIAGONAL(Direction.DIAGONAL, new int[] {1, 1}),
        ;

        final Direction direction;
        final int[] moveTo;

        Move(Direction direction, int[] moveTo) {
            this.direction = direction;
            this.moveTo = moveTo;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        map = new int[n + 1][n + 1];
        isVisited = new boolean[n + 1][n + 1];

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                map[row][col] = in.nextInt();
            }
        }

        isVisited[1][2] = true;
        dfs(Direction.HORIZONTAL, 1, 2);
        System.out.println(answer);
    }

    private static void dfs(Direction direction, int row, int col) {
        if (row == n && col == n) {
            answer++;
            return;
        }

        int newRow, newCol;
        for (Move move : direction.movable) {
            int[] moveTo = move.moveTo;
            newRow = row + moveTo[0];
            newCol = col + moveTo[1];

            // 범위 안에 있고, 방문하지 않았으며, 벽이 아닌 경우
            if (newRow <= n && newCol <= n && !isVisited[newRow][newCol] && map[newRow][newCol] != 1) {
                // 대각선 벽 검사
                if (move.direction == Direction.DIAGONAL && (map[newRow - 1][newCol] == 1 || map[newRow][newCol - 1] == 1)) {
                    continue;
                }

                isVisited[newRow][newCol] = true;
                dfs(move.direction, newRow, newCol);
                isVisited[newRow][newCol] = false;
            }
        }
    }
}
