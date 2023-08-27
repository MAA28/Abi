class ReverseString {
	public static void main(String[] args) {
		assert args.length == 1: "Args must contain 1 element";
		for (int i = 1; i <= args[0].length(); i++) {
			System.out.print(args[0].charAt(args[0].length() - i));
		}
		System.out.println();
	}
}
