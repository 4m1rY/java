import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.*;

class Main {
  static Scanner scanner = new Scanner(System.in);
 
  public static void main(String[] args) {
    System.out.println("Please select option:");
    System.out.println("1) Encrypt message");
    System.out.println("2) Decrypt message");
    String selectedOption = scanner.nextLine();
   
   
    if (selectedOption.equals("1"))
    {
      String message = getMessage();
      String keyword = getKeyword();
      int shiftValue = generateShiftValue(keyword);
      String encryptedMessage = encrypt(message,shiftValue);
      System.out.println("The plaintext and enciphered text are as follows:");
      System.out.println(message);
      System.out.println(encryptedMessage);

      System.out.println("Enciphered text will now be written to a text file.");
      System.out.println("Enter a file name followed by the extension '.txt' (example: secret.txt):");
      String fileName = scanner.nextLine();
      writeToFile(fileName,encryptedMessage);
      System.out.println(String.format("Ciphertext has been written to local directory as %s",fileName));
    }
    else if (selectedOption.equals("2"))
    {
      System.out.println("Please select option:");
      System.out.println("1) Enter Cipher Text");
      System.out.println("2) Read From File");
      String selectedDecryptOption = scanner.nextLine();

      String cipherText = "";
      if(selectedDecryptOption.equals("1"))
      {
        cipherText = scanner.nextLine();
      }
      else if (selectedDecryptOption.equals("2"))
      {
        System.out.println("Please enter filename to read ciphertext:");
        String fileName = scanner.nextLine();
        cipherText = readFromFile(fileName);
      }
      else
      {
        System.out.println("Invalid option!");
      }

      if (cipherText.length()>0)
      {
        String deckeyword = getKeyword();
        int decshiftValue = generateShiftValue(deckeyword);
        String decryptedMessage = decrypt(cipherText,decshiftValue);
        System.out.println("The plaintext and enciphered text are as follows:");
        System.out.println(cipherText);
        System.out.println(decryptedMessage);
      }
     
    }
    else
    {
      System.out.println("Invalid option!");
    }
   
    scanner.close();
  }
 
  private static String getMessage (){
    System.out.println("Please enter message to encrypt:");
    String plainTextToEncrypt = scanner.nextLine();
    return plainTextToEncrypt.toUpperCase();
  }

  private static String getKeyword(){
    System.out.println("Please enter keyword with letters only, no spaces or punctuation:");
    String keyword = scanner.nextLine();

    while(!isKeywordValid(keyword)){
      System.out.println("Invalid keyword. Enter a keyword (letters only, no spaces or punctuation):");
            keyword = scanner.nextLine();
    }
    return keyword;
  }

  private static boolean isKeywordValid(String keyword) {
        return keyword.matches("[a-zA-Z]+");
    }

  private static int generateShiftValue(String keyword) {
        String upperCaseKeyword = keyword.toUpperCase();
        int sum = 0;

        for (int i = 0; i < upperCaseKeyword.length(); i++) {
            char c = upperCaseKeyword.charAt(i);
            sum += (int) c;
        }

        int shiftValue = sum % 26;
        if (shiftValue == 0) {
            shiftValue = 1;
        }

        return shiftValue;
    }

  private static String encrypt(String message, int shiftValue) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                c = (char) ((c - 'A' + shiftValue) % 26 + 'A');
            }
            ciphertext.append(c);
        }
        return ciphertext.toString();
    }

  private static String decrypt(String ciphertext, int shiftValue) {
    StringBuilder message = new StringBuilder();
    for (int i = 0; i < ciphertext.length(); i++) {
        char c = ciphertext.charAt(i);
        if (Character.isLetter(c)) {
            c = (char) ((c - 'A' - shiftValue + 26) % 26 + 'A');
        }
        message.append(c);
    }
    return message.toString();
}

  private static void writeToFile(String fileName, String ciphertext) {
        try {
            File file = new File(fileName);
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.print(ciphertext);
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
        }
    }

  private static String readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String content = "";
            while ((line = br.readLine()) != null) {
                content += line;
            }
            br.close();
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
 
}