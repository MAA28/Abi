class haeufigtkeit{
	public static void main (String[]args){
		String klartext="zurwinterszeitalseinmaleintieferschneelagmussteeinarmerjungehinausgehenundholzaufeinemschlittenholenwieeresnunzusammengesuchtundaufgeladenhattewollteerweilersoerfrorenwarnochnichtnachhausgehensondernerstfeueranmachenundsicheinbisschenwaermendascharrteerdenschneewegundwieersodenerdbodenaufraeumtefandereinenkleinengoldenenschluesselnunglaubteerwoderschluesselwaeremuessteauchdasschlossdazuseingrubindererdeundfandeineiserneskaestchenwennderschluesselnurpasstdachteeressindgewisskostbaresachenindemkaestchenersuchteabereswarkeinschluessellochdaendlichentdeckteereinsabersokleindassmaneskaumsehenkonnteerprobierteundderschluesselpasstegluecklichdadrehteereinmalherumundnunmuessenwirwartenbiservollendsaufgeschlossenunddendeckelaufgemachthatdannwerdenwirerfahrenwasfuerwunderbaresachenindemkaestchenlagen";
	int[] haeufigkeiten=new int[26];
	for (int i = 0; i < haeufigkeiten.length; i++) {
		haeufigkeiten[i] = 0;
		
	}


	for (int i = 0; i < klartext.length(); i++) {
		char currentChar = klartext.charAt(i);
		int index = currentChar - "a".charAt(0);
		haeufigkeiten[index]++;
	}
	
	for(int i = 0; i < haeufigkeiten.length; i++)  {
		char currentChar = (char) ((int) ("a".charAt(0)) + i);
		System.out.println(currentChar + " makes up " + (haeufigkeiten[i] / (float) klartext.length()) + "% of the text and occured " + haeufigkeiten[i] + " times.");
	}

	} 
}
