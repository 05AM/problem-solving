## ❔ 문제
### ✅ 설명

N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.

각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.

섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.

![image](https://github.com/user-attachments/assets/eaa8c8f5-184c-41a3-b591-040490062307)

만약 위와 같다면 섬의 개수는 5개입니다.

### ✅ 입력

첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.

두 번째 줄부터 격자판 정보가 주어진다.

### ✅ 출력

첫 번째 줄에 섬의 개수를 출력한다.

#### 예시 입력 1
```
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0
```

#### 예시 출력 1
```
5
```

<br>

## ✍🏻 스스로 풀기

### 💡 DFS로 풀기

``` java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static int n;
    static int[][] map;
    static int[][] movements = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    static class Coor {
        int x;
        int y;

        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void move(int[] movement) {
            this.x += movement[0];
            this.y += movement[1];
        }

        Coor copy() {
            return new Coor(this.x, this.y);
        }

        boolean isInMap() {
            return (x >= 0 && x < n) && (y >= 0 && y < n);
        }
    }

    private static int findIslandCnt() {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    cnt++;
                    bfs(new Coor(j, i));
                }
            }
        }

        return cnt;
    }

    private static void bfs(Coor start) {
        Queue<Coor> queue = new LinkedList<>();
        queue.add(start);
        map[start.y][start.x] = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Coor now = queue.poll();

                for (int[] movement : movements) {
                    Coor next = now.copy();
                    next.move(movement);

                    if (next.isInMap() && map[next.y][next.x] == 1) {
                        map[next.y][next.x] = 0;
                        queue.offer(next);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        map = new int[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                map[row][col] = in.nextInt();
            }
        }

        System.out.println(findIslandCnt());
    }
}
```

BFS로 풀었을 때 처음에 세운 전략은 

1. 반복문을 돌면서 섬(1)인 곳을 찾는다. => 섬 개수 + 1
2. 해당 부분의 상하좌우 대각성을 탐색하며 섬(1)인 부분을 찾고 해당 부분을 0으로 변경한 후 큐에 넣는다.
3. 이어진 부분이 없을 때까지 2번을 반복한다.
4. 모든 이어진 부분 탐색 후 다시 첫번째 반복문을 돌며 1인 곳을 찾아 2, 3번을 반복한다.


<br>

## 📖 강의자료 코드

``` java

```

<br>

## ✔️ 오답 노트

DFS로 풀었을 때와 마찬가지로 명확한 시작점이 없어서 헷갈린 문제였던 것 같다.

DFS와 BFS 개념은 다르지만 둘 다 갈 수 있는 경로를 지워버리면서 하는 것이 비슷한 것 같다.

어느 것이 더 효율적인지 고민해봤는데, 아무래도 BFS가 효율적이지 않을까 싶다. 왜냐하면 1인 부분을 만나 다음 노드를 넣고 재방문 가능성을 지워버리는 것은 같지만, 
DFS는 다시 재귀로 돌아와야하기 때문에 조금 더 오래 걸리지 않을까 싶다.
