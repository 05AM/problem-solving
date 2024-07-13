## ❔ 문제
### ✅ 설명

N×N 크기의 도시지도가 있습니다. 도시지도는 1×1크기의 격자칸으로 이루어져 있습니다.

각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다. 각 격자칸은 좌표(행번호, 열 번호)로 표현됩니다.

행번호는 1번부터 N번까지이고, 열 번호도 1부터 N까지입니다.

도시에는 각 집마다 “피자배달거리”가 았는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는

피자집들과의 거리 중 최소값을 해당 집의 “피자배달거리”라고 한다.

집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.

예를 들어, 도시의 지도가 아래와 같다면

![image](https://github.com/user-attachments/assets/1e0e8c2e-831c-462e-af6e-345b3d6aff1c)

(1, 2)에 있는 집과 (2, 3)에 있는 피자집과의 피자 배달 거리는 |1-2| + |2-3| = 2가 된다.

최근 도시가 불경기에 접어들어 우후죽순 생겼던 피자집들이 파산하고 있습니다.

도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.

시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.

도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.

#### 요약

- **피자 배달거리** : 해당 집과 도시의 존재하는 피자집들과의 거리 중 최소값 (|x1 - x2| + |y1 - y2|)
- **도시의 피자 배달거리** : 각 집들의 피자 배달 거리를 합한 것

도시의 피자 배달거리를 최소하하는 m개의 피자집을 선택

### ✅ 입력

첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 12)이 주어진다.

둘째 줄부터 도시 정보가 입력된다.

### ✅ 출력

첫째 줄에 M개의 피자집이 선택되었을 때 도시의 최소 피자배달거리를 출력한다.

#### 예시 입력 1
```
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2
```

#### 예시 출력 1
```
6
```

<br>

## ✍🏻 스스로 풀기

### 💡 DFS + 순열로 경우의 수 구하기
``` java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] distances;
    static boolean[] visited;
    static int[] selected;
    static List<Position> stores = new ArrayList<>();
    static List<Position> houses = new ArrayList<>();

    static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static int calculateCityMinDeliverDistance() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    houses.add(new Position(i, j));
                } else if (map[i][j] == 2) {
                    stores.add(new Position(i, j));
                }
            }
        }

        visited = new boolean[stores.size()];
        distances = new int[stores.size()][houses.size()];

        for (int i = 0; i < stores.size(); i++) {
            for (int j = 0; j < houses.size(); j++) {
                distances[i][j] = calculateDistance(stores.get(i), houses.get(j));
            }
        }

        dfs(0);

        return answer;
    }

    private static int calculateDistance(Position store, Position house) {
        return Math.abs(store.row - house.row) + Math.abs(store.col - house.col);
    }

    private static void dfs(int level) {
        if (level >= m) {
            int sum = 0;

            for (int houseNo = 0; houseNo < houses.size(); houseNo++) {
                int min = Integer.MAX_VALUE;

                for (int storeNo : selected) {
                    min = Math.min(min, distances[storeNo][houseNo]);
                }

                sum += min;
            }

            answer = Math.min(answer, sum);
        } else {
            for (int i = 0; i < stores.size(); i++) {
                if (!visited[i]) {
                    selected[level] = i;
                    visited[i] = true;

                    dfs(level + 1);

                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        map = new int[n][n];
        selected = new int[m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                map[row][col] = in.nextInt();
            }
        }

        System.out.println(calculateCityMinDeliverDistance());
    }
}
```

이 문제를 풀기 전에 세웠던 전략은 다음과 같다.

1. 각 집과 피자집 간의 최소 거리를 계산한다.
2. m개의 피자집을 선택하는 경우의 수를 각각 dfs 탐색한다.
3. 결과가 현재 최소보다 작은 경우 값을 갱신한다.

위의 계획대로 구현하긴 했는데 시간 초과로 몇몇의 테스트 케이스를 통과하지 못했다.

아무래도 가게와 집을 찾으면서 1번, 거리를 계산하면서 1번 완전 탐색을 하고, 모든 경우의 수를 조합해서 하다보니 그런 것 같다.

경우의 수를 따지는 것을 순열이 아니라 조합으로 바꿔야겠다.

<br>

### 💡 DFS + 조합으로 경우의 수 구하기
``` java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] distances;
    static boolean[] visited;
    static int[] selected;
    static List<Position> stores = new ArrayList<>();
    static List<Position> houses = new ArrayList<>();

    static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static int calculateCityMinDeliverDistance() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    houses.add(new Position(i, j));
                } else if (map[i][j] == 2) {
                    stores.add(new Position(i, j));
                }
            }
        }

        visited = new boolean[stores.size()];
        distances = new int[stores.size()][houses.size()];

        for (int i = 0; i < stores.size(); i++) {
            for (int j = 0; j < houses.size(); j++) {
                distances[i][j] = calculateDistance(stores.get(i), houses.get(j));
            }
        }

        dfs(0, 0);

        return answer;
    }

    private static int calculateDistance(Position store, Position house) {
        return Math.abs(store.row - house.row) + Math.abs(store.col - house.col);
    }

    private static void dfs(int level, int start) {
        if (level >= m) {
            int sum = 0;

            for (int houseNo = 0; houseNo < houses.size(); houseNo++) {
                int min = Integer.MAX_VALUE;

                for (int storeNo : selected) {
                    min = Math.min(min, distances[storeNo][houseNo]);
                }

                sum += min;
            }

            answer = Math.min(answer, sum);
        } else {
            for (int i = start; i < stores.size(); i++) {
                if (!visited[i]) {
                    selected[level] = i;
                    visited[i] = true;

                    dfs(level + 1, i + 1);

                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        map = new int[n][n];
        selected = new int[m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                map[row][col] = in.nextInt();
            }
        }

        System.out.println(calculateCityMinDeliverDistance());
    }
}
```

이번 코드는 조합으로 경우의 수를 구하는 방식으로 구현했다.

경우의 수에 순서가 들어가지 않으니 중복이 줄어들어 최솟값을 구하는데 시행하는 횟수가 더 적어졌다.

방법은 dfs 내부의 반복문을 돌릴 때 start 인덱스를 다음 dfs 호출에 넘겨주어서 해당 시작 인덱스 이후부터 피자 가게를 선택하게 하는 것이다.

<br>

## 📖 강의자료 코드

``` java
import java.util.*;
class Point{
	public int x, y;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
}
class Main {
	static int n, m, len, answer=Integer.MAX_VALUE;
	static int[] combi;
	static ArrayList<Point> hs, pz;
	public void DFS(int L, int s){
		if(L==m){
			int sum=0;
			for(Point h : hs){
				int dis=Integer.MAX_VALUE;
				for(int i : combi){
					dis=Math.min(dis, Math.abs(h.x-pz.get(i).x)+Math.abs(h.y-pz.get(i).y));
				}
				sum+=dis;
			}
			answer=Math.min(answer, sum);
		}
		else{
			for(int i=s; i<len; i++){
				combi[L]=i;
				DFS(L+1, i+1);
			}
		}
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		n=kb.nextInt();
		m=kb.nextInt();
		pz=new ArrayList<>();
		hs=new ArrayList<>();
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				int tmp=kb.nextInt();
				if(tmp==1) hs.add(new Point(i, j));
				else if(tmp==2) pz.add(new Point(i, j));
			}
		}
		len=pz.size();
		combi=new int[m];
		T.DFS(0, 0);
		System.out.println(answer);
	}
}
```

<br>

## ✔️ 오답 노트

다음부터는 순서가 필요한 경우의 수가 아니라면 무조건 조합으로 구하기 위해 노력해야겠다.
