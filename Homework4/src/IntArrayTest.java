import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class IntArrayTest {
    public static void addTimeInSorterMethodsArray(SorterMethod[] sorterMethods, int indexOfMethod, int arraySize, double time) {
        switch (arraySize) {
            case 1024 -> sorterMethods[indexOfMethod].timeOfSorterFor1024IntArray = time;
            case 2048 -> sorterMethods[indexOfMethod].timeOfSorterFor2048IntArray = time;
            case 4096 -> sorterMethods[indexOfMethod].timeOfSorterFor4096IntArray = time;
            case 8192 -> sorterMethods[indexOfMethod].timeOfSorterFor8192IntArray = time;
            case 16384 -> sorterMethods[indexOfMethod].timeOfSorterFor16384IntArray = time;
            case 32768 -> sorterMethods[indexOfMethod].timeOfSorterFor32768IntArray = time;
        }
    }

    public static void main(String[] args) throws IOException {
        HashMap<String, Double> sorterMethodsTime = new HashMap<>();

        IntNumber[] arrayOfInt = new IntNumber[0];

        SorterMethod[] sorterMethods = {
                new SorterMethod("Merge", 0, 0, 0, 0, 0, 0),
                new SorterMethod("Quick", 0, 0, 0, 0, 0, 0),
                new SorterMethod("Comb", 0, 0, 0, 0, 0, 0),
                new SorterMethod("Insertion", 0, 0, 0, 0, 0, 0),
                new SorterMethod("Bubble", 0, 0, 0, 0, 0, 0),
                new SorterMethod("Selection", 0, 0, 0, 0, 0, 0),
                new SorterMethod("Shell", 0, 0, 0, 0, 0, 0)
        };

        int[] arraysSize = {1024, 2048, 4096, 8192, 16384, 32768};

        String[] arrayVariations = {
                "Times for random array: ",
                "Times for already sorted array: ",
                "Times for revert sorted array: ",
                "Times for array with same int: "
        };

        Timer timer = new Timer();
        StringBuilder stringBuilder = new StringBuilder();


        for (int j = 0; j < Picker.arrayVariations.length; j++) {
            Picker.arrayVariations[j].pick(arraysSize[j]);
            arrayOfInt = ArrayGenerator.readArrayFromTxt(arraysSize[j]);

            for (int indexOfMethod = 0; indexOfMethod < Picker.pickMethods.length; indexOfMethod++) {

                for (int i : arraysSize) {
                    timer.stopWatchAtStart();
                    Picker.pickMethods[indexOfMethod].pick(arrayOfInt);
                    Double time = timer.getElapsedTime();
                    addTimeInSorterMethodsArray(sorterMethods, indexOfMethod, i, time);
                }
            }
            stringBuilder.append(arrayVariations[j] + '\n' + Arrays.toString(sorterMethods));
        }

        PrintWriter out = new PrintWriter(new File("output.txt"));
        out.println(stringBuilder.toString());
        out.close();
    }
}