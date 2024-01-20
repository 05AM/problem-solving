import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Integer> solution(int n, int m, int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2]) {
                answer.add(arr1[p1++]);
            } else {
                answer.add(arr2[p2++]);
            }
        }

        // while 문은 반복문과 조건문의 역할을 동시에 하는 경우가 있다.
        while (p1 < n) {
            answer.add(arr1[p1++]);
        }

        while (p2 < m) {
            answer.add(arr2[p2++]);
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
