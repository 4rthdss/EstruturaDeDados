public class UniBHList<T> {

    // Hold the reference to the first node of this List.
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int totalElements;

    public int find(T value) throws Exception {
        Node<T> current = firstNode;
        for (int i = 0; i <= totalElements; i++) {
            if (current.getValue() == value) {
                return i;
            } else {
                current = current.getNext();
            }
        }
        throw new Exception("Item não encontrado");
    }

    public void insertAtBeginning(T value) {
        Node<T> newNode = new Node<>(value);
        if (firstNode == null) {
            lastNode = newNode;
        } else {
            newNode.setNext(firstNode);
        }
        firstNode = newNode;
        totalElements++;
    }

    public void insertAtEnding(T value) {
        Node<T> newNode = new Node<>(value);
        if (firstNode == null && lastNode == null) {
            firstNode = newNode;
        } else {
            lastNode.setNext(newNode);
        }
        lastNode = newNode;
        totalElements++;
    }

    public Node<T> removeAtBeginning() {
        Node<T> aux = firstNode;
        firstNode = firstNode.getNext();
        totalElements--;
        return aux;
    }

    public Node<T> removeAtEnding() {
        Node<T> aux = lastNode;
        lastNode = lastNode.getNext();
        totalElements--;
        return aux;
    }

    @Override
    public String toString() {
        if (this.totalElements == 0) {
            return "[ ]";
        }
        Node<T> currentNode = firstNode;
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < totalElements; i++) {
            builder.append(currentNode.getValue());
            builder.append(", ");

            currentNode = currentNode.getNext();
        }

        builder.append("]");
        return builder.toString();
    }
    // Design the other list methods.
    //    Insert at the end, in order, remove at the end,
    //    remove elements by value, search an element.
}
