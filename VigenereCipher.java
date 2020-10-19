public class VigenereCipher {

    public static String vigenere(String text, String key, boolean shift) {
        String output = "";
        int keyLength = key.length();
        for (int x = 0; x < text.length(); x++) {
            int letterValue, shiftNum = (int) key.charAt(x % keyLength) - 65;

            if (shift)
                letterValue = text.charAt(x) + shiftNum;
            else
                letterValue = text.charAt(x) - shiftNum;

            if (letterValue < 65) {
                int under = Math.abs(letterValue - 65);
                letterValue = 91 - under;
            }
            if (letterValue > 90) {
                int over = letterValue % 90;
                letterValue = 64 + over;
            }

            char letter = (char) letterValue;
            output += String.valueOf(letter);
        }
        return output;
    }

    public static void main (String[] args) {
        if (args.length != 3) {
            System.exit(0);
        }

        boolean shift; // True = Encode, False = Decode
        String text, key, outputText;

        if (args[0].equals("encode")) {
            shift = true;
        }
        else {
            shift = false;
        }

        text = args[1];
        key = args[2];

        text = text.toUpperCase();
        key = key.toUpperCase();

        outputText = vigenere(text, key, shift);

        System.out.println(outputText);
    }
}