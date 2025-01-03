import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<List<Integer>> graph;
    private static int[] states;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int i = 0; i < testCases; i++) {
            graph = new ArrayList<>();

            int vCnt = in.nextInt();
            int eCnt = in.nextInt();

            for (int j = 0; j <= vCnt; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < eCnt; j++) {
                int v = in.nextInt();
                int e = in.nextInt();

                graph.get(v).add(e);
                graph.get(e).add(v);
            }

            boolean isBipartiteGraph = true;
            states = new int[vCnt + 1];   // 미방문: -1 / 상태1: 0 / 상태2: 1
            Arrays.fill(states, -1);

            for (int j = 1; j <= vCnt; j++) {
                if (states[j] == -1) {
                    if (!checkComponentBipartite(j, 0)) {
                        isBipartiteGraph = false;
                        break;
                    }
                }
            }

            String result = isBipartiteGraph ? "YES" : "NO";
            System.out.println(result);
        }
    }

    private static boolean checkComponentBipartite(int current, int state) {
        states[current] = state;

        for (int neighbor : graph.get(current)) {
            if (states[neighbor] == -1) {
                if (!checkComponentBipartite(neighbor, 1 - state)) {
                    return false;
                }
            } else if (states[neighbor] == state) {
                return false;
            }
        }

        return true;
    }
}