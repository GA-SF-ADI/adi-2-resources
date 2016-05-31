import java.io.*;

public class ReadMyFile {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    FileReader reader = new FileReader("data.txt");
    System.out.println("We have made a FileReader");

    char [] data = new char[11];
    reader.read(data);
    for (int i = 0; i < data.length; i++) {
      System.out.print(data[i]);
    }
    reader.close();
  }
}
