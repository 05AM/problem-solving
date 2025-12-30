import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Coord {
        int row;
        int col;

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int n, m;
    static int[][] dist;
    static boolean[] chosen; // 치킨집 선택 여부
    static List<Coord> restaurants = new ArrayList<>();
    static List<Coord> houses = new ArrayList<>();

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < n; c++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    houses.add(new Coord(r, c));
                } else if (value == 2) {
                    restaurants.add(new Coord(r, c));
                }
            }
        }

        chosen = new boolean[restaurants.size()];

        // 각 치킨집과 집 간의 거리 미리 구하기
        dist = new int[houses.size()][restaurants.size()];
        for (int i = 0; i < houses.size(); i++) {
            Coord house = houses.get(i);
            for (int j = 0; j < restaurants.size(); j++) {
                Coord restaurant = restaurants.get(j);
                dist[i][j] = Math.abs(house.row - restaurant.row)
                        + Math.abs(house.col - restaurant.col);
            }
        }

        findMinChickenDistance(0, 0);
        System.out.println(answer);
    }

    private static void findMinChickenDistance(int selectIdx, int startIdx) {
        if (selectIdx == m) {
            answer = Math.min(answer, calculateChickenDist());
            return;
        }

        for (int i = startIdx; i < restaurants.size(); i++) {
            // 남은 개수보다 선택해야 할 개수가 더 많으면,
            if (restaurants.size() - i < m - selectIdx) {
                break;
            }

            chosen[i] = true;
            findMinChickenDistance(selectIdx + 1, i + 1);
            chosen[i] = false;
        }
    }

    private static int calculateChickenDist() {
        int chickenDist = 0;

        for (int houseIdx = 0; houseIdx < houses.size(); houseIdx++) {
            int bestForHouse = Integer.MAX_VALUE;

            for (int chickenIdx = 0; chickenIdx < restaurants.size(); chickenIdx++) {
                if (!chosen[chickenIdx]) continue;
                bestForHouse = Math.min(bestForHouse, dist[houseIdx][chickenIdx]);
            }

            chickenDist += bestForHouse;

            if (chickenDist >= answer) {
                return chickenDist;
            }
        }

        return chickenDist;
    }
}
