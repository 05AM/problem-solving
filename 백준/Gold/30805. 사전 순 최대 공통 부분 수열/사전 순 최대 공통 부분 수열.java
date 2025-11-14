import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int maxValue = -1;

        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());

        int[] sequence1 = new int[n];
        for (int i = 0; i < n; i++) {
            sequence1[i] = Integer.parseInt(st.nextToken());
            maxValue = Math.max(maxValue, sequence1[i]);
        }

        int m = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());

        int[] sequence2 = new int[m];
        for (int i = 0; i < m; i++) {
            sequence2[i] = Integer.parseInt(st.nextToken());
            maxValue = Math.max(maxValue, sequence2[i]);
        }

        List<Integer> result = new ArrayList<>();
        int startIdx1 = 0;
        int startIdx2 = 0;

        while (maxValue > 0) {
            boolean hasValue1 = false;
            boolean hasValue2 = false;
            int tmpIdx1 = 0;
            int tmpIdx2 = 0;

            for (int i = startIdx1; i < n; i++) {
                if (sequence1[i] == maxValue) {
                    hasValue1 = true;
                    tmpIdx1 = i;
                    break;
                }
            }

            for (int i = startIdx2; i < m; i++) {
                if (sequence2[i] == maxValue) {
                    hasValue2 = true;
                    tmpIdx2 = i;
                    break;
                }
            }

            if (hasValue1 && hasValue2) {
                result.add(maxValue);
                startIdx1 = tmpIdx1 + 1;
                startIdx2 = tmpIdx2 + 1;
                
                continue;
            }
            
            maxValue--;
        }

        System.out.println(result.size());
        System.out.println(
            result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
        );
    }
}