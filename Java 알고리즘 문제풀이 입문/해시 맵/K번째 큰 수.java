import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private int solution(int n, int k, int[] numbers) {
        int answer = -1;
        Set<Integer> result = new TreeSet<>(Comparator.reverseOrder());

      // 3중첩 반복문으로 3개의 무작위 수의 합의 모든 결과를 구한다.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    result.add(numbers[i] + numbers[j] + numbers[l]);
                }
            }
        }

      // 메소드를 사용하는 것보다 for 문을 사용하는게 효율적인 경우가 많음
        int cnt = 1;
        for (int number : result) {
            if (cnt == k) {
                answer = number;
            }
            cnt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }

        System.out.println(T.solution(n, k, numbers));
    }
}
