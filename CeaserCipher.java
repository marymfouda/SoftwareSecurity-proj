
import java.util.Scanner;
class CaesarCipher

{
    public static int DetermineNum(String text){
        boolean allUpperCase = true;
        boolean allLowerCase = true;
        for (int i=0 ; i< text.length() ; i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                allLowerCase = false;
            } else if (Character.isLowerCase(text.charAt(i))) {
                allUpperCase = false;
            } else {
                return -1;
            }
        }
        if (allUpperCase || allLowerCase) {
            return 26;
        } else {
            return 52;
        }
    }
    public static int generateKey(String key) {
        if (key.matches("-?\\d+")) {
            return Integer.parseInt(key);
        } else if (key.length() == 1 && Character.isLetter(key.charAt(0))) {
            char ch = key.charAt(0);
            if(Character.isLowerCase(ch)){
                return ch-97;
            }else{
                return ch - 65 + 26;
            }
        }else{
            return -1;
        }
    }

    public static String encrypt(String text, String initialKey)
    {
        int n=DetermineNum(text);
        String cipherText= "";
        int key = generateKey(initialKey);
        if (key == -1){
            return "Key should number or one char";
        }else if(n==-1){
            return "cipher text should include chars only";
        }else{
            for (int i=0; i<text.length(); i++)
            {
                if (Character.isUpperCase(text.charAt(i)))
                {
                    if(n==52){
                        int ct = ((text.charAt(i) +
                                key - 65 +26) );
                        while (ct<0) {
                            ct += 52;
                        }
                        cipherText+=(char)(ct% 52 + 65 -26);
                    }else{
                        int ct = ((text.charAt(i) +
                                key - 65)  );
                        while (ct<0) {
                            ct += n;
                        }
                        cipherText+=(char)(ct% n + 65);
                    }

                }
                else
                {
                    int ch = ((text.charAt(i) +
                            key - 97) );
                    while (ch < 0) {
                        ch += n;
                    }
                    cipherText+=(char)(ch% n + 97);
                }
            }
            return "CipherText: "+cipherText;
        }


    }
    public static String decrypt(String text, String initialKey)
    {
        int n=DetermineNum(text);
        String PlainText= "";
        int key = generateKey(initialKey);
        if (key == -1){
            return "Key should number or one char";

        }else if(n==-1){
            return "plain text should include chars only";
        }
        else{
            for (int i=0; i<text.length(); i++)
            {

                if (Character.isUpperCase(text.charAt(i)))
                {
                    if(n==52){
                        int p = ((text.charAt(i) -
                                key - 65 +26) );
                        while (p<0) {
                            p += n;
                        }
                        PlainText+=(char)(p% n + 65 -26);
                    }else{
                        int p = ((text.charAt(i) -
                                key - 65 ) );
                        while (p<0) {
                            p += n;
                        }
                        PlainText+=(char)(p% n + 65 );


                    }
                }


                else
                {
                    int p = ((text.charAt(i) -
                            key - 97));
                    while (p<0) {
                        p += n;
                    }
                    PlainText+=(char)(p % n + 97) ;
                }

            }
            return "PlainText: " + PlainText;
        }

    }


    public static void main(String[] args)
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
                System.out.println(encrypt(Text, key));
                break;
            case 2:
                System.out.println("ENTER YOUR CIPHERTEXT");
                Text=input.next();
                System.out.println("ENTER YOUR KEY");
                key=input.next();
                System.out.println(decrypt(Text, key));
                break;
            default:
                System.out.println("INCORRECT CHOICE! TRY AGAIN.");
        }
    }
}
