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
    private static final int MAX_RANGE = 1000000;

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
        for (int ngf : result) {
            out.write(ngf + BLANK);
        }
        out.flush();
    }

    private static int[] solution(int n, int[] arr) {
        // 각 원소의 등장 횟수 카운트
        int[] counts = new int[MAX_RANGE + 1];
        for (int i = 0; i < n; i++) {
            counts[arr[i]]++;
        }

        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];

            while (!stack.isEmpty()) {
                int currentNGF = stack.peek();

                if (current != currentNGF && counts[current] < counts[currentNGF]) {
                    break;
                } else {
                    stack.pop();
                }
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(current);
        }

        return result;
    }
}