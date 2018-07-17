package la.bean;

import java.util.Random;

public class PasswordGenerator {

	public String getRandomPassword() {
		StringBuilder source = new StringBuilder();
		
		// 0-9
		for (int i = 0x30; i < 0x3A; i++) {
			source.append((char) i);
		}
		
		//A-Z
		for (int i = 0x41; i < 0x5b; i++) {
			source.append((char) i);
		}
		
		//a-z
		for (int i = 0x61; i < 0x7b; i++) {
			source.append((char) i);
		}

		StringBuilder result = new StringBuilder();
		int length = 8;
		int sourceLength = source.length();
		Random random = new Random();
		while (result.length() < length) {
			result.append(source.charAt(Math.abs(random.nextInt()) % sourceLength));
		}

		return result.toString();
	}
}
