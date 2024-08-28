import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();

        solution(word);
    }

    private static void solution(String word) {
        IntStream.range(97, 123)
                .forEach(num -> System.out.print(word.indexOf(num) + " "));
    }
}
