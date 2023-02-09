package encoderDecoder;

/**
 * A class to encode a string containing only characters found in the reference table.
 * 
 */
public class Encoder extends ReferenceTable{
	public Encoder(){
		// Constructor that also initializes the reference table.
		initializeTable();
	}
		
	/**
	 * A function to encode the input text using the encoding Character.
	 * Assumption on the requirement: Input text will only contain values from the reference table provided in the original requirement.
	 * @param plainText The text to be encoded.
	 * @return encodedText The text that was encoded.
	 */
	public String encode(String plainText) {
		int inputLength = plainText.length();
		int inputIntegerValue = 0;
		int encodedInteger = 0;
		int encodeOffsetValue = getOffsetValue();
		char currentCharacter = ' ';
		StringBuilder encodedText = new StringBuilder();
		
		for(int i = 0; i < inputLength; i++) {
			currentCharacter = plainText.charAt(i);

			// Handle spaces.
			if (plainText.charAt(i) == ' '){
				encodedText.append(' ');
				continue;
			}
			// Check if character is valid.
			if (characterKeyTable.containsKey(currentCharacter) == false) {
				System.out.println("A character in the input text cannot be encoded, returning the original text.");
				return plainText;
			}
			inputIntegerValue = characterKeyTable.get(currentCharacter);
			// Encode the string.
			if(encodeOffsetValue > inputIntegerValue) {
				encodedInteger = maxOffset - (encodeOffsetValue - inputIntegerValue);
			}
			else {
				encodedInteger = inputIntegerValue - encodeOffsetValue;
			}
			encodedText.append(integerKeyTable.get(encodedInteger));
		}
		return encodedText.toString();
	}
	
}
