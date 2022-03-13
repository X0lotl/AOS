import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Consumer;

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

    public static HashMap<String, Consumer<Comparable[]>> getHashMapOfSortionMethods() {
        return hashMapOfSortionMethods;
    }

    public static IntNumber[] getArrayOfInt() {
        return arrayOfInt;
    }

    public static HashMap<String, ArrayGenerator.GenerateNewInt> hashMapOfArrayVariations = new HashMap<>();

    public static HashMap<String, Consumer<Comparable[]>> hashMapOfSortionMethods = new HashMap<>();

    public static HashMap<Integer, Double> hashMapOfArraySizeAndTime = new HashMap<>();

    public static int indexOfArraysVariation;

    public static int[] arraysSize = {1024, 2048, 4096, 8192, 16384, 32768};

    public static SortionMethodsTimeData[] sortionMethodsTimeDataArray;

    public static IntNumber[] arrayOfInt = {new IntNumber(0)};

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
            sortionMethodsTimeDataArray[i] = new SortionMethodsTimeData(sortionMethodsName, hashMapOfSortionMethods.get(sortionMethodsName), hashMapOfArraySizeAndTime);
        }
    }

    public static String[] namesOfSortionMethodsArray = {
            "Merge", "Quick", "Comb", "Insertion", "Bubble", "Selection", "Shell"
    };

    public static void initHashMapOfArraySizeAndTime() {
        for (int i : arraysSize) {
            hashMapOfArraySizeAndTime.put(i, (double) 0);
        }
    }

    public static void initHashMapOfSortionMethods() {
        hashMapOfSortionMethods.put("Merge", Sorter::mergeSortComparable);
        hashMapOfSortionMethods.put("Quick", Sorter::quickSortComparable);
        hashMapOfSortionMethods.put("Comb", Sorter::combSortComparable);
        hashMapOfSortionMethods.put("Insertion", Sorter::insertionSortComparable);
        hashMapOfSortionMethods.put("Bubble", Sorter::bubbleSortComparable);
        hashMapOfSortionMethods.put("Selection", Sorter::selectionSortComparable);
        hashMapOfSortionMethods.put("Shell", Sorter::shellSortComparable);
    }

    public static void initHashMapOfArrayVariations(){
        hashMapOfArrayVariations.put("Random",ArrayGenerator::generateNewRandomArrayInTxt);
        hashMapOfArrayVariations.put("Already",ArrayGenerator::generateSortedArrayInTxt);
        hashMapOfArrayVariations.put("Revert",ArrayGenerator::generateRevertSortedArrayInTxt);
        hashMapOfArrayVariations.put("Same",ArrayGenerator::generateNewArrayWithSameIntInTxt);
    }

    public static void main(String[] args) throws IOException {
        initHashMapOfArrayVariations();
        initHashMapOfArraySizeAndTime();
        initHashMapOfSortionMethods();
        initSortionMethodsTimeDataArray();

        Timer timer = new Timer();
        StringBuilder stringBuilder = new StringBuilder();

        for (indexOfArraysVariation = 0; indexOfArraysVariation < arrayVariations.length; indexOfArraysVariation++){

        }

        /*
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
        }*/

        PrintWriter out = new PrintWriter(new File("output.txt"));
        out.println(stringBuilder);
        out.close();
    }
}