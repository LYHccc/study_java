import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random(20200705);
        AVLTree tree = new AVLTree();

        int count = 0;
        for(int i = 0; i < 1000; i++){
            int num = random.nextInt(10000);
            try {
                tree.insert(num);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            count++;
        }

        tree.checkout();
    }
}
