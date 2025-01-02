import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int row;
    int col;
    int cnt;
    boolean canBreak;

    public Node(int row, int col, int cnt, boolean canBreak) {
        this.row = row;
        this.col = col;
        this.cnt = cnt;
        this.canBreak = canBreak;
    }
}

public class Main {
    private static final int START_ROW = 1;
    private static final int START_COL = 1;

    private static final int[] directionRow = {1, 0, -1, 0};
    private static final int[] directionCol = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] matrix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String[] input = in.next().split("");
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        int result = getShortestPath(n, m, matrix);
        System.out.println(result);
    }

    private static int getShortestPath(int n, int m, int[][] matrix) {
        boolean[][] visitedWithoutBreaking = new boolean[n + 1][m + 1];
        boolean[][] visitedAfterBreaking = new boolean[n + 1][m + 1];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(START_ROW, START_COL, 1, true));
        visitedWithoutBreaking[START_ROW][START_COL] = true;

        int min = -1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.row == n && node.col == m) {
                min = node.cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = node.row + directionRow[i];
                int nextCol = node.col + directionCol[i];

                if (nextRow > n || nextRow <= 0 || nextCol > m || nextCol <= 0) {
                    continue;
                }

                if (matrix[nextRow][nextCol] == 1) {
                    if (node.canBreak && !visitedAfterBreaking[nextRow][nextCol]) {
                        visitedAfterBreaking[nextRow][nextCol] = true;
                        queue.add(new Node(nextRow, nextCol, node.cnt + 1, false));
                    }
                } else {
                    if (node.canBreak && !visitedWithoutBreaking[nextRow][nextCol]) {
                        visitedWithoutBreaking[nextRow][nextCol] = true;
                        queue.add(new Node(nextRow, nextCol, node.cnt + 1, node.canBreak));
                    } else if (!node.canBreak && !visitedAfterBreaking[nextRow][nextCol]) {
                        visitedAfterBreaking[nextRow][nextCol] = true;
                        queue.add(new Node(nextRow, nextCol, node.cnt + 1, node.canBreak));
                    }
                }
            }
        }

        return min;
    }
}