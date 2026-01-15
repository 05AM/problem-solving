import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * [접근 방식]
 * - 인덱스로 계산할 수 있지만 B 배열이 오름차순 정렬이라 불가능
 * - B 배열을 실제 만들 수 있지만, 복잡도가 O(N^2)이고, N이 10만이라 불가능
 * => B 배열을 실제로 계산하지 않고도, 그 범위를 찾아갈 수 있도록
 *
 * [구현 방식]
 * - 최솟값과 최댓값 사이에서 이분 탐색하며 후보 값 X를 정한다.
 * - A[i][j] = i * j이므로, 배열에서 X보다 작거나 같은 개수는 X / i(행)를 더해서 구할 수 있다.
 * - 개수가 k보다 같거나 크면, 해당 값이 k번째 수일 가능성이 있으므로 result에 넣는다.
 * - 값은 계속 좁혀지므로 마지막에 result에 넣어진 값이 k번째 수이다.
 *
 * [오답 노트]
 * - 100억은 int에 못 담으니 long으로 해야한다.
 * - 범위는 계속 좁혀지기에 result 값 후보는 계속 작아진다. 따라서 min 함수로 최소를 찾을 필요가 없다.
 * - 배열은 개수가 유한하므로, X/i가 n보다 크면 n으로 개수를 조정해야 한다.
 */

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(in.readLine());
        int k = Integer.parseInt(in.readLine());

        long result = solution(n, k);
        System.out.println(result);
    }

    private static long solution(long n, int k) {
        long result = Long.MAX_VALUE;

        long min = 1 * 1;
        long max = n * n;
        long left = min;
        long right = max;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            // 작거나 같은 개수 세기
            long cnt = countLessOrEqual(n, mid);

            if (cnt >= k) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private static long countLessOrEqual(long n, long value) {
        long cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (value < i) {
                break;
            }
            cnt += Math.min(value / i, n);
        }

        return cnt;
    }
}
