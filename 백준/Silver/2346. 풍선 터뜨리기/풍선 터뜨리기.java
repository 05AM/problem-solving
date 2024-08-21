import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Baloon {

    int number;
    int value;

    Baloon(int number, int value) {
        this.number = number;
        this.value = value;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        Deque<Baloon> deque = new ArrayDeque<>();

        String[] moves = in.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(moves[i - 1]);
            deque.addLast(new Baloon(i, value));
        }

        solution(deque);
    }

    private static void solution(Deque<Baloon> baloons) {
        StringBuilder result = new StringBuilder();

        while (!baloons.isEmpty()) {
            Baloon baloon = baloons.pollFirst();
            result.append(baloon.number).append(" ");

            if (baloons.isEmpty()) {
                break;
            }

            int move = baloon.value;

            if (move > 0) {
                for (int i = 1; i < move; i++) {
                    baloons.addLast(baloons.pollFirst());
                }
            } else if (move < 0) {
                for (int i = 0; i < Math.abs(move); i++) {
                    baloons.addFirst(baloons.pollLast());
                }
            }
        }

        System.out.println(result);
    }
}