import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class IntArrayTest {
    public static void main(String[] args) throws IOException {
        HashMap<String, Double> sorterMethodsTime = new HashMap<>();

        IntNumber[] arrayOfInt = new IntNumber[0];

        int[] arrayLengths = {1024, 2048, 4096, 8192, 16384, 32768};

        /*
         uncomment next strings to chose witch methods you want to use
         */

        //generateNewRandomArrayInTxt();

        //ArrayGenerator.generateRevertSortedArrayInTxt();

        //generateNewArrayWithSameIntINTxt();

        //generateSortedArrayInTxt();

        Timer timer = new Timer();
        Double time;

        for (int j = 0; j < Picker.arrayVariations.length; j++) {
            Picker.arrayVariations[j].pick(arrayLengths[j]);
            arrayOfInt = ArrayGenerator.readArrayFromTxt(arrayLengths[j]);
            
            for (int i = 0; i < Picker.pickMethods.length; i++) {
                timer.stopWatchAtStart();
                Picker.pickMethods[i].pick(arrayOfInt);
                time = timer.getElapsedTime();
                sorterMethodsTime.put(String.valueOf(i), time);
            }
        }

        System.out.println("\nSorter methods times: " + sorterMethodsTime);
    }
}