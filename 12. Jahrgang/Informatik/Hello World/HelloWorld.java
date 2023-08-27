public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacci(i));
        }
    }

    public static int fibonacci(int n) {
        if (n == 0) return 1;
        else if(n < 0) return 0;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
