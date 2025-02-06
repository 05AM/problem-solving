import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Edge {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

class Path {
    int id;
    int distance;

    public Path(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = in.readLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        int start = Integer.parseInt(in.readLine());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            input = in.readLine().split(" ");

            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            graph.get(from).add(new Edge(to, w));
        }

        solution(start, graph);
    }

    private static void solution(int start, List<List<Edge>> graph) {
        int[] distances = new int[graph.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(path -> path.distance));
        pq.offer(new Path(start, 0));

        while (!pq.isEmpty()) {
            Path path = pq.poll();

            if (path.distance > distances[path.id]) {
                continue;
            }

            for (Edge edge : graph.get(path.id)) {
                int newDistance = path.distance + edge.weight;

                if (newDistance < distances[edge.to]) {
                    distances[edge.to] = newDistance;
                    pq.offer(new Path(edge.to, newDistance));
                }
            }
        }

        for (int i = 1; i < distances.length; i++) {
            System.out.println(distances[i] != Integer.MAX_VALUE ? distances[i] : "INF");
        }
    }
}