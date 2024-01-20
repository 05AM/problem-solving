import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private ArrayList<Integer> solution(int n, int m, int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1 = 0, p2 = 0;

        // 두 배열 중 어떤 배열이라도 다 돌면 더 이상 공통 원소가 있을 수 없다.
        while (p1 < n && p2 < m) {
            if (arr1[p1] == arr2[p2]) {
                answer.add(arr1[p1]);
                p1++;
                p2++;
            } else if (arr1[p1] < arr2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = in.nextInt();
        }

        for (int num : T.solution(n, m, arr1, arr2)) {
            System.out.print(num + " ");
        }
    }
}
