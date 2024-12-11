import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> alphabets = List.of(
        "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="
    );

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.next();

        for (String alphabet : alphabets) {
            word = word.replace(alphabet, "*");
        }

        System.out.println(word.length());
    }
}