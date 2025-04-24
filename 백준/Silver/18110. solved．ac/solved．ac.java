import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(arr);

        int cut = (int) Math.round(n * 0.15);
        long sum = 0;
        for (int i = cut; i < n - cut; i++) {
            sum += arr[i];
        }

        System.out.println(Math.round((double) sum / (n - 2 * cut)));
    }
}
