// Класс для представления узла дерева
class Node {
    int data;
    Node left, right;
    boolean isRed; // Цвет узла (true - красный, false - черный)

    public Node(int data) {
        this.data = data;
        this.isRed = true; // Новые узлы всегда красные
    }
}
