import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());

        String origin = in.readLine();

        int count = 0;
        int answer = 0;

        for (int i = 0; i < m - 2; ) {
            if (origin.charAt(i) == 'I' && origin.charAt(i + 1) == 'O' && origin.charAt(i + 2) == 'I') {
                count++;

                if (count == n) {
                    answer++;
                    count--;
                }

                i += 2;
            } else {
                count = 0;
                i++;
            }
        }

        System.out.println(answer);
    }
}