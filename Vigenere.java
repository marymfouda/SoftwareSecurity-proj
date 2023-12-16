import java.security.Key;
import java.util.Scanner;

    public class Vigenere {
        // This function generates the key in
        // a cyclic manner until it's length isi'nt
        // equal to the length of original text

        public static String generateKey(String Text, String key) {
            int x = Text.length();

            for (int i = 0;; i++) {
                if (x == i) {
                    i = 0;
                }
                if (key.length() == Text.length()) {
                    break;
                }
                key += (key.charAt(i));
                key=key.toLowerCase();
            }
            return key;
        }

        // This function returns the encrypted text
        // generated with the help of the key
        static String cipherText(String Text, String key) {
            String cipher_text = "";

            for (int i = 0; i < Text.length(); i++) {
                // converting in range 0-25
                if (Character.isUpperCase(Text.charAt(i))) {
                    int x = (((Text.charAt(i)
                            + key.charAt(i) -65)) % 26)+65;


                    // convert into alphabets(ASCII)
                    cipher_text += (char) (x);
                } else {
                    int x=(((Text.charAt(i)
                            +key.charAt(i) -97)) % 26)+97;
                    // convert into alphabets(ASCII)
                    cipher_text += (char) (x);
                }

            }
            return cipher_text;}
        // This function decrypts the encrypted text
        // and returns the original text
        static String originalText (String cipher_text, String key){
            String orig_text = "";

            for (int i = 0; i < cipher_text.length()
                    && i < key.length(); i++) {

                // converting in range 0-25
                if (Character.isUpperCase(cipher_text.charAt(i))) {
                    int x = (((int)cipher_text.charAt(i)
                            - key.charAt(i) -65 ));


                    // convert into alphabets(ASCII)
                    while (x<0){
                        x+=26;
                    }

                    orig_text += (char) (x%26+65);
                } else {
                    int x = (((int)cipher_text.charAt(i)
                            - key.charAt(i) -97 ));
                    while (x<0){
                        x+=26;
                    }

                    // convert into alphabets(ASCII)

                    orig_text += (char) (x% 26+97);
                }
            }

            return orig_text;
        }

        public static void main (String[]args)
        {
            String Text;
            String key;
            Scanner input = new Scanner(System.in);
            System.out.println("ENTER YOUR PLAINTEXT");
            Text = input.next();
            System.out.println("ENTER YOUR KEY");
            key = input.next();
            // = "ATTACKATONCE";
            key = generateKey(Text, key);


            System.out.println("CipherText: " + cipherText(Text, key));
            System.out.println("PlainText: " + originalText(cipherText(Text, key), key));
        }
    }

