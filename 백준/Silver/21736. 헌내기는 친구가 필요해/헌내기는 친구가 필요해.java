import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] moveX = { 0, 0, 1, -1 };
    static int[] moveY = { 1, -1, 0, 0 };

    static boolean[][] isVisited;
    static String[][] campus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        isVisited = new boolean[n][m];
        campus = new String[n][m];

        // 입력 받으며 현재 위치 찾기
        int currentRow = 0;
        int currentCol = 0;

        for (int i = 0; i < n; i++) {
            campus[i] = br.readLine().split("");

            for (int j = 0; j < m; j++) {
                if (campus[i][j].equals("I")) {
                    currentRow = i;
                    currentCol = j;
                }
            }
        }

        int result = solution(n, m, currentRow, currentCol);
        System.out.println(result != 0 ? result : "TT");
    }

    private static int solution(int n, int m, int startRow, int startCol) {
        int answer = 0;

        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[] {startRow, startCol});
        isVisited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            Integer[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            switch (campus[currentRow][currentCol]) {
                case "X": continue;
                case "P": answer++;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = current[0] + moveX[i];
                int nextCol = current[1] + moveY[i];

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && !isVisited[nextRow][nextCol]) {
                    queue.add(new Integer[] {nextRow, nextCol});
                    isVisited[nextRow][nextCol] = true;
                }
            }
        }

        return answer;
    }
}
