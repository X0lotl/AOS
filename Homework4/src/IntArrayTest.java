import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Consumer;

public class IntArrayTest {

    public static HashMap<String, ArrayGenerator.GenerateNewInt> hashMapOfArrayVariations = new HashMap<>();

    public static HashMap<String, Consumer<Comparable[]>> hashMapOfSortionMethods = new HashMap<>();

    public static HashMap<Integer, Double> hashMapOfArraySizeAndTime = new HashMap<>();

    public static int indexOfArraysVariation;

    public static SortionMethodsTimeData[] sortionMethodsTimeDataArray;

    public static IntNumber[] arrayOfInt = {new IntNumber(0)};

    public static void initSortionMethodsTimeDataArray() {
        sortionMethodsTimeDataArray = new SortionMethodsTimeData[hashMapOfSortionMethods.size()];
        for (int i = 0; i < hashMapOfSortionMethods.size(); i++) {
            String sortionMethodsName = (String) hashMapOfSortionMethods.keySet().toArray()[i];
            sortionMethodsTimeDataArray[i] = new SortionMethodsTimeData(sortionMethodsName, hashMapOfSortionMethods.get(sortionMethodsName), hashMapOfArraySizeAndTime);
        }
    }

    public static void initHashMapOfArraySizeAndTime() {
        for (int i : arraysSize) {
            hashMapOfArraySizeAndTime.put(i, (double) 0);
        }
    }

    public static int[] arraysSize = {1024, 2048, 4096, 8192, 16384, 32768};

    public static void initHashMapOfSortionMethods() {
        hashMapOfSortionMethods.put("Merge", Sorter::mergeSortComparable);
        hashMapOfSortionMethods.put("Quick", Sorter::quickSortComparable);
        hashMapOfSortionMethods.put("Comb", Sorter::combSortComparable);
        hashMapOfSortionMethods.put("Insertion", Sorter::insertionSortComparable);
        hashMapOfSortionMethods.put("Bubble", Sorter::bubbleSortComparable);
        hashMapOfSortionMethods.put("Selection", Sorter::selectionSortComparable);
        hashMapOfSortionMethods.put("Shell", Sorter::shellSortComparable);
    }

    public static void initHashMapOfArrayVariations() {
        hashMapOfArrayVariations.put("Random", ArrayGenerator::generateNewRandomArrayInTxt);
        hashMapOfArrayVariations.put("Already", ArrayGenerator::generateSortedArrayInTxt);
        hashMapOfArrayVariations.put("Revert", ArrayGenerator::generateRevertSortedArrayInTxt);
        hashMapOfArrayVariations.put("Same", ArrayGenerator::generateNewArrayWithSameIntInTxt);
    }

    public static void main(String[] args) throws IOException {
        initHashMapOfArrayVariations();
        initHashMapOfArraySizeAndTime();
        initHashMapOfSortionMethods();
        initSortionMethodsTimeDataArray();

        Timer timer = new Timer();
        StringBuilder stringBuilder = new StringBuilder();

        for (indexOfArraysVariation = 0; indexOfArraysVariation < hashMapOfArrayVariations.size(); indexOfArraysVariation++) {
            for (int i : arraysSize) {
                hashMapOfArrayVariations.get(hashMapOfArrayVariations.keySet().toArray()[indexOfArraysVariation]).generate(i);
                arrayOfInt = ArrayGenerator.readArrayFromTxt(i);
                for (SortionMethodsTimeData sortionMethodsTimeData : sortionMethodsTimeDataArray) {
                    timer.stopWatchAtStart();
                    sortionMethodsTimeData.sortionMethod.accept(arrayOfInt);
                    double time = timer.getElapsedTime();
                    sortionMethodsTimeData.hashMapForTimeFromArraySize.replace(i, time);
                }
            }
            stringBuilder.append("\n\n").append(hashMapOfArrayVariations.keySet().toArray()[indexOfArraysVariation]).append('\n').append(Arrays.toString(sortionMethodsTimeDataArray));
        }

        PrintWriter out = new PrintWriter(new File("output.txt"));
        out.println(stringBuilder);
        out.close();
    }
}