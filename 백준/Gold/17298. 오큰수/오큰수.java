import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    private static final String BLANK = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 및 수열 초기화
        int n = Integer.parseInt(in.readLine());
        int[] arr = Arrays.stream(in.readLine().split(BLANK))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 결과 출력
        int[] result = solution(n, arr);
        for (int nge : result) {
            out.write(nge + BLANK);
        }
        out.flush();
    }

    private static int[] solution(int n, int[] arr) {
        int[] result = new int[n];
        // 방문한 원소 중 가장 가깝고 큰 값 축적
        Deque<Integer> stack = new ArrayDeque<>();

        // 역순 순회
        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i];

            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num);
        }

        return result;
    }
}