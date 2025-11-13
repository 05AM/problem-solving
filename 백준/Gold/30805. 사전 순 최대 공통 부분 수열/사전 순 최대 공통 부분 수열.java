import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int n, m;
    private static int[] sequence1, sequence2;
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        sequence1 = Arrays.stream(in.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        m = Integer.parseInt(in.readLine());
        sequence2 = Arrays.stream(in.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        solution();
    }

    private static void solution() {
        // 주어진 수열에서 가장 큰 공통 원소를 찾는 것을 반복
        // 한쪽이 남은 개수가 0이 되면 끝
        int cnt = 0;
        int[] fromIdx = new int[] {0, 0};

        while (fromIdx != null && (fromIdx[0] < n && fromIdx[1] < m)) {
            fromIdx = findBigCommonElementIdxs(fromIdx[0], fromIdx[1]);
            if (fromIdx != null) {
                result.append(sequence1[fromIdx[0] - 1]).append(" ");
                cnt++;
            }
        }

        System.out.println(cnt);
        System.out.println(result);
    }

    private static int[] findBigCommonElementIdxs(int idx1, int idx2) {
        // idx1 ~ n / idx2 ~ m 안에서 가장 큰 공통 원소 찾기
        int max = Integer.MIN_VALUE;
        int newIdx1 = idx1;
        int newIdx2 = idx2;

        for (int i = idx1; i < n; i++) {
            for (int j = idx2; j < m; j++) {
                if (sequence1[i] == sequence2[j]) {
                    if (sequence1[i] > max) {
                        max = sequence1[i];
                        newIdx1 = i;
                        newIdx2 = j;
                    }
                }
            }
        }

        if (max != Integer.MIN_VALUE) {
            return new int[] {newIdx1 + 1, newIdx2 + 1};
        }

        return null;
    }
}