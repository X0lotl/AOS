import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileManager {
    String[] addStringToArray(String inputString, String[] inputArray){
        String[] outputArray = new String[inputArray.length + 1];
        System.arraycopy(inputArray, 0, outputArray, 0, inputArray.length);
        outputArray[outputArray.length - 1] = inputString;
        return outputArray;
    }


    String[] fileToStringArray(File inputFile) throws FileNotFoundException {
        String[] outputArray = new String[0];
        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNext()){
            outputArray = addStringToArray(scanner.nextLine(), outputArray);
        }
        return outputArray;
    }
}