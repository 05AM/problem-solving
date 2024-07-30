import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {

    static int answer = 0;
    static int n, m;
    static List<Integer> cards;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        cards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cards.add(in.nextInt());
        }

        solution();

        System.out.println(answer);
    }

    private static void solution() {
        Collections.sort(cards);
        dfsForSorted(0, 0, 0);
    }

    private static void dfsForSorted(int cnt, int sum, int start) {
        if (cnt == 3) {
            if (sum <= m) {
                answer = Math.max(answer, sum);
            }
        } else {
            for (int i = start; i < n; i++) {
                if (m < sum + cards.get(i)) {
                    break;
                }
                dfsForSorted(cnt + 1, sum + cards.get(i), i + 1);
            }
        }
    }
}