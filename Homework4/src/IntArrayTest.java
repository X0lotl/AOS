import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class IntArrayTest {
    public static void main(String[] args) throws IOException {
        HashMap<String, Double> sorterMethodsTime = new HashMap<>();



        IntNumber[] arrayOfInt;

        /*
         uncomment next strings to chose witch methods you want to use
         */

        //generateNewRandomArrayInTxt();

        ArrayGenerator.generateRevertSortedArrayInTxt();

        //generateNewArrayWithSameIntINTxt();

        //generateSortedArrayInTxt();


        arrayOfInt = ArrayGenerator.readArrayFromTxt();
        System.out.println("Your array before sorting: " + Arrays.toString(arrayOfInt));

        Timer timer = new Timer();
        Double time;

        for(int i = 0; i < Picker.pickMethods.length; i++){
            timer.stopWatchAtStart();
            Picker.pickMethods[i].pick(arrayOfInt);
            time = timer.getElapsedTime();
            sorterMethodsTime.put(String.valueOf(i),time);
        }

        System.out.println("\nSorter methods times: " + sorterMethodsTime);
    }
}