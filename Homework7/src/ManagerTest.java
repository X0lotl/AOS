import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ManagerTest {
    public static void main(String[] args) throws IOException {
        TextFileManager textFileManager = new TextFileManager();

        File inputFile = new File("input.txt");

        String[] testArray = {"2323", "123", "jsabdkas", "X0lotl"};

        System.out.println(Arrays.toString(textFileManager.placesOfSubString("123", inputFile)));

        //System.out.println(textFileManager.fileHasString("X0lotl", inputFile));

        //System.out.println(Arrays.toString(textFileManager.fileToStringArray(inputFile)));

        //textFileManager.stringArrayToFile(testArray, inputFile);
    }
}