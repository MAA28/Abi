class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println("Recursive: G(" + n + ") = " + G_recursive(n));
        System.out.println("Iterative: G(" + n + ") = " + G_iterative(n));
    }

    static int G_recursive(int n) {
        return (n == 0 ? 0 : n + G_recursive(n - 1));
    }

    static int G_iterative(int n) {
        int accumulator = 0;

        for (int i = 1; i <= n; i++) 
            accumulator += i;
        
        return accumulator;
    }
}