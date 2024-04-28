### 💪🏻 스스로 풀기
#### 💡 LinkedList 사용
``` java
private int[] solution(int size, int n, int[] tasks) {
  LinkedList<Integer> cache = new LinkedList<>();

  for (int i = 0; i < n; i++) {
    int idx = cache.indexOf(tasks[i]);

    if (idx != -1) {
      cache.remove(idx);
    }

    if (cache.size() >= size) {
      cache.removeLast();
    }

    cache.addFirst(tasks[i]);
  }

  return cache.stream()
    .mapToInt(Integer::intValue)
    .toArray();
}
```
앞, 뒤로 삽입, 삭제 기능이 필요하기 때문에 `LinkedList`를 사용하여 구현했다.
개인적인 의견으로는 자료구조를 잘 골라서 구현한 것도 능력이라고 생각하지만, 강의에서 구현 능력을 키우기 위해 생으로 구현해보는게 좋다하여 다시 구현해보았다.

<br>

#### 💡 배열로 구현
``` java
private int[] solution(int size, int n, int[] tasks) {
  int[] cache = new int[size];

  for (int task : tasks) {
    int idx = size - 1;

    for (int j = size - 1; j >= 0; j--) {
      if (cache[j] == task) {
        idx = j;
        break;
      }
    }

    for (int k = idx; k > 0; k--) {
      cache[k] = cache[k - 1];
    }

    cache[0] = task;
  }

  return cache;
}
```

<br>

### ✍🏻 오답 노트
[개선사항]
이전 코드에서는 idx의 기본값을 -1로 두고 idx == -1일 경우와 아닌 경우를 나눠서 반복문을 진행했는데,

마지막 인덱스부터 실행하는지 / 중복인 인덱스부터 실행하는지 차이라서 idx와 반복문 인수의 값을 바꾸고 두 분기를 합쳤다.

<br>

### 💡 강의자료 코드
``` java
import java.util.*;
class Main {	
	public int[] solution(int size, int n, int[] arr){
		int[] cache=new int[size];
		for(int x : arr){
			int pos=-1;
			for(int i=0; i<size; i++) if(x==cache[i]) pos=i;
			if(pos==-1){
				for(int i=size-1; i>=1; i--){
					cache[i]=cache[i-1];
				}
			}
			else{
				for(int i=pos; i>=1; i--){
					cache[i]=cache[i-1];
				}
			}
			cache[0]=x;
		}
		return cache;
	}
	public static void main(String[] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int s=kb.nextInt();
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++) arr[i]=kb.nextInt();
		for(int x : T.solution(s, n, arr)) System.out.print(x+" ");
	}
}
```
