import java.util.Scanner;

public class Main {

    static final int MAX_LECTURE_SIZE = 10000;
    static final int MAX_LECTURE_CNT = 100000;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int min = Integer.MIN_VALUE;
        int[] lectures = new int[n];
        for (int i = 0; i < n; i++) {
            lectures[i] = in.nextInt();
            min = Math.max(min, lectures[i]);
        }

        int answer = solution(min, m, lectures);
        System.out.println(answer);
    }

    private static int solution(int min, int m, int[] lectures) {
        int max = MAX_LECTURE_SIZE * MAX_LECTURE_CNT;

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
        cnt--;
        int curr = size;

        for (int lecture : lectures) {
            if (curr < lecture) {
                if (cnt == 0) {
                    return false;
                }
                cnt--;
                curr = size;
            }
            curr -= lecture;
        }
        return true;
    }
}