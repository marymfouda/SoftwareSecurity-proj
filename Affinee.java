import java.util.Scanner;
import java.io.*;
class AffineCipher {
    public static int gcd(int a){
        int max=Math.max(a, 26);
        int min=Math.min(a, 26);
        while(min !=0){
            int temp=max;
            max=min;
            min=temp%min;
        }
        return max;
    }
    public static String encrypt(String PT,int a,int b)
    {
        int gcd=gcd(a);
        if(gcd==1){
            String cipherText = "";
            for (int i = 0; i < PT.length(); i++)
            {
                if (Character.isUpperCase(PT.charAt(i)))
                {
                    cipherText += (char) ((((a  * (PT.charAt(i) - 65)) + b) % 26) + 65);
                } else
                {
                    cipherText += (char) ((((a * (PT.charAt(i) - 97)) + b) % 26) + 97);
                }
            }
            return "cipherText is: "+cipherText;
        }else{
            return "GCD is "+gcd+" and not equale 1, Can't Encrypt with Affine!";
        }

    }
    public static int multiplicativeInverseMod26(int a) {
        for (int i = 1; i < 26; i++) {
            if ((a * i) % 26 == 1) {
                return i;
            }
        }
        return -1;
    }

    public static String decrypt(String cipher,int a,int b) {

        String PT = "";
        int gcd=gcd(a);
        int a_inv=multiplicativeInverseMod26(a);
        if(gcd==1){

            for (int i = 0; i < cipher.length(); i++)
            {

                if (Character.isUpperCase(cipher.charAt(i)))
                {
                    int x =  a_inv *((cipher.charAt(i) -65) - b);

                    while (x<0){
                        x+=26;
                    }

                    PT+=(char)(x%26+65);
                }
                else
                {
                    int x =  a_inv *((cipher.charAt(i) -97) - b);

                    while (x<0){
                        x+=26;
                    }

                    PT+=(char)(x%26+97);}
            }
            return "Original Text: "+PT;
        }else{
            return "GCD is "+gcd(a)+" and not equale 1, Can't Decrypt!";
        }

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("ENTER 1 for Encryption or 2 for Decryption");
        int x=input.nextInt();
        String Text;
        int a,b;
        switch(x) {
            case 1:
                System.out.println("ENTER YOUR PLAINTEXT");
                Text=input.next();
                System.out.println("Enter Key To Be Used In CIPHERING");
                System.out.println("ENTER a");
                a = input.nextInt();
                System.out.println("ENTER b");
                b = input.nextInt();
                System.out.println(encrypt(Text,a,b));
                break;
            case 2:
                System.out.println("ENTER YOUR CIPHERTEXT");
                Text=input.next();
                System.out.println("Enter Key To Be Used In CIPHERING");
                System.out.println("ENTER a");
                a = input.nextInt();
                System.out.println("ENTER b");
                b = input.nextInt();
                System.out.println(decrypt(Text,a,b));
                break;
            default:
                System.out.println("INCORRECT CHOICE! TRY AGAIN.");
        }

    }

}
