import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;

        boolean[] isVisited = new boolean[y + 1];
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{x, 0});
        isVisited[x] = true;

        while(!queue.isEmpty()) {
            Integer[] current = queue.poll();
            int currentX = current[0];
            int trial = current[1];

            if(currentX == y) {
                if (answer == -1) {
                    answer = trial;
                } else {
                    answer = Math.min(answer, trial);

                    if (trial > answer) {
                        break;
                    }
                }
            }

            if(currentX * 3 <= y && !isVisited[currentX * 3]) {
                isVisited[currentX * 3] = true;
                queue.add(new Integer[]{currentX * 3, trial + 1});
            }

            if(currentX * 2 <= y && !isVisited[currentX * 2]) {
                isVisited[currentX * 2] = true;
                queue.add(new Integer[]{currentX * 2, trial + 1});
            }

            if(currentX + n <= y && !isVisited[currentX + n]) {
                isVisited[currentX + n] = true;
                queue.add(new Integer[]{currentX + n, trial + 1});
            }
        }

        return answer;
    }
}