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
        result = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], ' ');
        }

        draw(0, 0, n);

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.write(result[i][j]);
            }
            out.write("\n");
        }

        out.flush();

        in.close();
        out.close();
    }

    private static void draw(int r, int c, int h) {
        if (h == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    result[r + i][c + j] = '*';
                }
            }
            return;
        }

        int nextH = h / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }

                draw(r + nextH * i, c + nextH * j, nextH);
            }
        }
    }
}
