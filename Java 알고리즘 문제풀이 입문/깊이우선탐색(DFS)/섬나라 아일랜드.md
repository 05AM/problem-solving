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
                    map[i][j] = 0;

                    dfs(new Coor(j, i));
                }
            }
        }

        return cnt;
    }

    private static void dfs(Coor now) {
        for (int[] movement : movements) {
            Coor next = now.copy();
            next.move(movement);

            if (next.isInMap() && map[next.y][next.x] == 1) {
                map[next.y][next.x] = 0;
                dfs(next);
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

DFS로 풀었을 때 처음에 세운 전략은 

1. 지도를 완전탐색하며 섬(1)인 곳을 찾는다.
2. 1을 찾으면 섬 개수에 +1을 하고, 해당 지역을 갔다는 뜻으로 0으로 바꾸고, 반복문을 돌며 상하좌우, 대각선으로 이동한다.
   2-1. 이동했을 때 여전히 지도 안에 있고, 해당 지역도 섬(1)인 경우 DFS 함수를 호출한다.
   2-2. 더이상 근접한 1이 없어 함수 호출이 종료될 때까지 2번을 반복한다.

<br>

## 📖 강의자료 코드

``` java
import java.util.*;
class Main {
	static int answer=0, n;
	static int[] dx={-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy={0, 1, 1, 1, 0, -1, -1, -1};
	public void DFS(int x, int y, int[][] board){
		for(int i=0; i<8; i++){
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==1){
				board[nx][ny]=0;
				DFS(nx, ny, board);
			}
		}	
	}
	public void solution(int[][] board){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(board[i][j]==1){
					answer++;
					board[i][j]=0;
					DFS(i, j, board);
				}
			}
		}	
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		n=kb.nextInt();
		int[][] arr=new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				arr[i][j]=kb.nextInt();
			}
		}
		T.solution(arr);
		System.out.println(answer);
	}
}
```

<br>

## ✔️ 오답 노트

명확한 시작점이 없어서 헷갈린 문제였던 것 같다. 사실 이 문제를 DFS, BFS로 둘 다 풀 수 있다고 알고 있었는데, BFS는 금방 떠올랐지만, DFS는 방법이 금방 떠오르지 않았다.


그래서 정리하자면, DFS는 섬을 하나 찾으면 근방에 연결된 섬을 깊이 우선으로 탐색해나가서 섬인 부분을 다 지워버리는 것 같다고 생각했다.

BFS와 다른 점은 BFS는 동시다발적으로 퍼져나가며 지운다면, DFS는 깊게 쭉쭉 나가면서 이어나간다는 인상을 받았다.
