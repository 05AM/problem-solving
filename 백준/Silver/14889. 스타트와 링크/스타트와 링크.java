import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * - isSelected[1] = true 로 세팅한 이유
 * 그냥 완탐하면 A팀과 B팀을 모두 뽑는 조합이므로 중복 탐색
 * isSelected[1]을 true로 넣고 1번을 포함하는 팀을 A팀이라고 가정하여 대칭 제거
 */

public class Main {

    static boolean[] isSelected;
    static int[][] abilities;
    static int n;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        isSelected = new boolean[n + 1];
        abilities = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            for (int j = 1; j <= n; j++) {
                abilities[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int start = 1;
        isSelected[start] = true;
        solution(1, start + 1);
        System.out.println(minDiff);
    }

    private static void solution(int level, int start) {
        if (level == n / 2) {
            int diff = calculateDiff();
            minDiff = Math.min(minDiff, diff);
        } else {
            for (int i = start; i <= n; i++) {
                isSelected[i] = true;
                solution(level + 1, i + 1);
                isSelected[i] = false;
            }
        }
    }

    private static int calculateDiff() {
        int aSum = 0;
        int bSum = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (isSelected[i] && isSelected[j]) {
                    aSum += abilities[i][j] + abilities[j][i];
                } else if (!isSelected[i] && !isSelected[j]) {
                    bSum += abilities[i][j] + abilities[j][i];
                }
            }
        }
        return Math.abs(aSum - bSum);
    }
}
