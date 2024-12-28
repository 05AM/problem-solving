import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(in.readLine());
            solution(n);
            System.out.println(cnt);
        }
    }

    private static void solution(int n) {
        cnt = 0;
        dfs(n);
    }

    private static void dfs(int n) {
        if (n == 0) {
            cnt++;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (n < i) {
                break;
            } else {
                dfs(n - i);
            }
        }
    }
}