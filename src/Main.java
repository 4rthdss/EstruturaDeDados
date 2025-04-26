public class Main {

    public static void main(String[] args) {
        UniBHList<Integer> myList = new UniBHList<>();

        System.out.println("empty list " + myList.isEmpty());

        myList.insertAtBeginning(3);
        myList.insertAtBeginning(2);
        myList.insertAtBeginning(1);
        System.out.println("insert at beginning: " + myList);

        myList.insertAtEnding(4);
        myList.insertAtEnding(5);
        System.out.println("insert at ending: " + myList);

        try {
            Node<Integer> node = myList.search(3);
            System.out.println("find element: " + node.getValue());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            myList.search(10);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            myList.removeByValue(2);
            System.out.println("remove value: " + myList);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            myList.removeByValue(100);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            myList.insertAfter(2, 99);
            System.out.println("insert 99 on index 2: " + myList);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            myList.removeAtIndex(3);
            System.out.println("after remove index 3: " + myList);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            myList.modifyValue(1, 88);
            System.out.println("after change index 1: " + myList);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("list size: " + myList.size());
    }
}
