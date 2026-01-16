import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(in.readLine());
        List<Integer> lionIds = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                lionIds.add(i);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= lionIds.size() - k; i++) {
            min = Math.min(min, lionIds.get(i + k - 1) - lionIds.get(i)  + 1);
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
