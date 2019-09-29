class TekstAnalyse{

	public TekstAnalyse(String lagraTekst){
		for(int nr = 0; nr<lagraTekst.length(); nr++){
			char character = Character.toLowerCase(lagraTekst.charAt(nr));
			int charValue = character;
			if(charValue >= 97 && charValue <= 122){
				charValue = convertCharValue(character);
			}else if(character == 'æ'){
				charValue = 26;
			}else if(character == 'ø'){
				charValue = 27;
			}else if(character == 'å'){
				charValue = 28;
			}else{
				charValue = 29;
			}
			charAmmount[charValue] ++;
		}
		Object[] options = {"1. Different letters", "2. Total ammount of letters", "3. Percentage of non-letter characters",
			"4. Choose a letter to find the ammount of", "5. What character is repeated the most"};
		int chosenOption = showOptionDialog(null, "Choose what to find in the text:", "Menu", 0, 3, null, options, options[0]);
		checkMenuChoice(chosenOption);
	}
}