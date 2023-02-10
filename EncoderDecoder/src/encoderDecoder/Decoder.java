package encoderDecoder;

/**
 * A class to encode a string containing only characters found in the reference table.
 * 
 */
public class Decoder extends ReferenceTable {
	public Decoder() {
		// Constructor that also initializes the reference table.
		initializeTable();
	}

	/**
	 * A function to decode the input text using the encoding Character.
	 * Assumption on the requirement: Input text will only contain values from the reference table provided in the original requirement.
	 * @param plainText The text to be decoded.
	 * @return encodedText The text that was decoded.
	 */
	public String decode(String encodedText) {
		int inputLength = encodedText.length();
		int inputIntegerValue = 0;
		int decodedInteger = 0;
		int decodeOffsetValue = getOffsetValue();
		char currentCharacter = ' ';
		StringBuilder decodedText = new StringBuilder();
		
		for(int i = 0; i < inputLength; i++) {
			// Handle spaces.
			currentCharacter = encodedText.charAt(i);
			if (currentCharacter == ' '){
				decodedText.append(' ');
				continue;
			}
			// Check if the character is valid.
			if (characterKeyTable.containsKey(currentCharacter) == false) {
				System.out.println("A character in the input text cannot be decoded, returning the encoded text.");
				return encodedText;
			}
			inputIntegerValue = characterKeyTable.get(currentCharacter);
			// Decode the string.
			if(decodeOffsetValue + inputIntegerValue < maxOffset) {
				decodedInteger = decodeOffsetValue + inputIntegerValue;
			}
			else {
				decodedInteger = (inputIntegerValue + decodeOffsetValue) % maxOffset;
			}
			decodedText.append(integerKeyTable.get(decodedInteger));
		}
		return decodedText.toString();
	}
	

}
