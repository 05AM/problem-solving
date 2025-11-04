import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
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

        List<Nation> nations = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            int nationCode = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            nations.add(new Nation(nationCode, gold, silver, bronze));
        }

        nations.sort(Comparator.reverseOrder());

        // 동등수를 계산하는 방법은 무엇일까?
        int rank = 1;
        if (nations.get(0).code != k) {
            for (int i = 1; i < n; i++) {
                Nation prev = nations.get(i - 1);
                Nation curr = nations.get(i);

                if (prev.compareTo(curr) > 0) {
                    rank = i + 1;
                }

                if (curr.code == k) {
                    break;
                }
            }
        }

        System.out.println(rank);
    }
}
