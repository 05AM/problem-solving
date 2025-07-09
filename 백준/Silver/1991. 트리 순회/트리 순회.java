import java.util.Scanner;

public class Main {

    static Node[] tree;
    static StringBuilder result = new StringBuilder();

    static class Node {
        char left;
        char right;

        public Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        tree = new Node[26];

        for (int i = 0; i < n; i++) {
            char parent = in.next().charAt(0);
            char left = in.next().charAt(0);
            char right = in.next().charAt(0);

            tree[parent - 'A'] = new Node(left, right);
        }

        // 전위순회
        preorder('A');
        result.append("\n");

        // 중위순회
        inorder('A');
        result.append("\n");

        // 후위순회
        postorder('A');

        System.out.println(result);
    }

    private static void preorder(char c) {
        if (c == '.') {
            return;
        }

        Node node = tree[c - 'A'];

        result.append(c);
        preorder(node.left);
        preorder(node.right);
    }

    private static void inorder(char c) {
        if (c == '.') {
            return;
        }

        Node node = tree[c - 'A'];

        inorder(node.left);
        result.append(c);
        inorder(node.right);
    }

    private static void postorder(char c) {
        if (c == '.') {
            return;
        }

        Node node = tree[c - 'A'];

        postorder(node.left);
        postorder(node.right);
        result.append(c);
    }
}