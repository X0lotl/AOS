import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class IntArrayTest {
    static final int ARRAY_LENGTH = 1024;
    static final String PATH_TO_FILE_WITH_ARRAY_OF_INT = "IntArray.txt";

    private static void generateNewArrayInTxt() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(PATH_TO_FILE_WITH_ARRAY_OF_INT));
        Random random = new Random();
        for (int i = 0; i < 40000; i++) {
            //  out.print(ARRAY_LENGTH - i + " ");
            out.print((random.nextInt()/2) + " ");
        }
    }

    private static IntNumber[] readArrayFromTxt() throws FileNotFoundException {
        IntNumber[] arrayOfInt = new IntNumber[ARRAY_LENGTH];
        Scanner scanner = new Scanner(new File(PATH_TO_FILE_WITH_ARRAY_OF_INT));
        int tempInt;

        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if (scanner.hasNext()) {
                arrayOfInt[i] = new IntNumber(scanner.nextInt());
            }
        }

        return arrayOfInt;
    }

    private static IntNumber[] generateNewIntArray(int arrayLength) {
        IntNumber[] arrayOfInt = new IntNumber[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            arrayOfInt[i] = new IntNumber(random.nextInt());
        }

        return arrayOfInt;
    }

    public static void main(String[] args) throws IOException {


        IntNumber[] arrayOfInt;

        generateNewArrayInTxt();

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

        arrayOfInt = readArrayFromTxt();
        timer.stopWatchAtStart();
        Sorter.quickSortComparable(arrayOfInt, 0, arrayOfInt.length - 1);
        time = timer.getElapsedTime();
        System.out.println('\n' + "Your array is sorted through quick sorter: \n" + Arrays.toString(arrayOfInt));
        System.out.println("Quick sorter time: " + time);

        arrayOfInt = readArrayFromTxt();
        timer.stopWatchAtStart();
        Sorter.combSortComparable(arrayOfInt);
        time = timer.getElapsedTime();
        System.out.println('\n' + "Your array is sorted through comb sorter: \n" + Arrays.toString(arrayOfInt));
        System.out.println("Comb sorter time: " + time);

        arrayOfInt = readArrayFromTxt();
        timer.stopWatchAtStart();
        Sorter.insertionSortComparable(arrayOfInt);
        time = timer.getElapsedTime();
        System.out.println('\n' + "Your array is sorted through insertion sorter: \n" + Arrays.toString(arrayOfInt));
        System.out.println("Insertion sorter time: " + time);

        arrayOfInt = readArrayFromTxt();
        timer.stopWatchAtStart();
        Sorter.bubbleSortComparable(arrayOfInt);
        time = timer.getElapsedTime();
        System.out.println('\n' + "Your array is sorted through bubble sorter: \n" + Arrays.toString(arrayOfInt));
        System.out.println("Bubble sorter time: " + time);

        arrayOfInt = readArrayFromTxt();
        timer.stopWatchAtStart();
        Sorter.selectionSortComparable(arrayOfInt);
        time = timer.getElapsedTime();
        System.out.println('\n' + "Your array is sorted through selection sorter: \n" + Arrays.toString(arrayOfInt));
        System.out.println("Selection sorter time: " + time);

        arrayOfInt = readArrayFromTxt();
        timer.stopWatchAtStart();
        Sorter.shellSortComparable(arrayOfInt);
        time = timer.getElapsedTime();
        System.out.println('\n' + "Your array is sorted through shell sorter: \n" + Arrays.toString(arrayOfInt));
        System.out.println("Shell sorter time: " + time);
    }
}