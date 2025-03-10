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

    public Node<T> find(int index) throws Exception {
        Node<T> current = firstNode;
        for (int i = 0; i <= totalElements; i++) {
            if (index == i) {
                return current;
            } else {
                current = current.getNext();
            }
        }
        throw new Exception("Item não encontrado");
    }

    public void add(int index, T value) throws Exception {
        if (index < 0 || index > totalElements) {
            throw new Exception("Esse indice não existe");
        }
        Node<T> node = new Node<T>(value);
        node.setNext(this.find(index + 1));
        find(index).setNext(node);
        totalElements++;
    }

    public void removeAt(int index) throws Exception {
        if (index < 0 || index >= totalElements) {
            throw new Exception("Índice inválido");
        }

        if (index == 0) {
            removeAtBeginning();
            return;
        }

        Node<T> current = firstNode;
        Node<T> previous = null;

        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.getNext();
        }

        previous.setNext(current.getNext());

        if (current.getNext() == null) {
            lastNode = previous;
        }
        totalElements--;
    }

    public boolean isEmpty() {
        return totalElements == 0;
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
