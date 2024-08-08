import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        Set<String> origin = new HashSet<>();
        for (int i = 0; i < n; i++) {
            origin.add(in.next());
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            if (origin.contains(in.next())) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}