package encoderDecoder;

public class testFunctions {
	public static void main(String[] args) {
		Encoder encoder = new Encoder();
		Decoder decoder = new Decoder();
		// test 1
		test1(encoder, decoder);
		// test 2
		test2(encoder, decoder);			
	}
	
	public static boolean test1(Encoder encoder, Decoder decoder) {
		String testString = "HELLO WORLD";
		String expectedEncoding = "GDKKN VNQKC";
		char offsetCharacter = 'B';
		
		encoder.setOffsetCharacter(offsetCharacter);
		decoder.setOffsetCharacter(offsetCharacter);

		String encodedString = encoder.encode(testString);
		System.out.println(encodedString);
		if (!encodedString.equals(expectedEncoding)) {
			System.out.println("Test 1 Failed");	
			return false;
		}

		String decodedString = decoder.decode(encodedString);
		System.out.println(decodedString);
		if (!decodedString.equals(testString)) {
			System.out.println("Test 1 Failed");	
			return false;
		}

		System.out.println("Test 1 Passed");
		return true;
	}
	
	public static boolean test2(Encoder encoder, Decoder decoder) {
		String testString = "HELLO WORLD";
		String expectedEncoding = "C/GGJ RJMG.";
		char offsetCharacter = 'F';
		
		encoder.setOffsetCharacter(offsetCharacter);
		decoder.setOffsetCharacter(offsetCharacter);

		String encodedString = encoder.encode(testString);
		System.out.println(encodedString);
		if (!encodedString.equals(expectedEncoding)) {
			System.out.println("Test 1 Failed");	
			return false;
		}

		String decodedString = decoder.decode(encodedString);
		System.out.println(decodedString);
		if (!decodedString.equals(testString)) {
			System.out.println("Test 1 Failed");	
			return false;
		}

		System.out.println("Test 2 Passed");	
		return true;
	}

}
