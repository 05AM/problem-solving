import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> outDegree = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        int createdVertex = -1;
        int donutCount = 0;
        int barCount = 0;
        int eightCount = 0;

        // 간선 정보를 통해 각 정점의 진출 차수와 진입 차수를 계산
        for (int[] edge : edges) {
            outDegree.put(edge[0], outDegree.getOrDefault(edge[0], 0) + 1);
            inDegree.put(edge[1], inDegree.getOrDefault(edge[1], 0) + 1);
        }

        // 그래프 순회
        for (int node : outDegree.keySet()) {
            int out = outDegree.get(node);
            int in = inDegree.getOrDefault(node, 0);

            // 생성된 정점은 진입 차수가 0이고 진출 차수가 2 이상
            if (in == 0 && out >= 2) {
                createdVertex = node;
            }
            // 8자 모양 그래프의 중앙 정점은 진입 차수와 진출 차수가 각각 2 이상
            else if (in >= 2 && out == 2) {
                eightCount++;
            }
        }

        // 막대 모양 그래프의 끝 정점은 진출 차수가 0이고 진입 차수가 1 이상
        for (int node : inDegree.keySet()) {
            int out = outDegree.getOrDefault(node, 0);
            int in = inDegree.get(node);

            if (out == 0 && in >= 1) {
                barCount++;
            }
        }

        // 전체 그래프의 수는 생성된 정점의 진출 차수와 같음
        int totalGraphs = outDegree.get(createdVertex);
        // 도넛 모양 그래프의 수는 전체 그래프 수에서 막대와 8자 그래프 수를 뺀 값
        donutCount = totalGraphs - barCount - eightCount;

        return new int[]{createdVertex, donutCount, barCount, eightCount};
    }
}
