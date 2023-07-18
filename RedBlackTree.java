
public class RedBlackTree {
    private Node root;

    public void insert(int data) {
        root = insertRec(root, data);
        root.isRed = false; // Корень всегда черный
    }

    private Node insertRec(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = insertRec(current.left, data);
        } else if (data > current.data) {
            current.right = insertRec(current.right, data);
        } else {
            return current;
        }

        if (isRed(current.right) && !isRed(current.left)) {
            current = rotateLeft(current);
        }
        if (isRed(current.left) && isRed(current.left.left)) {
            current = rotateRight(current);
        }
        if (isRed(current.left) && isRed(current.right)) {
            flipColors(current);
        }

        return current;
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.isRed;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.isRed = h.isRed;
        h.isRed = true;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.isRed = h.isRed;
        h.isRed = true;
        return x;
    }

    private void flipColors(Node h) {
        h.isRed = true;
        h.left.isRed = false;
        h.right.isRed = false;
    }

    public boolean contains(int data) {
        return containsRec(root, data);
    }

    private boolean containsRec(Node current, int data) {
        if (current == null) {
            return false;
        }

        if (data == current.data) {
            return true;
        } else if (data < current.data) {
            return containsRec(current.left, data);
        } else {
            return containsRec(current.right, data);
        }
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);

        System.out.println(tree.contains(7));
        System.out.println(tree.contains(20));
    }
}
