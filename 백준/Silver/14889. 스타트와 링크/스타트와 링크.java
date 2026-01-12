import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static boolean[] isSelected;
    static int[][] abilities;
    static int n, total;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        total = 0;
        isSelected = new boolean[n + 1];
        abilities = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String[] input = in.readLine().split(" ");

            for (int j = 1; j <= n; j++) {
                abilities[i][j] = Integer.parseInt(input[j - 1]);
                total += abilities[i][j];
            }
        }

        solution(0, 1);
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
            for (int j = i; j <= n; j++) {
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