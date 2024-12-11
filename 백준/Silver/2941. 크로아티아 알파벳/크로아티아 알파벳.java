import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> alphabets = List.of(
        "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="
    );

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.next();
        int result = 0;

        for (String alphabet : alphabets) {
            while (word.contains(alphabet)) {
                word = word.replaceFirst(alphabet, " ");
                result++;
            }
        }

        result += word.replace(" ", "").length();
        System.out.println(result);
    }
}