import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MarkovAlgorithm {
    public static String pathToFile;

    public static ArrayList<String> readTxtInArrayList(String pathToFile) throws FileNotFoundException {
        File inputFile = new File(pathToFile);
        Scanner scanner = new Scanner(inputFile);
        int i = 0;
        ArrayList<String> algorithmArrayList = new ArrayList<>();
        while (scanner.hasNext()) {
            String temp = scanner.next();

            if (!Objects.equals(temp, "->")) {
                i++;
                algorithmArrayList.add(replaceAllRegExp(temp));
            }
        }
        return algorithmArrayList;
    }

    public static String replaceAllRegExp(String input) throws FileNotFoundException {
        String output = input;
        String[] badCharacters = {"\\|", "\\\\", "\\?", "\\+", "\\*", "\\[", "\\]", "\\^"};
        String[] regexpCharacters = {"\\\\|", "\\\\\\\\", "\\\\?", "\\\\+", "\\\\*", "\\\\[", "\\\\]", "\\\\^"};
        for (int i = 0; i < badCharacters.length; i++) {
            try {
                output = output.replaceAll(badCharacters[i], regexpCharacters[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return output;
    }

    public static void writeAlgorithmArrayList4Test(ArrayList<String> input) {
        System.out.println(input);
    }

    public static String inputTxtReading() throws FileNotFoundException {
        File input = new File("input.txt");
        Scanner scanner = new Scanner(input);
        return scanner.next();
    }

    public static String inputReader() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        return input;
    }

    public static boolean check4StopString(String str) {
        boolean stopString = false;
        if (str.contains(".")) {
            stopString = true;
        }
        return stopString;
    }

    public static String executeAlgorithm(String input, ArrayList<String> algorithm) {
        String output = input;
        String previousOutput;
        do {
            previousOutput = output;
            for (int i = 0; i < algorithm.size(); i = i + 2) {
                if (output.contains(algorithm.get(i))) {
                    output = output.replaceFirst(algorithm.get(i), algorithm.get(i + 1));
                    if (check4StopString(algorithm.get(i + 1))) {
                        break;
                    }
                    i = 0;
                }
            }
        } while (!previousOutput.equals(output));
        return output;
    }

    public static void main(String[] args) throws FileNotFoundException {
        //System.out.println("\n\n"+inputReader());
        //System.out.println(txtReading());
        
       /* String str = ",\\\\\\\\";
        str = str.replaceFirst(",\\\\", ",1");
        System.out.println(str);*/

        //System.out.println(replaceAllRegExp("\\\\\\"));

        pathToFile = "Algorithm.txt";
        writeAlgorithmArrayList4Test(readTxtInArrayList(pathToFile));
        System.out.println(executeAlgorithm("****", readTxtInArrayList(pathToFile)));
    }
}