import java.io.*;
import java.util.*;

public class Main {
    static final int LIMIT = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dist = new int[LIMIT + 1];
        int[] cnt  = new int[LIMIT + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        dist[n] = 0;
        cnt[n] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            int[] nexts = {cur - 1, cur + 1, cur * 2};
            for (int nx : nexts) {
                if (nx < 0 || nx > LIMIT) continue;

                if (dist[nx] == -1) {
                    dist[nx] = dist[cur] + 1;
                    cnt[nx]  = cnt[cur];
                    q.add(nx);
                }
                else if (dist[nx] == dist[cur] + 1) {
                    cnt[nx] += cnt[cur];
                }
            }
        }

        System.out.println(dist[k]);
        System.out.println(cnt[k]);
    }
}
