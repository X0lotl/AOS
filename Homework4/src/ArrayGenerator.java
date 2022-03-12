import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class ArrayGenerator {
    static final String PATH_TO_FILE_WITH_ARRAY_OF_INT = "saves/IntArray.txt";

    public static void generateNewRandomArrayInTxt(int arrayLength) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(PATH_TO_FILE_WITH_ARRAY_OF_INT));
        Random random = new Random();

        for (int i = 0; i < arrayLength; i++) {
            out.print((random.nextInt() / 2) + " ");
        }

        out.close();
    }

    public static void generateSortedArrayInTxt(int arrayLength) throws IOException {
        IntNumber[] intArray;
        intArray = generateNewIntArray(arrayLength);
        Sorter.mergeSortComparable(intArray);
        PrintWriter out = new PrintWriter(new FileWriter(PATH_TO_FILE_WITH_ARRAY_OF_INT));

        for (int i = 0; i < arrayLength; i++) {
            out.print(intArray[i] + " ");
        }

        out.close();
    }

    public static void generateNewArrayWithSameIntInTxt(int arrayLength) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(PATH_TO_FILE_WITH_ARRAY_OF_INT));

        for (int i = 0; i < arrayLength; i++) {
            out.println("100 ");
        }

        out.close();
    }

    public static void generateRevertSortedArrayInTxt(int arrayLength) throws IOException {
        IntNumber[] arrayOfInt = generateNewIntArray(arrayLength);
        Sorter.mergeSortComparable(arrayOfInt);
        PrintWriter out = new PrintWriter(new FileWriter(PATH_TO_FILE_WITH_ARRAY_OF_INT));

        for (int i = arrayLength - 1; i >= 0; i--) {
            out.print(arrayOfInt[i] + " ");
        }

        out.close();
    }

    public static IntNumber[] readArrayFromTxt(int arrayLength) throws FileNotFoundException {
        IntNumber[] arrayOfInt = new IntNumber[arrayLength];
        Scanner scanner = new Scanner(new File(PATH_TO_FILE_WITH_ARRAY_OF_INT));

        for (int i = 0; i < arrayLength; i++) {
            if (scanner.hasNext()) {
                arrayOfInt[i] = new IntNumber(scanner.nextInt());
            }
        }

        return arrayOfInt;
    }

    public static IntNumber[] generateNewIntArray(int arrayLength) {
        IntNumber[] arrayOfInt = new IntNumber[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            arrayOfInt[i] = new IntNumber(random.nextInt() / 2);
        }

        return arrayOfInt;
    }
}