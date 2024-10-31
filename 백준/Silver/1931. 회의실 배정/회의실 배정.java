import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = in.readLine().split(" ");

            meetings[i][0] = Integer.parseInt(input[0]);
            meetings[i][1] = Integer.parseInt(input[1]);
        }

        System.out.println(solution(meetings));
    }

    private static int solution(int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt((int[] a) -> a[1])
            .thenComparing(a -> a[0]));

        int result = 0;
        long currentEndTime = 0;

        for (int[] meeting : meetings) {
            if (meeting[0] >= currentEndTime) {
                result++;
                currentEndTime = meeting[1];
            }
        }

        return result;
    }
}