import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        UniBHList<Integer> myList = new UniBHList<>();

        for (int i = 0; i < 10; i++) {
            myList.insertAtBeginning(i + 1);
            System.out.println(myList);
        }

        System.out.println(myList);

        for (int i = 0; i < 10; i++) {
            myList.insertAtEnding(i + 1);
            System.out.println(myList);
        }

        myList.removeAtBeginning();
        myList.removeAtEnding();
        System.out.println(myList);

        try {
            int i = myList.find(3);
            System.out.println("--------" + i);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println();
    }
}
