package la.bean;

import java.util.Random;


public class PasswordGenerator {

    public static String pg() {


        int length = 8;

        boolean useSign = false;

        String style = "normal";

        StringBuilder result = new StringBuilder();

        StringBuilder source = new StringBuilder();

        for (int i = 0x30; i < 0x3A; i++) {
            source.append((char) i);
        }

        if (useSign) {
            for (int i = 0x21; i < 0x30; i++) {
                source.append((char) i);
            }
        }

        switch (style) {
            case "lowerCase":
                break;
            default:
                for (int i = 0x41; i < 0x5b; i++) {
                    source.append((char) i);
                }
                break;
        }

        switch (style) {
            case "upperCase":
                break;
            default:
                for (int i = 0x61; i < 0x7b; i++) {
                    source.append((char) i);
                }
                break;
        }

        int sourceLength = source.length();
        Random random = new Random();
        while (result.length() < length) {
            result.append(source.charAt(Math.abs(random.nextInt()) % sourceLength));
        }

        return result.toString();

    }
}
