/**
 * Create a magic square and print it
 */
public class main {
    /**
     * Create a magic square and print it
     */
    public static void main(String[] args) {
        // A loop that will run until it finds a magic square.
        for(int i = 0; i < 1000000; i++) {
            MagicSquare magicSquare = new MagicSquare();
            magicSquare.fillSquare();
            magicSquare.print();

            if (magicSquare.isMagic()) {
                break;
            }
            System.out.println();
        }
    }
}
