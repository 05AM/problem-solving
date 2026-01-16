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

        int left = 0;
        int right = k - 1;
        int min = Integer.MAX_VALUE;

        while (right < lionIds.size()) {
            if (lionIds.size() - left + 1 < k) {
                break;
            }
            
            if (right - left + 1 == k) {
                min = Math.min(min, lionIds.get(right) - lionIds.get(left) + 1);
                left++;
            } else {
                right++;
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
