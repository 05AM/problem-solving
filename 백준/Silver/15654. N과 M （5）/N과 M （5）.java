import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int n;
    private static int m;
    private static int[] nums;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        solution(n, nums);
    }

    private static void solution(int n, int[] nums) {
        // 오름차순 정렬
        Arrays.sort(nums);

        // 현재 단계에서 선택되지 않은 수 선택
        boolean[] visited = new boolean[n];

        // 수열의 크기가 m이 될때까지 재귀적으로 반복
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            visited[i] = true;

            recursion(i, 0, "", visited);
        }
    }

    private static void recursion(int i, int size, String result, boolean[] visited) {
        result += nums[i] + " ";
        size++;

        if (size == m) {
            System.out.println(result);
            return;
        }

        for (int next = 0; next < n; next++) {
            if (!visited[next]) {
                visited[next] = true;
                recursion(next, size, result, visited);
                visited[next] = false;
            }
        }
    }
}