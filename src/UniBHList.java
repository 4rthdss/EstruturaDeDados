public class UniBHList<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int totalElements;

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
        if (firstNode == null) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            lastNode.setNext(newNode);
            lastNode = newNode;
        }
        totalElements++;
    }

    public Node<T> removeAtBeginning() {
        if (firstNode == null) throw new IllegalStateException(
            "A lista está vazia"
        );
        Node<T> aux = firstNode;
        firstNode = firstNode.getNext();
        if (firstNode == null) {
            lastNode = null;
        }
        totalElements--;
        return aux;
    }

    public Node<T> removeAtEnding() {
        if (firstNode == null) throw new IllegalStateException(
            "A lista está vazia"
        );

        Node<T> aux = lastNode;

        if (firstNode == lastNode) {
            firstNode = null;
            lastNode = null;
        } else {
            Node<T> current = firstNode;
            while (current.getNext() != lastNode) {
                current = current.getNext();
            }
            current.setNext(null);
            lastNode = current;
        }
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
        while (currentNode != null) {
            builder.append(currentNode.getValue());
            if (currentNode.getNext() != null) {
                builder.append(", ");
            }
            currentNode = currentNode.getNext();
        }
        builder.append("]");
        return builder.toString();
    }

    public Node<T> search(T value) {
        Node<T> current = firstNode;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return current;
            }
            current = current.getNext();
        }
        throw new IllegalArgumentException("Elemento não encontrado na lista");
    }

    public void removeByValue(T value) {
        if (isEmpty()) throw new IllegalStateException("A lista está vazia");

        if (firstNode.getValue().equals(value)) {
            removeAtBeginning();
            return;
        }

        Node<T> current = firstNode;
        Node<T> previous = null;

        while (current != null && !current.getValue().equals(value)) {
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            throw new IllegalArgumentException(
                "Elemento não encontrado para remoção"
            );
        }

        previous.setNext(current.getNext());

        if (current == lastNode) {
            lastNode = previous;
        }

        totalElements--;
    }

    public boolean isEmpty() {
        return totalElements == 0;
    }

    public void insertAfter(int index, T value) {
        if (index < 0 || index >= totalElements) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        Node<T> current = firstNode;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        Node<T> newNode = new Node<>(value);
        newNode.setNext(current.getNext());
        current.setNext(newNode);

        if (current == lastNode) {
            lastNode = newNode;
        }

        totalElements++;
    }

    public void removeAtIndex(int index) {
        if (index < 0 || index >= totalElements) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        if (index == 0) {
            removeAtBeginning();
            return;
        }

        Node<T> previous = firstNode;
        for (int i = 0; i < index - 1; i++) {
            previous = previous.getNext();
        }

        Node<T> current = previous.getNext();
        previous.setNext(current.getNext());

        if (current == lastNode) {
            lastNode = previous;
        }

        totalElements--;
    }

    public int size() {
        return totalElements;
    }

    public void modifyValue(T oldValue, T newValue) {
        Node<T> node = search(oldValue);
        node.setValue(newValue);
    }
}
