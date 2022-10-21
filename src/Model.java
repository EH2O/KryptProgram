import java.io.*;

public class Model {
    private String file1;
    private String file2;
    private String key;
    private boolean isOn;
    public void setFileIn(String file1){
        this.file1 = file1;
    }
    public void setFileOut(String file2){
        this.file2 = file2;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public void isOn(boolean isOn){
        this.isOn = isOn;
    }
    public void Crypt(){

    }

    public String decrypt(BufferedWriter out, String key, DataInputStream in) {
        String Secret = "";
        int x = 0;
        int inStr;
        try {
            inStr = in.readInt();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int CrypLetter = 0;
        while (1 == 1) {

            if (x == key.length()) {
                    x = 0;
                }
            CrypLetter = (inStr^key.charAt(x));

            Secret += (char)(CrypLetter);
            System.out.println("step 2:" + Secret);
            x++;
            try {

                inStr = in.readInt();
            } catch (IOException e) {
                break;
            }

        }
        try {
            out.write(Secret);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            out.flush();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Secret;
    }



     static void EnCrypt(BufferedReader in, String Key, DataOutputStream output) {
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
                System.out.println("step 1:" + Key.charAt(x));
                try {
                    output.writeInt(CrypLetter);

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

    public BufferedWriter wirteText(String fill) {
        BufferedWriter out;
        try {
            out = new BufferedWriter(new FileWriter(fill));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return out;
    }

    public BufferedReader readText(String fill) {
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(fill));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return in;
    }

    public DataOutputStream writeBin(String fill) {
        DataOutputStream output;
        try {
            output = new DataOutputStream (new BufferedOutputStream(new FileOutputStream(fill)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    public DataInputStream readBin(String fill) {
        DataInputStream input;
        try {
            input = new DataInputStream(new BufferedInputStream(new FileInputStream(fill)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return input;
    }
}
