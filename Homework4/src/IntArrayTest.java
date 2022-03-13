import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class IntArrayTest {
    public static SortionMethodsTimeData[] getSortionMethodsTimeDataArray() {
        return sortionMethodsTimeDataArray;
    }

    public static int[] getArraysSize() {
        return arraysSize;
    }

    public static String[] getArrayVariations() {
        return arrayVariations;
    }

    public static int getIndexOfArraysVariation() {
        return indexOfArraysVariation;
    }
    public static HashMap<String, Comparable[]> getHashMapOfSortionMethods() {
        return hashMapOfSortionMethods;
    }

    public static IntNumber[] getArrayOfInt(){
        return arrayOfInt;
    }

    public static HashMap<String, Comparable[]> hashMapOfSortionMethods = new HashMap<>();

    public static int indexOfArraysVariation;

    public static int[] arraysSize = {1024, 2048, 4096, 8192, 16384, 32768};

    public static SortionMethodsTimeData[] sortionMethodsTimeDataArray;

    public static IntNumber[] arrayOfInt;

    public static String[] arrayVariations = {
            "Times for random array: ",
            "Times for already sorted array: ",
            "Times for revert sorted array: ",
            "Times for array with same int: "
    };

    public static void initSortionMethodsTimeDataArray() {
        sortionMethodsTimeDataArray = new SortionMethodsTimeData[namesOfSortionMethodsArray.length];
        for (int i = 0; i < namesOfSortionMethodsArray.length; i++) {
            String sortionMethodsName = (String) hashMapOfSortionMethods.keySet().toArray()[i];
            sortionMethodsTimeDataArray[i] = new SortionMethodsTimeData(sortionMethodsName,hashMapOfSortionMethods.get(sortionMethodsName ), 0, 0, 0, 0, 0, 0);
        }
    }

    public static String[] namesOfSortionMethodsArray = {
            "Merge", "Quick", "Comb", "Insertion", "Bubble", "Selection", "Shell"
    };

    public static void initHashMapOfSortionMethods(){
        hashMapOfSortionMethods.put("Merge", Sorter.mergeSortComparable(arrayOfInt));
        hashMapOfSortionMethods.put("Quick", Sorter.quickSortComparable(arrayOfInt,0,arrayOfInt.length - 1));
        hashMapOfSortionMethods.put("Comb", Sorter.combSortComparable(arrayOfInt));
        hashMapOfSortionMethods.put("Insertion",Sorter.insertionSortComparable(arrayOfInt));
        hashMapOfSortionMethods.put("Bubble",Sorter.bubbleSortComparable(arrayOfInt));
        hashMapOfSortionMethods.put("Selection",Sorter.selectionSortComparable(arrayOfInt));
        hashMapOfSortionMethods.put("Shell",Sorter.shellSortComparable(arrayOfInt));
    }

    public static void main(String[] args) throws IOException {
        initHashMapOfSortionMethods();
        initSortionMethodsTimeDataArray();

        Timer timer = new Timer();
        StringBuilder stringBuilder = new StringBuilder();

        for (indexOfArraysVariation = 0; indexOfArraysVariation < Picker.arrayVariations.length; indexOfArraysVariation++) {
            Picker.arrayVariations[indexOfArraysVariation].pick(arraysSize[indexOfArraysVariation]);
            arrayOfInt = ArrayGenerator.readArrayFromTxt(arraysSize[indexOfArraysVariation]);

            for (int indexOfMethod = 0; indexOfMethod < Picker.pickMethods.length; indexOfMethod++) {

                for (int i = 0; i < arraysSize.length; i++) {
                    timer.stopWatchAtStart();
                    Picker.pickMethods[indexOfMethod].pick(arrayOfInt);
                    double time = timer.getElapsedTime();
                    Picker.addTimeToArrayOfTimeData[i].add(indexOfMethod, time);
                }
            }
            //new GraphBuilder().start(args); //uncomment this string if you want to generate graphs
            stringBuilder.append("\n\n").append(arrayVariations[indexOfArraysVariation]).append('\n').append(Arrays.toString(sortionMethodsTimeDataArray));
        }

        PrintWriter out = new PrintWriter(new File("output.txt"));
        out.println(stringBuilder);
        out.close();
    }
}