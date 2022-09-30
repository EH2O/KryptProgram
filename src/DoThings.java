import java.io.*;

public class DoThings {
    public static void main(String[] args) {
    String File1 = "fillBin1";
    String File2 = "FillText1";
    String Key = "Hej Hej";


    EnDeCrypt(readText(File2), Key, writeBin(File1));

    }

     static void EnDeCrypt(BufferedReader in, String Key, DataOutputStream output) {
        int x = 0;
        String inStr = "a";
        int CrypLetter;
        while (inStr != null) {
            try {
                inStr = in.readLine();
                if(inStr == null){
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < inStr.length(); i++) {
                if (x == Key.length()) {
                    x = 0;
                }
                CrypLetter =(Key.charAt(x)^inStr.charAt(i));
                try {
                    output.writeInt(CrypLetter);
                    System.out.println(CrypLetter);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                x++;
            }
        }

         try {
             output.flush();
             output.close();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     }

    private static void wirteText() {
        
    }

    private static BufferedReader readText(String fill) {
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(fill));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return in;
    }

    private static DataOutputStream writeBin(String fill) {
        DataOutputStream output;
        try {
            output = new DataOutputStream (new BufferedOutputStream(new FileOutputStream(fill)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    private static void readBin() {
        
    }
}
