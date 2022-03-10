import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class ArrayGenerator {
    static final int ARRAY_LENGTH = 100;
    static final String PATH_TO_FILE_WITH_ARRAY_OF_INT = "IntArray.txt";

    public static void generateNewRandomArrayInTxt() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(PATH_TO_FILE_WITH_ARRAY_OF_INT));
        Random random = new Random();

        for (int i = 0; i < 40000; i++) {
            out.print((random.nextInt() / 2) + " ");
        }

        out.close();
    }

    public static void generateSortedArrayInTxt() throws IOException {
        IntNumber[] intArray;
        intArray = generateNewIntArray();
        Sorter.mergeSortComparable(intArray);
        PrintWriter out = new PrintWriter(new FileWriter(PATH_TO_FILE_WITH_ARRAY_OF_INT));

        for (int i = 0; i < ARRAY_LENGTH; i++) {
            out.print(intArray[i] + " ");
        }

        out.close();
    }

    public static void generateNewArrayWithSameIntInTxt() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(PATH_TO_FILE_WITH_ARRAY_OF_INT));

        for (int i = 0; i < ARRAY_LENGTH; i++) {
            out.println("100 ");
        }

        out.close();
    }

    public static void generateRevertSortedArrayInTxt() throws IOException {
        IntNumber[] arrayOfInt = generateNewIntArray();
        Sorter.mergeSortComparable(arrayOfInt);
        PrintWriter out = new PrintWriter(new FileWriter(PATH_TO_FILE_WITH_ARRAY_OF_INT));

        for (int i = ARRAY_LENGTH - 1; i >= 0; i--) {
            out.print(arrayOfInt[i] + " ");
        }

        out.close();
    }

    public static IntNumber[] readArrayFromTxt() throws FileNotFoundException {
        IntNumber[] arrayOfInt = new IntNumber[ARRAY_LENGTH];
        Scanner scanner = new Scanner(new File(PATH_TO_FILE_WITH_ARRAY_OF_INT));

        for (int i = 0; i < ARRAY_LENGTH; i++) {
            if (scanner.hasNext()) {
                arrayOfInt[i] = new IntNumber(scanner.nextInt());
            }
        }

        return arrayOfInt;
    }

    public static IntNumber[] generateNewIntArray() {
        IntNumber[] arrayOfInt = new IntNumber[ARRAY_LENGTH];
        Random random = new Random();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            arrayOfInt[i] = new IntNumber(random.nextInt() / 2);
        }

        return arrayOfInt;
    }
}