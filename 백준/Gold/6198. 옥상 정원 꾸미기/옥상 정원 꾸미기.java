import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * [ 풀이 도출 과정 ]
 * - 한 건물에 대해 n번씩 비교하며 확인하면 해결 가능하지만, n <= 8만으로 n^2이 1억 번을 넘어 완전 탐색은 불가능
 * - 정답 도출에 필요한 값 = 현재 건물을 볼 수 있는 건물의 수의 누적
 * - 나중에 들어온 값이 먼저 나가는 stack을 사용하여, 높은 건물 높이가 쌓이도록 구현
 *
 * [ 오답 노트 ]
 * - 왜 이 풀이를 생각해내지 못했을까?
 *   => 문제가 요구하는 최소한의 상태를 생각해내지 못함 (왼쪽에서 현재 건물을 볼 수 있는 건물 수)
 * - 내가 세려는 건 건물 쌍이 아니라 i 건물에 대해 왼쪽에서 i를 볼 수 있는 건물의 수다.
 * - i보다 낮거나 같은 높이의 건물은 i를 볼 수 없다.
 *   => 따라서 이전의 건물 중 현재 건물보다 낮거나 같은 건물을 제거한다.
 *   => 내림차순 유지
 *   => 만약 현재 저장된 모든 값보다 높은 값이 등장하면 이전의 건물들은 해당 건물 이후를 보지 못한다.
 * - 현재 높이보다 작거나 같은 높이의 건물을 모두 제거하면 현재 건물을 볼 수 있는 건물만 남는다.
 *   => 경우의 수에 stack의 size를 더한다.
 * - stack을 쓰는 이유
 *   - 새 건물의 높이가 들어왔을 때, 그 건물 때문에 쓸모없어지는 건물이 항상 가장 최근에 들어온 것부터 발생한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(in.readLine());
        }

        long result = count(n, heights);
        System.out.println(result);
    }

    private static long count(int n, int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();

        long cnt = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= heights[i]) {
                stack.pop();
            }

            cnt += stack.size();
            stack.push(heights[i]);
        }

        return cnt;
    }
}