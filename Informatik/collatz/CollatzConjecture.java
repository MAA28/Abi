public class CollatzConjecture {
    public static void main(String args[]) {
        int n = i;
        System.out.println("Collatz for " + i);
        do {
            System.out.println(n);
            n = collatz(n);
        } while (n != 1);
            System.out.println("-------");
        }
        
    }
    
    public static int collatz(int n) {
        if (n % 2 == 0)
            return n / 2;
        else 
            return 3 * n + 1;
    }
} 