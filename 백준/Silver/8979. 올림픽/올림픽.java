import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Nation implements Comparable<Nation> {
        int code;
        int gold;
        int silver;
        int bronze;

        public Nation(int code, int gold, int silver, int bronze) {
            this.code = code;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Nation o) {
            if (this.gold != o.gold) {
                return this.gold - o.gold;
            }

            if (this.silver != o.silver) {
                return this.silver - o.silver;
            }

            if (this.bronze != o.bronze) {
                return this.bronze - o.bronze;
            }

            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Nation[] nations = new Nation[n];
        Nation target = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            int code = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            nations[i] = new Nation(code, gold, silver, bronze);

            if (code == k) {
                target = nations[i];
            }
        }

        // 나보다 잘한 국가 개수 + 1이므로 한 번만 반복하면 됨
        int betters = 0;
        for (Nation nation : nations) {
            if (nation.code == k) {
                continue;
            }

            if (target.compareTo(nation) < 0) {
                betters++;
            }
        }

        System.out.println(betters + 1);
    }
}
