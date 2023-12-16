import java.util.Scanner;
import java.io.*;
class AffineCipher {
    static int a, b;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Key To Be Used In CIPHERING");
        //m
        System.out.println("ENTER a");
        a = in.nextInt();
        //k
        System.out.println("ENTER b");
        b = in.nextInt();
        String msg;
        System.out.println("ENTER PLAIN TEXT TO BE CIPHERED");
        msg = in.next();


        // Calling encryption function

        System.out.println("Encrypted Message is : " + encryptMessage (msg));

        // Calling Decryption function
        System.out.println("Decrypted Message is: " + decryptCipher(encryptMessage (msg)));

    }
    static String encryptMessage(String msg)
    {
        /// Cipher Text initially empty

        char[] plain=msg.toCharArray();
        String cipher = "";
        for (int i = 0; i < plain.length; i++)
        {

            if (Character.isUpperCase(plain[i]))
            {
                cipher = cipher + (char) ((((a  * (plain[i] - 65)) + b) % 26) + 65);
            } else // else simply append space character
            {
                cipher = cipher + (char) ((((a * (plain[i] - 97)) + b) % 26) + 97);
            }
        }
        return cipher;
    }

    static String decryptCipher(String cipher) {

        String msg = "";
        int a_inv = 0;
        int flag = 0;

        //Find a^-1 (the multiplicative inverse of a)
        //in the group of integers modulo m.
        for (int i = 0; i < 26; i++)
        {
            flag = (a * i) % 26;

            // Check if (a*i)%26 == 1,
            // then i will be the multiplicative inverse of a
            if (flag == 1)
            {
                a_inv = i;
            }
        }
        for (int i = 0; i < cipher.length(); i++)
        {

            if (Character.isUpperCase(cipher.charAt(i)))
            {
                int x =  a_inv *((cipher.charAt(i) -65) - b);

                while (x<0){
                    x+=26;
                }

                msg+=(char)(x%26+65);
            }
            else
            {
                int x =  a_inv *((cipher.charAt(i) -97) - b);

                while (x<0){
                    x+=26;
                }

                msg+=(char)(x%26+97);}
        }
        return msg;
    }
}


