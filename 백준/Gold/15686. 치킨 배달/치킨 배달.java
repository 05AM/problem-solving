import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
    static int[][] map;
    static Coord[] selected;
    static List<Coord> restaurants = new ArrayList<>();
    static List<Coord> houses = new ArrayList<>();

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        selected = new Coord[m];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // 치킨집, 집의 위치 구하기
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] == 1) {
                    houses.add(new Coord(r, c));
                } else if (map[r][c] == 2) {
                    restaurants.add(new Coord(r, c));
                }
            }
        }

        findMinChickenDistance(0, 0);

        System.out.println(min);
    }

    private static void findMinChickenDistance(int selectIdx, int startIdx) {
        if (selectIdx == m) {
            int distance = calculateChickenDist();
            min = Math.min(min, distance);
        } else {
            for (int i = startIdx; i < restaurants.size(); i++) {
                if (restaurants.size() - startIdx < m - selectIdx) {
                    break;
                }

                selected[selectIdx] = restaurants.get(i);
                findMinChickenDistance(selectIdx + 1, i + 1);
            }
        }
    }

    private static int calculateChickenDist() {
        int chickenDist = 0;

        for (Coord house : houses) {
            int min = Integer.MAX_VALUE;

            for (Coord restaurant : selected) {
                min = Math.min(min, calculateDist(house, restaurant));
            }

            chickenDist += min;
        }

        return chickenDist;
    }

    private static int calculateDist(Coord coord1, Coord coord2) {
        return Math.abs(coord1.row - coord2.row) + Math.abs(coord1.col - coord2.col);
    }
}
