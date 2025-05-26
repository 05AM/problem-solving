import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int n = Integer.parseInt(in.readLine());
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            graph[i] = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int stop = 0; stop < n; stop++) {              // 경유지
            for (int start = 0; start < n; start++) {       // 출발지
                for (int end = 0; end < n; end++) {         // 도착지
                    if (graph[start][stop] == 1 && graph[stop][end] == 1) {
                        graph[start][end] = 1;
                    }
                }
            }
        }
        
        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.write(graph[i][j] + " ");
            }
            out.write("\n");
        }

        out.flush();
    }
}