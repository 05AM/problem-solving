## ❔ 문제
### ✅ 설명
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

### ✅ 입력
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

### ✅ 출력
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

#### 예시 입력 1
```
8
```

#### 예시 출력 1
```
92
```

<br>

## ✍🏻 스스로 풀기

### 💡 백트래킹 (재귀)
``` java
import java.util.Scanner;

public class Main {
    static int answer = 0;
    static boolean[][] board;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        board = new boolean[n][n];

        solution(0, n);
        System.out.println(answer);
    }

    private static void solution(int row, int n) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n)) {
                board[row][col] = true;
                solution(row + 1, n);
                board[row][col] = false;
            }
        }
    }

    private static boolean isValid(int row, int col, int n) {
        // 같은 열에 퀸이 존재하는지 확인
        for (int i = 0; i < n; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // 오른쪽 대각선에 퀸이 존재하는지 확인
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        // 왼쪽 대각선에 퀸이 존재하는지 확인
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }

        return true;
    }
}
```

<br>

## ✔️ 오답 노트

위 문제는 무작정 모든 경우의 수를 탐색하고 조건에 맞으면 세는 브루트 포스 기법이나, 조건에 맞는 것만 탐색하고 조건에 맞지 않는 경우에는 탐색을 중단하는 백트래킹 기법으로 풀 수 있다.

문제의 풀이방법이 바로 생각나지 않았던 것은 아무래도 내가 너무 복잡하게 생각하고 있는 것 같다.

백트래킹이나까 재귀로 구현해야 된다(사실 재귀는 구현방법 중 하나인데) 혹은 유효성을 판단하는 방법에 대해 말 그대로 어쩔줄을 몰랐던 것 같다.

사실 n이 8까지니까 반복문을 이중으로 돌아도 최대 64번인데 위의 코드처럼 열, 대각선들마다 퀸이 존재하는지 반복문을 돌면서 판단하는 방식이 왠지 모르게 거부감이 들었다.

그래서 보드에 퀸을 놓는 순간 이미 점유된 곳을 표시하려고 했는데, 만약 백트래킹 기법으로 수행하다가 뒤로 돌아가게 되면 어떻게 지워야하나 고민이 되었다.

그래서 생각하는게, 나는 뭔가 이렇게 간단하고 단순하게 반복하는 것에 대해서 부정적으로 생각하고 있는것 같다. 오히려 이게 더 명쾌하고 쉬운데 뇌가 거부해서 문제를 어렵게 풀게되는 경향이 있다.

앞으로는 어차피 컴퓨터가 계산하는거고 나만 단순하게 하면 되지 라는 마인드로 좀 더 쉽게 생각하려고 노력해야겠다.
