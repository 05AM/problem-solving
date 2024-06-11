## ❔ 문제
### ✅ 설명
아래 그림과 같은 이진트리에서 루트 노드 1에서 말단 노드까지의 길이 중 가장 짧은 길이를 구하는 프로그램을 작성하세요.

각 경로의 길이는 루트 노드에서 말단 노드까지 가는데 이동하는 횟수, 즉 간선(에지)의 개수를 길이로 합니다.

![image](https://github.com/05AM/problem-solving/assets/83827023/f2595ea5-541b-4682-9beb-15100047f381)

<br>

## ✍🏻 스스로 풀기

### 💡 Queue를 사용한 BFS
``` java
import java.util.LinkedList;
import java.util.Queue;

class Node {
	int data;
	Node lt, rt;

	public Node(int data) {
		this.data = data;
		this.lt = this.rt = null;
	}
} 

class Main {

	Node root;

	public Main(Node root) {
		this.root = root;
	}

	public int bfs(Node root) {
		int level = 0;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Node node = q.poll();

				if (node.rt == null && node.lt == null) {
					return level;
				}

				if (node.lt != null) {
					q.offer(node.lt);
				}

				if (node.rt != null) {
					q.offer(node.rt);
				}
			}
			level++;
		}

		return level;
	}

	public static void main(String[] args) {
		Main tree = new Main(new Node(1));

		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);

		System.out.println(tree.bfs(tree.root));
	}
}
```

<br>

## 📖 강의자료 코드
``` java
import java.util.*;
class Node{ 
    int data; 
    Node lt, rt; 
    public Node(int val) { 
        data=val; 
        lt=rt=null; 
    } 
} 
  
public class Main{ 
    Node root; 
	public int BFS(Node root){ 
		Queue<Node> Q=new LinkedList<>();
		Q.offer(root);
		int L=0;
		while(!Q.isEmpty()){
			int len=Q.size();
			for(int i=0; i<len; i++){
				Node cur=Q.poll();
				if(cur.lt==null && cur.rt==null) return L;
				if(cur.lt!=null) Q.offer(cur.lt);
				if(cur.rt!=null) Q.offer(cur.rt);
			}
			L++;
		}
		return 0;
    } 
  
    public static void main(String args[]) { 
        Main tree=new Main(); 
        tree.root=new Node(1); 
        tree.root.lt=new Node(2); 
        tree.root.rt=new Node(3); 
        tree.root.lt.lt=new Node(4); 
        tree.root.lt.rt=new Node(5); 
        System.out.println(tree.BFS(tree.root)); 
    } 
} 
```

<br>

## ✔️ 오답 노트

이번에는 구현 방법이 헷갈리기 보다는 BFS의 구현 방법이 헷갈렸던 것 같다.

그래서 한번 구현 방법을 정리해보았다.

1. level과 노드를 넣을 Queue를 선언한다.
2. Queue에 root 노드를 넣는다.
3. Queue가 empty인 경우 종료하는 반복문을 시작한다.
4. Queue의 현재 크기를 변수에 담는다. (이후 추가될 노드는 다른 레벨의 노드이므로 추가로 탐색하지 않기 위해서)
5. 현재 Queue의 모든 노드를 탐색하는 for문을 시작한다.
6. Queue에서 노드를 꺼내고, 출력/값 비교 등 목적을 수행한다.
7. 해당 노드의 lt와 rt가 존재하면 Queue에 넣는다.
8. 현재 레벨의 모든 노드를 탐색하면 for문이 종료되고 레벨이 1 오른다.
9. 4~8의 과정을 QUeue가 빌 때까지 반복한다.
