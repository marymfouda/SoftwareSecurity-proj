//A Java Program to illustrate Caesar Cipher Technique
import java.util.Scanner;
class CaesarCipher
{
    // Encrypts text using a shift od s
    public static String encrypt(String text, int s)
    {
        String cipherText= "";

        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +
                        s - 65) % 26 + 65);
                cipherText+=ch;
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) +
                        s - 97) % 26 + 97);
                cipherText+=ch;
            }
        }
        return cipherText;
    }
    public static String decrypt(String text, int s)
    {
        String PlainText= "";

        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                int p = (((int)text.charAt(i) -
                        s - 65));
                while (p<0) {
                    p += 26;
                }
                PlainText+=(char)(p % 26 + 65);;
            }


            else
            {
                int p = (((int)text.charAt(i) -
                        s - 97));
                while (p<0) {
                    p += 26;
                }
                PlainText+=(char)(p % 26 +97);;
            }

        }
        return PlainText;
    }

    // Driver code
    public static void main(String[] args)
    {
        String Text;
        int key;
        Scanner input = new Scanner(System.in);
        System.out.println("ENTER YOUR PLAINTEXT");
        Text=input.next();
        System.out.println("ENTER YOUR KEY");
        key=input.nextInt();
        // = "ATTACKATONCE";

        System.out.println("CipherText: " + encrypt(Text, key));
        System.out.println("PlainText: " + decrypt(encrypt(Text, key), key));
    }
}