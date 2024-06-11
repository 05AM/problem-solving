## ❔ 문제
### ✅ 설명
아래 그림과 같은 이진트리에서 루트 노드 1에서 말단 노드까지의 길이 중 가장 짧은 길이를 구하는 프로그램을 작성하세요.

각 경로의 길이는 루트 노드에서 말단 노드까지 가는데 이동하는 횟수, 즉 간선(에지)의 개수를 길이로 합니다.

![image](https://github.com/05AM/problem-solving/assets/83827023/f2595ea5-541b-4682-9beb-15100047f381)

<br>

## ✍🏻 스스로 풀기

### 💡 재귀 DFS

``` java
class Node {
	int data;
	Node lt, rt;

	public Node(int data) {
		this.data = data;
	}
}

class Tree {
	private int pathMin = Integer.MAX_VALUE;
	private int path = 0;
	Node root;

	public Tree(Node root) {
		this.root = root;
	}

	public void dfs() {
		dfs(root);
	}

	private void dfs(Node node) {
		if (node == null) {
			if (path < pathMin) {
				pathMin = path;
			}
			return;
		} else {
			path++;
			dfs(node.lt);

			if (node == root) {
				path = 0;
			}

			dfs(node.rt);
		}
	}

	public int getPathMin() {
		return this.pathMin;
	}
}

class Main {
	public static void main(String[] args) {
		Tree tree = new Tree(new Node(1));

		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);

		tree.dfs();
		System.out.println(tree.getPathMin());
	}
}
```

이전에 재귀로 dfs를 구현한 것을 참고해서 이렇게 구현했는데 내가 생각해도 너무 복잡하게 짠 것 같다.

다음부터는 Tree 클래스고 뭐고 최대한 간단하게 짜는 것을 목표로 해야겠다 ㅋㅋ

또한 로직이 직관적이지 못한 것 같다. 강의 자료 코드와 같이 level을 넣는다는 발상을 못해서 인스턴스 변수로 구현했는데 경로의 길이를 언제 초기화할지 고민이 컸던 것 같다.

그래도 한 가지 장점이 있다면 내 코드는 완전 이진 트리가 아니라도 예외가 발생하지 않는다는 것이다!! 😁😁😁

<br>

## 📖 강의자료 코드

``` java
class Node {
	int data;
	Node lt, rt;

	public Node(int data) {
		this.data = data;
	}
}

class Main {

	Node root;

	public Main(Node root) {
		this.root = root;
	}

	public int dfs(int level, Node root) {
		if (root.lt == null && root.rt == null) {
			return level;
		} else {
			return Math.min(dfs(level + 1, root.lt), dfs(level + 1, root.rt));
		}
	}

	public static void main(String[] args) {
		Main tree = new Main(new Node(1));
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);

		System.out.println(tree.dfs(0, tree.root));
	}
}
```

위의 코드는 완전 이진 트리가 아닐 경우 예외가 발생한다.

<br>

## ✔️ 오답 노트

보통 최단 거리를 구할 때는 DFS가 아닌 BFS 알고리즘을 사용한다고 한다. 내가 알기로는 DFS는 모든 가능 경로 찾기, BFS는 최단 경로 찾기로 알고 있어서 일단은 이렇게 정립하면 될 것 같다.

나는 문제를 풀 때 이전의 경험에 갖혀서 생각을 유연하게 하지 못하는 경향이 있는 것 같다. 이전 풀이에 갇힐 것이 아니라 좀 더 유연하게 형을 변환하도록 노력해야겠다.

그리고 코테 문제를 풀 때는 객체지향에 대한 고민을 조금 내려놓아도 될까 고민이 된다.
