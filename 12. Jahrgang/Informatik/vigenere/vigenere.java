class vigenere {
	public static void main(String[] args) {
		String text = args[0];
		String keys = args[1];
		String ciphered = "";	
		for (int i = 0; i < text.length(); i++) {
			char key = keys.charAt(i % keys.length());
			char currentChar = text.charAt(i);

			char ciphered_char = (char) (((int) (key + currentChar) - 97 * 2) % 26 + 97);

			ciphered += ciphered_char;
		}
		System.out.println(ciphered);
	}
}
