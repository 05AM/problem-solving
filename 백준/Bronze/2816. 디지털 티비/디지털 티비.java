import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int ch1 = -1;
        int ch2 = -1;

        for (int i = 0; i < n; i++) {
            String channel = in.readLine();

            if (channel.equals("KBS1")) {
                ch1 = i;
            }

            if (channel.equals("KBS2")) {
                ch2 = i;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("1".repeat(ch1));
        result.append("4".repeat(ch1));

        // KBS1이 더 위에 있으면
        if (ch1 < ch2) {
            result.append("1".repeat(ch2));
            result.append("4".repeat(ch2 - 1));
        } else {
            result.append("1".repeat(ch2 + 1));
            result.append("4".repeat(ch2));
        }

        System.out.println(result);
    }
}
