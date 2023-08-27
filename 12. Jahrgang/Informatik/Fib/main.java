// Tag  1 =>  1
// Tag  2 =>  1
// Tag  3 =>  2
// Tag  4 =>  3
// Tag  5 =>  5
// Tag  6 =>  8
// Tag  7 => 13
// Tag  8 => 21
// Tag  9 => 34
// Tag 10 => 55



class Main {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int fibonacci = fib(n);
		System.out.println("F(" + n + ") = " + fibonacci);
	}

	public static int fib(int n) {
		return n <= 1 ? n : fib(n - 1) + fib(n - 2);
	}
}