## ❔ 문제
### ✅ 설명
현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.

각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.

단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.

### ✅ 입력
첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.

### ✅ 출력
첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.

#### 예시 입력 1
```
6
50 2
20 1
40 2
60 3
30 3
30 1
```

#### 예시 출력 1
```
150
```

<br>

## ✍🏻 스스로 풀기

### 💡 돈 혹은 디데이로 정렬하고 기간 내의 돈 더하기 ❌

계속 구현해왔던 방식대로 한번 정렬하고 반복문을 돌면서 조건에 맞는 것을 더하려고 했는데 그렇게 단순하게 구현하기에는 걸리는 조건이 많았다.

첫번째로, `디데이, 돈 순서`로 정렬하여 구현할 때는 디데이가 우선적으로 정렬되기 때문에 디데이가 늦지만 보수가 훨씬 많은 강연을 할 수 없어서 최댓값을 구할 수 없었다.
```
1 30
1 20
2 50
2 40
3 60
3 30
```

두번째로, `돈, 디데이 순서`로 정렬하여 구현할 때는 돈이 우선적으로 정렬되긴 하지만 만약 시일이 널널한 강연이 보수도 높다면 해당 강연부터 하게되기 때문에 보수가 좋고 디데이가 적은 일을 아쉽게 못하게 될 수 있다.
```
3 60
2 50
2 40
3 30
1 30
1 20
```
위에서는 d-day가 2인 상위 2개를 먼저 하고, 3일인 것을 했으면 보수가 최대가 되었을 텐데 보수를 우선으로 정렬하다 보니 최댓값을 구하지 못했다.

하지만 그렇다고 보수와 디데이를 어떻게 점수를 매겨서 합산 점수로 정렬하기도 어렵다.

그래서 처음 반복문을 돌며 가장 큰 d-day를 구하고, 그 일자 내의 것들만 추출해서 다시 일자 순으로 정렬할까 고민해봤는데 효율적이지 못한 것 같다.

<br>

### 💡 강의 참고: 할 수 있는 강의를 우선순위 큐에 저장

사실 문제 제목에 우선순위 큐 응용이라고 써있는 걸 봤을 때 이게 왜 우선순위 큐가 필요한건지 이해하지 못했다.

하지만 강의의 아이디어를 알고난 후 지속적인 sorting이 필요하기 때문에 우선순위 큐가 필요하다는 것을 알게 되었다.


강의에서의 아이디어는

1. d-day의 최댓값을 찾는다.
2. d-day의 마지막 날부터 어떤 강연을 할 것인지 결정해 나간다. => 이때 각 날마다 할 수 있는 강연을 우선순위 큐에 넣고, 최댓값을 뽑는다.

이 아이디어가 참 좋다고 생각한게, 내가 생각한 방법으로 시일이 빠른 것부터 한다면 시일이 늦은 강연 중에 더 보수가 좋은 것을 놓칠 가능성을 배제할 수 없다.
하지만 마지막 날이 되면 d-day가 마지막 날인 강연만 할 수 있기 때문에 다른 날의 강연은 신경쓰지 않아도 된다.

그리고 우선순위 큐를 사용하여 해당 d-day의 보수들을 차례로 넣고 그게 누적되면, 그 전날의 강연을 정할 때도 d-day가 오늘까지가 아닌 것까지 고려해서 스케줄링 할 수 있다.

오늘 할 수 있는 것 중에(d-day가 오늘까지든 아니든) 가장 보수가 좋은 것을 고르니까 Greedy 알고리즘인 것이다.

그리고 우선순위 큐를 사용하여 삽입 시마다 정렬해서 할 수 있는 강연 중 가장 높은 보수를 받는 것을 탐색하지 않고도 알 수 있다.

우선순위 큐에서 poll할 때 isEmpty 여부를 체크해야 하는데, 만약 empty라면 그 날 수행할 수 있는 강연이 없다는 것이기에 그냥 넘어가면 된다. 처음에 max d-day가 10이라면 10개를 골라야 
한다고 착각해서 계속 null pointer exception이 발생하였다.

<br>

## 📖 강의자료 코드

``` java
import java.util.*;
class Lecture implements Comparable<Lecture>{
    public int money;
	public int time;
    Lecture(int money, int time) {
        this.money = money;
        this.time = time;
    }
    @Override
    public int compareTo(Lecture ob){
        return ob.time-this.time;
    }
}

class Main {
	static int n, max=Integer.MIN_VALUE;
	public int solution(ArrayList<Lecture> arr){
		int answer=0;
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		Collections.sort(arr);
		int j=0;
		for(int i=max; i>=1; i--){
			for(; j<n; j++){
				if(arr.get(j).time<i) break;
				pQ.offer(arr.get(j).money);
			}
			if(!pQ.isEmpty()) answer+=pQ.poll();
		}
		return answer;
	}

	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		n=kb.nextInt();
		ArrayList<Lecture> arr = new ArrayList<>();
		for(int i=0; i<n; i++){
			int m=kb.nextInt();
			int d=kb.nextInt();
			arr.add(new Lecture(m, d));
			if(d>max) max=d;
		}
		System.out.println(T.solution(arr));
	}
}
```

<br>

## ✔️ 오답 노트
이번 문제는 생각할 것이 많았던 문제인 것 같다. 그냥 값을 담은 리스트를 정렬만 해서는 안되고, 따로 우선순위 큐를 만들어서 해당 날짜에 가능한 모든 강연들을 넣고, 
그 중에서 최대 보수를 고르는 아이디어가 참 좋은 것 같다.

매번 따로 정렬해주지 않아도 삽입 시 자동으로 정렬되는 우선순위 큐를 활용하기 참 좋은 문제인 것 같다.

그리고고 오늘 할 수 있는 강연이라는 부분 문제에서 최적의 해를 찾아내는 것이니 그리디 문제라고 확실하게 말할 수 있는 것 같다.
