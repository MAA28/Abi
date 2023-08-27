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

		System.out.println("\"" + out + "\"");
		
	} 

	public static String decrypt(String text, int n) {
		String result = text;
		for (int i = 0; i < n; i++) {
			result = encrypt(result, n);	
		}
		return result;
	}

	public static String encrypt(String klartext, int n) {
		int k = klartext.length() / n;
		//int n = klartext.length() / k;
		System.out.println(klartext.length());
		while(k * n != klartext.length()) {
			klartext += " ";
			k= klartext.length() / n;
			System.out.println("Adding a space");
		}
		System.out.println("(" + klartext + ")" + klartext.length());
		
		String verschlusseled = "";	
		
		System.out.println("Seiten: " + k + "	Spullen: " + n);
		System.out.println(klartext);
		for (int i = 0; i < klartext.length(); i++) {
			int index = (i % k) * n + i / k;
			if(index >= klartext.length()) continue;
			System.out.println(index + "(" + klartext.charAt(index) +  ") --> " + i);
			verschlusseled += klartext.charAt(index);
		}
		return verschlusseled;
	}
}
