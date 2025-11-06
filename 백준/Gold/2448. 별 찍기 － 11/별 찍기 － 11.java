import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static char[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int w = n * 2 - 1;
        result = new char[n][w];
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], ' ');
        }

        draw(0, w / 2, n);  // 꼭짓점 r, c, 높이

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w; j++) {
                out.write(result[i][j]);
            }
            out.write("\n");
        }

        out.flush();
    }

    private static void draw(int r, int c, int h) {
        if (h == 3) {
            result[r][c] = '*';
            result[r + 1][c - 1] = '*';
            result[r + 1][c + 1] = '*';
            for (int i = -2; i <= 2; i++) {
                result[r + 2][c + i] = '*';
            }
            return;
        }

        draw(r, c, h / 2);
        draw(r + h / 2, c - h / 2, h / 2);
        draw(r + h / 2, c + h / 2, h / 2);
    }
}