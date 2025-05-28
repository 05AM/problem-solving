import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());

        String origin = in.readLine();
        String compare = "IO".repeat(n) + "I";
        int length = compare.length();

        int answer = 0;
        for (int i = 0; i <= m - length; i++) {
            if (origin.charAt(i) == 'I') {
                int l = i;
                int r = i + 1;

                while (r - l < length) {
                    if (origin.charAt(r) != compare.charAt(r - l)) {
                        break;
                    }
                    r++;
                }

                if (r - l == length) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}