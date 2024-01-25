import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Integer> solution(int n, int k, int[] incomes) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> types = new HashMap<>();

        // 미리 틀을 만들어놓고
        for (int i = 0; i < k - 1; i++) {
            types.put(incomes[i], types.getOrDefault(incomes[i], 0) + 1);
        }

        // 하나 넣고, 하나 빼면서 해쉬맵의 크기를 구한다. -> two pointers, sliding window
        for (int rt = k - 1, lt = 0; rt < n; rt++) {
            types.put(incomes[rt], types.getOrDefault(incomes[rt], 0) + 1);
            answer.add(types.size());

            int key = incomes[lt++];
            types.put(key, types.get(key) - 1);
            if (types.get(key) == 0) {
                types.remove(key);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] incomes = new int[n];

        for (int i = 0; i < n; i++) {
            incomes[i] = in.nextInt();
        }

        for (int count : T.solution(n, k, incomes)) {
            System.out.print(count + " ");
        }
    }
}
