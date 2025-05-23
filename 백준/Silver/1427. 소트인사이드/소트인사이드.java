import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.next();
        input.chars()
            .map(Character::getNumericValue)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .forEach(System.out::print);
    }
}