import java.util.Scanner;

public class Main {
    private int solution(int n, int[] heights) {
        int cnt = 1;
        int currentMax = heights[0];

        for (int i = 1; i < n; i++) {
            if (heights[i] > currentMax) {
                cnt++;
                currentMax = heights[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = in.nextInt();
        }

        System.out.println(T.solution(n, heights));
    }
}
