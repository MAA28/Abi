import java.lang.Math;

class Main {
    public static void main(String[] args) {
        long n = Integer.parseInt(args[0]);
        long k = Integer.parseInt(args[1]);

        long nCr = nCr(n,k);

        long spaces = 1 + (long) Math.max(Math.log10(n), Math.log10(k));

        System.out.println("╭" + (" ".repeat((int) spaces + 2)) + "╮");
        System.out.println("│ " + String.format("%" + spaces + "d", n) + " │");
        System.out.println("│" + (" ".repeat((int) spaces + 2)) + "│ = " + nCr);
        System.out.println("│ " + String.format("%" + spaces + "d", k) + " │");
        System.out.println("╰" + (" ".repeat((int) spaces + 2)) + "╯");
        
    }

    static long nCr(long n, long k) {
        if (k > n) return 0;
        return n == k || k == 0 ? 1 : nCr(n - 1, k - 1) + nCr(n - 1, k);
    }
}