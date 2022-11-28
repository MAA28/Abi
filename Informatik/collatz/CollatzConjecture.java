public class CollatzConjecture {
    public static void main(String args[]) {
        int n = -1;
        do {
            System.out.println(n);
            n = collatz(n);
        } while (n != 1);
    }
    
    public static int collatz(int n) {
        if (n % 2 == 0)
            return n / 2;
        else 
            return 3 * n + 1;
    }
} 