import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        // 합치고 정렬된 배열 구하기
        int[] result = new int[n + m];

        int p1 = 0;
        int p2 = 0;
        int idx = 0;
        while (true) {
            if (p1 == n && p2 == m) {
                break;
            } else if (p1 == n) {
                result[idx++] = b[p2++];
                continue;
            } else if (p2 == m) {
                result[idx++] = a[p1++];
                continue;
            }

            if (a[p1] <= b[p2]) {
                result[idx++] = a[p1++];
            } else if (a[p1] > b[p2]) {
                result[idx++] = b[p2++];
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n + m; i++) {
            answer.append(result[i]).append(" ");
        }

        System.out.println(answer);
    }
}
