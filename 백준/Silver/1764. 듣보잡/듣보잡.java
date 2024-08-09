import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        Set<String> notHeard = new TreeSet<>();
        Set<String> notSeen = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            notHeard.add(in.next());
        }

        for (int i = 0; i < m; i++) {
            notSeen.add(in.next());
        }

        if (n > m) {
            solution(notHeard, notSeen);
        } else {
            solution(notSeen, notHeard);
        }
    }

    private static void solution(Set<String> origin, Set<String> compare) {
        List<String> contained = new ArrayList<>();

        for (String str : compare) {
            if (origin.contains(str)) {
                contained.add(str);
            }
        }

        System.out.println(contained.size());
        contained.forEach(System.out::println);
    }
}