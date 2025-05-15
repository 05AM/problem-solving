import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int b = Integer.parseInt(firstLine[2]);

        int[] heightCount = new int[257];
        int minH = 256;
        int maxH = 0;

        // 최소 / 최대 높이를 구해서 범위 좁히기
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int h = Integer.parseInt(line[j]);
                
                heightCount[h]++;
                minH = Math.min(minH, h);
                maxH = Math.max(maxH, h);
            }
        }

        int bestTime = Integer.MAX_VALUE;
        int bestHeight = -1;

        for (int base = minH; base <= maxH; base++) {
            int time = 0;
            int inventory = b;

            for (int h = 0; h <= 256; h++) {
                int count = heightCount[h];
                if (count == 0) continue;

                int diff = h - base;
                if (diff > 0) {
                    time += diff * 2 * count;
                    inventory += diff * count;
                } else if (diff < 0) {
                    time += -diff * count;
                    inventory -= -diff * count;
                }
            }

            if (inventory < 0) continue;

            if (time < bestTime || (time == bestTime && base > bestHeight)) {
                bestTime = time;
                bestHeight = base;
            }
        }

        System.out.println(bestTime + " " + bestHeight);
    }
}
