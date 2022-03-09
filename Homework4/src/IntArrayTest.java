import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class IntArrayTest {
    static final int ARRAY_LENGTH = 100;
    static final String PATH_TO_FILE_WITH_ARRAY_OF_INT = "IntArray.txt";

    private static void generateNewRandomArrayInTxt() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(PATH_TO_FILE_WITH_ARRAY_OF_INT));
        Random random = new Random();

        for (int i = 0; i < 40000; i++) {
            out.print((random.nextInt() / 2) + " ");
        }

        out.close();
    }

    private static void generateSortedArrayInTxt() throws IOException {
        IntNumber[] intArray;
        intArray = generateNewIntArray();
        Sorter.mergeSortComparable(intArray);
        PrintWriter out = new PrintWriter(new FileWriter(PATH_TO_FILE_WITH_ARRAY_OF_INT));

        for (int i = 0; i < ARRAY_LENGTH; i++) {
            out.println(intArray[i] + " ");
        }

        out.close();
    }

    private static void generateNewArrayWithSameIntINTxt() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(PATH_TO_FILE_WITH_ARRAY_OF_INT));

        for (int i = 0; i < ARRAY_LENGTH; i++){
            out.println("100 ");
        }

        out.close();
    }

    private static IntNumber[] readArrayFromTxt() throws FileNotFoundException {
        IntNumber[] arrayOfInt = new IntNumber[ARRAY_LENGTH];
        Scanner scanner = new Scanner(new File(PATH_TO_FILE_WITH_ARRAY_OF_INT));

        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if (scanner.hasNext()) {
                arrayOfInt[i] = new IntNumber(scanner.nextInt());
            }
        }

        return arrayOfInt;
    }

    private static IntNumber[] generateNewIntArray() {
        IntNumber[] arrayOfInt = new IntNumber[ARRAY_LENGTH];
        Random random = new Random();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            arrayOfInt[i] = new IntNumber(random.nextInt() / 2);
        }

        return arrayOfInt;
    }

    public static void main(String[] args) throws IOException {
        HashMap<String, Double> sorterMethodsTime = new HashMap<>();

        IntNumber[] arrayOfInt;

        /*
         uncomment next strings to chose witch methods you want to use
         */

        generateNewRandomArrayInTxt();

        //generateNewArrayWithSameIntINTxt();

        //generateSortedArrayInTxt();

        arrayOfInt = readArrayFromTxt();
        System.out.println("Your array before sorting: " + Arrays.toString(arrayOfInt));

        Timer timer = new Timer();
        Double time;

        arrayOfInt = readArrayFromTxt();
        timer.stopWatchAtStart();
        Sorter.mergeSortComparable(arrayOfInt);
        time = timer.getElapsedTime();
        System.out.println('\n' + "Your array is sorted through merge sorter: \n" + Arrays.toString(arrayOfInt));
        System.out.println("Merge sorter time: " + time);
        sorterMethodsTime.put("Merge sorter time", time);

        arrayOfInt = readArrayFromTxt();
        timer.stopWatchAtStart();
        Sorter.quickSortComparable(arrayOfInt, 0, arrayOfInt.length - 1);
        time = timer.getElapsedTime();
        System.out.println('\n' + "Your array is sorted through quick sorter: \n" + Arrays.toString(arrayOfInt));
        System.out.println("Quick sorter time: " + time);
        sorterMethodsTime.put("Quick sorter time", time);

        arrayOfInt = readArrayFromTxt();
        timer.stopWatchAtStart();
        Sorter.combSortComparable(arrayOfInt);
        time = timer.getElapsedTime();
        System.out.println('\n' + "Your array is sorted through comb sorter: \n" + Arrays.toString(arrayOfInt));
        System.out.println("Comb sorter time: " + time);
        sorterMethodsTime.put("Comb sorter time", time);

        arrayOfInt = readArrayFromTxt();
        timer.stopWatchAtStart();
        Sorter.insertionSortComparable(arrayOfInt);
        time = timer.getElapsedTime();
        System.out.println('\n' + "Your array is sorted through insertion sorter: \n" + Arrays.toString(arrayOfInt));
        System.out.println("Insertion sorter time: " + time);
        sorterMethodsTime.put("Insertion sorter time", time);

        arrayOfInt = readArrayFromTxt();
        timer.stopWatchAtStart();
        Sorter.bubbleSortComparable(arrayOfInt);
        time = timer.getElapsedTime();
        System.out.println('\n' + "Your array is sorted through bubble sorter: \n" + Arrays.toString(arrayOfInt));
        System.out.println("Bubble sorter time: " + time);
        sorterMethodsTime.put("Bubble sorter time", time);

        arrayOfInt = readArrayFromTxt();
        timer.stopWatchAtStart();
        Sorter.selectionSortComparable(arrayOfInt);
        time = timer.getElapsedTime();
        System.out.println('\n' + "Your array is sorted through selection sorter: \n" + Arrays.toString(arrayOfInt));
        System.out.println("Selection sorter time: " + time);
        sorterMethodsTime.put("Selection sorter time", time);

        arrayOfInt = readArrayFromTxt();
        timer.stopWatchAtStart();
        Sorter.shellSortComparable(arrayOfInt);
        time = timer.getElapsedTime();
        System.out.println('\n' + "Your array is sorted through shell sorter: \n" + Arrays.toString(arrayOfInt));
        System.out.println("Shell sorter time: " + time);
        sorterMethodsTime.put("Shell sorter time", time);

        System.out.println("\nSorter methods times: " + sorterMethodsTime);
    }
}