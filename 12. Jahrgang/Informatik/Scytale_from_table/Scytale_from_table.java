import java.lang.Math;
class Scytale{
	public static void main (String[]args){
		assert args.length == 2 || args.length == 3: "Must have 2 or 3 inputs";


		// String klartext="zurwinterszeitalseinmaleintieferschneelagmussteeinarmerjungehinausgehenundholzaufeinemschlittenholenwieeresnunzusammengesuchtundaufgeladenhattewollteerweilersoerfrorenwarnochnichtnachhausgehensondernerstfeueranmachenundsicheinbisschenwaermendascharrteerdenschneewegundwieersodenerdbodenaufraeumtefandereinenkleinengoldenenschluesselnunglaubteerwoderschluesselwaeremuessteauchdasschlossdazuseingrubindererdeundfandeineiserneskaestchenwennderschluesselnurpasstdachteeressindgewisskostbaresachenindemkaestchenersuchteabereswarkeinschluessellochdaendlichentdeckteereinsabersokleindassmaneskaumsehenkonnteerprobierteundderschluesselpasstegluecklichdadrehteereinmalherumundnunmuessenwirwartenbiservollendsaufgeschlossenunddendeckelaufgemachthatdannwerdenwirerfahrenwasfuerwunderbaresachenindemkaestchenlagen";
		// klartext = "treffezorraambrunnen";
		// klartext = "infomachtspass";
		// klartext = "abcdefghi";
		// klartext = "beispielklartext";
		
		String klartext	= args[0];


		int n = Integer.parseInt(args[1]);
		

		String out = "";
		if(Integer.parseInt(args[2]) == 0) {
			out = encrypt(klartext, n);

		} else if(Integer.parseInt(args[2]) == 1) {
			out = decrypt(klartext, n);
		}

		System.out.println(out);
		
	} 

	public static String decrypt(String text, int n) {
		String result = text;
		for (int i = 0; i < n; i++) {
			result = encrypt(result, n);	
			System.out.println(result);

		}
		return result;
	}

	public static String encrypt(String klartext, int n) {
		int k = Math.ceilDiv(klartext.length(), n);
		//int n = klartext.length() / k;
		String verschlusseled = "";	

		char[][] matrix = new char[n][k];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				int index = i * k + j;
				if(index >= klartext.length()) continue;
				System.out.println(index + ": (" + i + "|" + j + ") --> " + klartext.charAt(index));
				matrix[i][j] = klartext.charAt(index);
			}
		}
		
		System.out.println();

		for (int j = 0; j < k; j++) {
			for (int i = 0; i < n; i++) {
				System.out.println(verschlusseled.length() + " <-- (" + i + "|" + j + ")");
				verschlusseled += matrix[i][j];
			}
		}



		return verschlusseled;
	}
}
