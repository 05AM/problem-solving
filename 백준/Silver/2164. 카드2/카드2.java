import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Deque<Integer> cards = new LinkedList<>();

        IntStream.range(1, n + 1)
                .forEach(cards::add);

        solution(cards);
    }

    private static void solution(Deque<Integer> cards) {
        while (cards.size() != 1) {
            cards.pop();
            cards.offer(cards.pop());
        }

        System.out.println(cards.pop());
    }
}
