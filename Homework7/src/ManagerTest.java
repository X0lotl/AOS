import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class ManagerTest {
    public static void main(String[] args) throws FileNotFoundException {
        TextFileManager textFileManager = new TextFileManager();
        System.out.println(Arrays.toString(textFileManager.fileToStringArray(new File("input.txt"))));
    }
}