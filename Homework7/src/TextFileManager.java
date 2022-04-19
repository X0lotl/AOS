import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFileManager {
    private PlaceOfSubString[] addPlaceOfSubString(int numberOfStringInFile, int indexOFStartOfSubStringInFile, PlaceOfSubString[] placeOfSubStrings) {
        PlaceOfSubString[] tempArray = new PlaceOfSubString[placeOfSubStrings.length + 1];
        System.arraycopy(placeOfSubStrings,0,tempArray,0, placeOfSubStrings.length);
        tempArray[tempArray.length - 1] = new PlaceOfSubString(numberOfStringInFile, indexOFStartOfSubStringInFile);
        return tempArray;
    }
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

        for (String s : inputArray) {
            bufferedWriter.write(s + "\n");

        }

        bufferedWriter.close();
    }

    boolean fileHasString(String inputString, File inputFile) throws FileNotFoundException {
        String[] inputArray = fileToStringArray(inputFile);
        for(String stringInArray : inputArray) {
            if(inputString.equals(stringInArray)){
                return true;
            }
        }

        return false;
    }

    PlaceOfSubString[] placesOfSubString(String inputSubString, File inputFile) throws FileNotFoundException {
        String[] inputArray = fileToStringArray(inputFile);
        PlaceOfSubString[] placesOfSubStrings = new PlaceOfSubString[0];
        Pattern pattern = Pattern.compile(inputSubString);


        for(int i = 0; i < inputArray.length; i++) {
            Matcher matcher = pattern.matcher(inputArray[i]);
            while (matcher.find()) {
                placesOfSubStrings = addPlaceOfSubString(i, matcher.start(), placesOfSubStrings);
            }
        }

        return placesOfSubStrings;
    }
}