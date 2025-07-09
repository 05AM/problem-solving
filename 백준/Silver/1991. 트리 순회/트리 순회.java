import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Tree tree;
    static StringBuilder result = new StringBuilder();

    static class Node {
        String parent;
        String left;
        String right;

        public Node(String parent, String left, String right) {
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    static class Tree {
        String root;
        Map<String, Node> nodes;

        public Tree(String root, Map<String, Node> nodes) {
            this.root = root;
            this.nodes = nodes;
        }

        Node getNode(String name) {
            return nodes.get(name);
        }

        Node getRoot() {
            return nodes.get(root);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Map<String, Node> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String parent = in.next();
            String left = in.next();
            String right = in.next();

            Node node = new Node(parent, left, right);
            nodes.put(parent, node);
        }

        tree = new Tree("A", nodes);

        // 전위순회
        preorder(tree.getRoot());
        result.append("\n");

        // 중위순회
        inorder(tree.getRoot());
        result.append("\n");

        // 후위순회
        postorder(tree.getRoot());

        System.out.println(result);
    }

    private static void preorder(Node node) {
        if (node == null) {
            return;
        }

        result.append(node.parent);
        preorder(tree.getNode(node.left));
        preorder(tree.getNode(node.right));
    }

    private static void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(tree.getNode(node.left));
        result.append((node.parent));
        inorder(tree.getNode(node.right));
    }

    private static void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(tree.getNode(node.left));
        postorder(tree.getNode(node.right));
        result.append(node.parent);
    }
}