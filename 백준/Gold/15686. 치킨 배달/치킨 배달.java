import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[][] dists;
    static int m;
    static int chickenCnt, houseCnt;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(new InputStreamReader(System.in));

        int n = in.nextInt();
        m = in.nextInt();

        int[][] map = new int[n + 1][n + 1];

        List<int[]> chickens = new ArrayList<>();
        List<int[]> houses = new ArrayList<>();

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                map[row][col] = in.nextInt();

                if (map[row][col] == 1) {
                    houses.add(new int[] {row, col});
                } else if (map[row][col] == 2) {
                    chickens.add(new int[] {row, col});
                }
            }
        }

        houseCnt = houses.size();
        chickenCnt = chickens.size();

        // 각 집에서 각 치킨집까지의 거리 구하기
        dists = new int[houseCnt][chickenCnt];

        for (int row = 0; row < houseCnt; row++) {
            int[] house = houses.get(row);
            for (int col = 0; col < chickenCnt; col++) {
                int[] chicken = chickens.get(col);
                dists[row][col] = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
            }
        }

        // 치킨집 chickenCnt개 중에 m개를 골랐을 때 치킨거리 구하고 최솟값 갱신하기
        // dfs로 m개 고르기
        // 도중 min보다 커진다면 그만 두기
        int[] selected = new int[m];
        dfs(0, 0, selected);

        System.out.println(min);
    }

    private static void dfs(int start, int depth, int[] selected) {
        if (depth == m) {
            // 반복문을 돌며 도시의 치킨 거리 구하기
            int cityDist = 0;
            for (int house = 0; house < houseCnt; house++) {
                int best = Integer.MAX_VALUE;

                for (int chicken : selected) {
                    best = Math.min(best, dists[house][chicken]);
                }
                cityDist += best;
            }

            min = Math.min(min, cityDist);
            return;
        }

        for (int i = start; i < chickenCnt; i++) {
            selected[depth] = i;
            dfs(i + 1, depth + 1, selected);
        }
    }
}