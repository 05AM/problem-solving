import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    private static final int MAX_RANGE = 100000;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        int answer = solution(n, k);
        System.out.println(answer);
    }

    private static int solution(int n, int k) {
        if (n >= k) {
            return n - k;
        }

        boolean[] isVisited = new boolean[MAX_RANGE + 1];
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[] {n, 0});
        isVisited[n] = true;

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int currentLocation = current[0];
            int currentTime = current[1];

            if (currentLocation == k) {
                return currentTime;
            }

            if (currentLocation * 2 <= MAX_RANGE && !isVisited[currentLocation * 2]) {
                isVisited[currentLocation * 2] = true;
                deque.addFirst(new int[] {currentLocation * 2, currentTime});
            }

            if (currentLocation - 1 >= 0 && !isVisited[currentLocation - 1]) {
                isVisited[currentLocation - 1] = true;
                deque.addLast(new int[] {currentLocation - 1, currentTime + 1});
            }
            
            if (currentLocation + 1 <= MAX_RANGE && !isVisited[currentLocation + 1]) {
                isVisited[currentLocation + 1] = true;
                deque.addLast(new int[] {currentLocation + 1, currentTime + 1});
            }
        }

        return -1;
    }
}
