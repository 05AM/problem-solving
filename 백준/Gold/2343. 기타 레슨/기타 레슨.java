import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int min = Integer.MIN_VALUE;
        int max = 0;
        int[] lectures = new int[n];
        for (int i = 0; i < n; i++) {
            lectures[i] = in.nextInt();
            min = Math.max(min, lectures[i]);
            max += lectures[i];
        }

        int answer = solution(min, max, m, lectures);
        System.out.println(answer);
    }

    private static int solution(int min, int max, int m, int[] lectures) {
        int left = min;
        int right = max;
        int result = left;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isAvailable(mid, m, lectures)) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private static boolean isAvailable(int size, int cnt, int[] lectures) {
        int used = 1;
        int sum = 0;

        for (int lecture : lectures) {
            int rest = size - sum;

            if (lecture > rest) {
                if (used == cnt) {
                    return false;
                }
                used++;
                sum = 0;
            }
            sum += lecture;
        }
        return true;
    }
}
