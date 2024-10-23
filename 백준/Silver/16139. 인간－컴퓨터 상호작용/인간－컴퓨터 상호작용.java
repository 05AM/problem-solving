import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int[][] prefixSum;
    static final int ALPHABETS_CNT = 26;
    static final char LOW_A = 'a';

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = in.readLine();
        prefixSum = new int[ALPHABETS_CNT][s.length() + 1];
        solution(s);

        int q = Integer.parseInt(in.readLine());
        for (int i = 0; i < q; i++) {
            String[] input = in.readLine().split(" ");

            char alpha = input[0].charAt(0);
            int l = Integer.parseInt(input[1]);
            int r = Integer.parseInt(input[2]);

            int index = alpha - LOW_A;
            out.write(prefixSum[index][r + 1] - prefixSum[index][l] + "\n");
        }
        out.flush();

        in.close();
        out.close();
    }

    private static void solution(String s) {
        for (int i = 0; i < ALPHABETS_CNT; i++) {
            for (int j = 0; j < s.length(); j++) {
                int sum = s.charAt(j) == (LOW_A + i) ? 1 : 0;
                prefixSum[i][j + 1] = prefixSum[i][j] + sum;
            }
        }
    }
}