import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private String solution(int n, String[] votes) {
        HashMap<String, Integer> result = new HashMap<>();

        for (String vote : votes) {
            result.merge(vote, 1, Integer::sum);
        }

        return Collections.max(result.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String[] votes = in.next().split("");

        System.out.println(T.solution(n, votes));
    }
}
