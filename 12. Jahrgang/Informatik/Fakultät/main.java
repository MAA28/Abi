class Main {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(n + "! = " + fak(n));
        System.out.println(Integer.MAX_INT);
    }
    public static int fak(int n) {
        return (n <= 2 ? n : n * fak(n - 1));
    }
}
