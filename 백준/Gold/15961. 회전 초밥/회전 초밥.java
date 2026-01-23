import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * - k개를 연속으로, 그 중 가짓수의 최댓값 => 투포인터
 * - 일반적인 투포인터 문제와의 차이점
 *   - 포인터가 원형 큐로 회전
 *   -
 */

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());   // 초밥 접시 수
        int d = Integer.parseInt(st.nextToken());   // 초밥 가짓 수
        int k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰 번호

        int[] sushis = new int[n];
        for (int i = 0; i < n; i++) {
            sushis[i] = Integer.parseInt(in.readLine());
        }

        int result = solution(n, d, k, c, sushis);
        System.out.println(result);
    }

    private static int solution(int n, int d, int k, int c, int[] sushis) {
        int max = Integer.MIN_VALUE;

        int[] cnt = new int[d + 1];
        int kind = 0;
        int total = 0;

        for (int left = 0, right = 0; left < n; left++) {
            // 포함 개수가 k개가 될 때까지 cnt와 kind를 업데이트
            while (total < k) {
                if (cnt[sushis[right]] == 0) {
                    kind++;
                }

                cnt[sushis[right]]++;
                total++;
                right = (right + 1) % n;
            }

            // 최댓값 갱신
            int currMax = cnt[c] > 0 ? kind : kind + 1;
            max = Math.max(max, currMax);

            if (cnt[sushis[left]] == 1) {
                kind--;
            }

            cnt[sushis[left]]--;
            total--;
        }

        return max;
    }
}