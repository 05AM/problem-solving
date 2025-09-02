import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) parent[pb] = pa;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        st = new StringTokenizer(in.readLine());
        int k = Integer.parseInt(st.nextToken());
        Set<Integer> truth = new HashSet<>();
        for (int i = 0; i < k; i++) truth.add(Integer.parseInt(st.nextToken()));

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            List<Integer> members = new ArrayList<>();
            for (int j = 0; j < cnt; j++) members.add(Integer.parseInt(st.nextToken()));
            for (int j = 1; j < members.size(); j++) union(members.get(0), members.get(j));
            parties.add(members);
        }

        Set<Integer> truthRoots = new HashSet<>();
        for (int x : truth) truthRoots.add(find(x));

        int answer = 0;
        for (List<Integer> party : parties) {
            boolean possible = true;
            for (int member : party) {
                if (truthRoots.contains(find(member))) {
                    possible = false;
                    break;
                }
            }
            if (possible) answer++;
        }

        System.out.println(answer);
    }
}
