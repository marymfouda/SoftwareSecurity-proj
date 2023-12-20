
//import java.security.Key;
import java.util.Scanner;

public class Vigenere {

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
    static String encrypt(String text, String key) {
        String cipherText = "";
        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                int ct = ((text.charAt(i) +
                        key.charAt(i) - 2*65));
                while (ct<0) {
                    ct += 26;
                }
                cipherText+=(char)(ct % 26 + 65);

            }
            else
            {
                int ch = (text.charAt(i) +
                        key.charAt(i) - 2*97) ;
                while (ch < 0) {
                    ch += 26;
                }
                cipherText+=(char)(ch% 26 + 97);
            }
        }
        return "CipherText: "+cipherText;
    }
    // This function decrypts the encrypted text
    // and returns the original text
    public static String decrypt(String text, String key)
    {
        String PlainText= "";
        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {

                int p = (((int)text.charAt(i) -
                        key.charAt(i)) );
                while (p<0) {
                    p += 26;
                }
                PlainText+=(char)(p%26 +65);
            }


            else
            {
                int p = (((int)text.charAt(i) -
                        key.charAt(i)) );
                while (p<0) {
                    p += 26;
                }
                PlainText+=(char)(p%26 +97) ;
            }

        }
        return "PlainText: " + PlainText;

    }

    public static void main (String[]args)
    {
        String Text;
        String key;
        Scanner input = new Scanner(System.in);
        System.out.println("ENTER 1 for Encryption or 2 for Decryption");
        int x=input.nextInt();
        switch(x) {
            case 1:
                System.out.println("ENTER YOUR PLAINTEXT");
                Text=input.next();
                System.out.println("ENTER YOUR KEY");
                key=input.next();
                key=generateKey(Text, key);
                System.out.println(encrypt(Text, key));
                break;
            case 2:
                System.out.println("ENTER YOUR CIPHERTEXT");
                Text=input.next();
                System.out.println("ENTER YOUR KEY");
                key=input.next();
                key=generateKey(Text, key);
                System.out.println(decrypt(Text, key));
                break;
            default:
                System.out.println("INCORRECT CHOICE! TRY AGAIN.");
        }
    }
}