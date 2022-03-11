import java.io.*;
import java.util.Arrays;

public class IntArrayTest {
    public static SortionMethodsTimeData[] getSortionMethodsTimeDataArray() {
        return sortionMethodsTimeData;
    }

    public static int[] getArraysSize() {
        return arraysSize;
    }

    public static String[] getArrayVariations(){
        return arrayVariations;
    }

    public static int[] arraysSize = {1024, 2048, 4096, 8192, 16384, 32768};

    public static SortionMethodsTimeData[] sortionMethodsTimeData = {
            new SortionMethodsTimeData("Merge", 0, 0, 0, 0, 0, 0),
            new SortionMethodsTimeData("Quick", 0, 0, 0, 0, 0, 0),
            new SortionMethodsTimeData("Comb", 0, 0, 0, 0, 0, 0),
            new SortionMethodsTimeData("Insertion", 0, 0, 0, 0, 0, 0),
            new SortionMethodsTimeData("Bubble", 0, 0, 0, 0, 0, 0),
            new SortionMethodsTimeData("Selection", 0, 0, 0, 0, 0, 0),
            new SortionMethodsTimeData("Shell", 0, 0, 0, 0, 0, 0)
    };

    public static String[] arrayVariations = {
            "Times for random array: ",
            "Times for already sorted array: ",
            "Times for revert sorted array: ",
            "Times for array with same int: "
    };

    public static void main(String[] args) throws IOException {
        IntNumber[] arrayOfInt;

        Timer timer = new Timer();
        StringBuilder stringBuilder = new StringBuilder();

        for (int j = 0; j < Picker.arrayVariations.length; j++) {
            Picker.arrayVariations[j].pick(arraysSize[j]);
            arrayOfInt = ArrayGenerator.readArrayFromTxt(arraysSize[j]);

            for (int indexOfMethod = 0; indexOfMethod < Picker.pickMethods.length; indexOfMethod++) {

                for (int i = 0; i < arraysSize.length; i++) {
                    timer.stopWatchAtStart();
                    Picker.pickMethods[indexOfMethod].pick(arrayOfInt);
                    double time = timer.getElapsedTime();
                    Picker.addTimeToArrayOfTimeData[i].add(indexOfMethod, time);
                }
            }
            new GraphBuilder().start(args);
            stringBuilder.append(arrayVariations[j]).append('\n').append(Arrays.toString(sortionMethodsTimeData));
        }

        PrintWriter out = new PrintWriter(new File("output.txt"));
        out.println(stringBuilder);
        out.close();
    }
}