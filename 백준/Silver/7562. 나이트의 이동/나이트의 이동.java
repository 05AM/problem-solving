import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
    private static final int[] dy = {-2, -2, -1, 1, 2, 2, 1, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int l = in.nextInt();
            int[][] board = new int[l][l];

            int startY = in.nextInt();
            int startX = in.nextInt();

            int targetY = in.nextInt();
            int targetX = in.nextInt();

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {startY, startX});
            board[startY][startX] = 1;

            while (!queue.isEmpty()) {
                int[] now = queue.poll();

                if (now[1] == targetX && now[0] == targetY) {
                    System.out.println(board[targetY][targetX] - 1);
                    break;
                }

                for (int j = 0; j < 8; j++) {
                    int nx = now[1] + dx[j];
                    int ny = now[0] + dy[j];

                    if (nx < 0 || nx >= l || ny < 0 || ny >= l) {
                        continue;
                    }

                    if (board[ny][nx] == 0) {
                        board[ny][nx] = board[now[0]][now[1]] + 1;
                        queue.add(new int[] {ny, nx});
                    }
                }
            }
        }
    }
}