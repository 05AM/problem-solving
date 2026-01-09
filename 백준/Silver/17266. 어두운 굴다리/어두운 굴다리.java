import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());   // 굴다리 개수
        int m = Integer.parseInt(in.readLine());   // 가로등 개수

        int[] lights = new int[m];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < m; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        int answer = solution(n, lights);
        System.out.println(answer);
    }

    private static int solution(int n, int[] lights) {
        int left = Math.max(lights[0], n - lights[lights.length - 1]);
        int right = n;
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isAvailable(n, mid, lights)) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private static boolean isAvailable(int n, int height, int[] lights) {
        if (lights[0] > height) {
            return false;
        }

        if (n - lights[lights.length - 1] > height) {
            return false;
        }

        for (int i = 1; i < lights.length; i++) {
            if (lights[i] - lights[i - 1] > height * 2) {
                return false;
            }
        }
        return true;
    }
}