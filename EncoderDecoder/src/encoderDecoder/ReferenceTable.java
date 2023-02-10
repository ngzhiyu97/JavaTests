package encoderDecoder;

import java.util.HashMap;

/**
 * A class that contains the reference table for the encoding and decoding offset values.
 * 
 */
public class ReferenceTable {
	
	private char[] validEncodingCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./".toCharArray();
	// Offset character set to 'A' by default
	private char offsetCharacter = 'A';
	private int offsetValue = 0; 
	public int maxOffset = validEncodingCharacters.length;
	// HashMap contains the character used for encoding/decoding as the key and the integer offset as the value.
	public HashMap<Character, Integer> characterKeyTable = new HashMap<Character, Integer>();
	public HashMap<Integer, Character> integerKeyTable = new HashMap<Integer, Character>();

	public void initializeTable() {
		// Initialize the HashMap.
		for(int index = 0; index < validEncodingCharacters.length; index++) {
			characterKeyTable.put(validEncodingCharacters[index], index);
			integerKeyTable.put(index, validEncodingCharacters[index]);
		}
	}

	public void setOffsetCharacter(char newEncodingCharacter) {
		// Updates the character used to encode the text.
		if(characterKeyTable.containsKey(newEncodingCharacter)) {
			offsetCharacter = newEncodingCharacter;	
			offsetValue = characterKeyTable.get(offsetCharacter);
		}
		else {
			System.out.println("Invalid encoding character '" + newEncodingCharacter + "' entered!");
		}
	}
	
	public char getOffsetCharacter() {
		return offsetCharacter;
	}
	
	public int getOffsetValue() {
		return offsetValue;
	}
	
	public ReferenceTable(){
		// Constructor to initialize the table.
		initializeTable();
	}	
	
	public void printTable() {
		// Prints the contents of the reference table.
		for(int i = 0; i < validEncodingCharacters.length; i ++) {
			System.out.println("Key: " + validEncodingCharacters[i] + " " + "Value: " + characterKeyTable.get(validEncodingCharacters[i]));	
			System.out.println("Key: " + i + " " + "Value: " + integerKeyTable.get(i));	
		}
	}
}
