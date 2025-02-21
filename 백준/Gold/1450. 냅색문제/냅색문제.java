import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static int C;
    static int[] weights;
    static List<Integer> rightSubSums = new ArrayList<>();
    static List<Integer> leftSubSums = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 입력
        N = in.nextInt();
        C = in.nextInt();
        weights = new int[N];

        for (int i = 0; i < N; i++) {
            weights[i] = in.nextInt();
        }

        // 반으로 나눠 각각의 부분집합 합의 경우의 수를 구하기
        int mid = N / 2;
        calcSubsetSums(0, mid, 0, rightSubSums);
        calcSubsetSums(mid, N, 0, leftSubSums);

        // 오른쪽 부분집합 합 정렬 (이분탐색을 위해)
        Collections.sort(rightSubSums);

        int count = 0;
        for (int sum : leftSubSums) {
            count += upperBound(C - sum, rightSubSums);
        }

        System.out.println(count);
    }

    private static void calcSubsetSums(int start, int end, int sum, List<Integer> subsetSums) {
        if(sum > C) return;

        if (start == end) {
            subsetSums.add(sum);
            return;
        }

        // 현재 원소 포함 / 미포함
        calcSubsetSums(start + 1, end, sum + weights[start], subsetSums);
        calcSubsetSums(start + 1, end, sum, subsetSums);
    }

    // 이분 탐색으로 주어진 list에서 key 이하 원소의 개수 반환
    private static int upperBound(int key, List<Integer> sortedList) {
        int start = 0;
        int end = sortedList.size();

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (sortedList.get(mid) <= key) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}