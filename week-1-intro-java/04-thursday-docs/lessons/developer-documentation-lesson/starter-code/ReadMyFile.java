import java.io.*;

public class ReadMyFile {
  public static void main(String[] args) throws FileNotFoundException {
    FileReader reader = new FileReader("data.txt");
    System.out.println("We have made a FileReader");
  }
}
