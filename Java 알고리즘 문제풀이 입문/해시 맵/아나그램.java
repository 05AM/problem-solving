import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private String solution(String s1, String s2) {
        boolean flag = true;

        HashMap<Character, Integer> composition = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            composition.merge(ch, 1, Integer::sum);
        }

        // s2의 알파벳을 s1의 구성요소 hashmap 에서 하나씩 감소시켜 간다는 아이디어
        for (char key : s2.toCharArray()) {
            if (!composition.containsKey(key) || composition.get(key) == 0) {
                flag = false;
                break;
            }
            composition.put(key, composition.get(key) - 1);
        }
        return flag ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();

        System.out.println(T.solution(s1, s2));
    }
}
