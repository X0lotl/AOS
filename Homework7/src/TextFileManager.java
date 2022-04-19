import java.io.*;
import java.util.Scanner;

public class TextFileManager {
    private String[] addStringToArray(String inputString, String[] inputArray){
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

    void stringArrayToFile(String[] inputArray, File outputFile) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));

        for (int i = 0; i < inputArray.length; i++){
            bufferedWriter.write(inputArray[i] + "\n");

        }

        bufferedWriter.close();
    }
}