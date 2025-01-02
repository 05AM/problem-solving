import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int row;
    int col;
    int cnt;
    int canBreak;

    public Node(int row, int col, int cnt, int canBreak) {
        this.row = row;
        this.col = col;
        this.cnt = cnt;
        this.canBreak = canBreak;
    }
}

public class Main {
    private static final int START_ROW = 1;
    private static final int START_COL = 1;

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

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
        // [벽을 부순 여부][행][열]
        boolean[][][] isVisited = new boolean[2][n + 1][m + 1];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(START_ROW, START_COL, 1, 1));
        isVisited[0][START_ROW][START_COL] = true;

        int min = -1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.row == n && node.col == m) {
                min = node.cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = node.row + directions[i][0];
                int nextCol = node.col + directions[i][1];

                if (nextRow > n || nextRow <= 0 || nextCol > m || nextCol <= 0) {
                    continue;
                }

                int wall = matrix[nextRow][nextCol];
                if (wall == 0 && !isVisited[node.canBreak][nextRow][nextCol]) {
                    isVisited[node.canBreak][nextRow][nextCol] = true;
                    queue.add(new Node(nextRow, nextCol, node.cnt + 1, node.canBreak));
                }
                else if(wall == 1 && node.canBreak == 1 && !isVisited[1][nextRow][nextCol]){
                    isVisited[node.canBreak][nextRow][nextCol] = true;
                    queue.add(new Node(nextRow, nextCol, node.cnt + 1, 0));
                }
            }
        }

        return min;
    }
}