import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class IntArrayTest {
    private static void generateNewArrayInTxt() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("IntArray.txt"));
        Random random = new Random();
        for(int i = 0; i < 40000; i++){
            out.print(random.nextInt() + " ");
        }
    }

    private static IntNumber[] readArrayFromTxt(int arrayLength, String txtSource) throws FileNotFoundException {
        IntNumber[] arrayOfInt = new IntNumber[arrayLength];
        Scanner scanner = new Scanner(new File(txtSource));
        int tempInt;

        for(int i = 0; i < arrayLength; i++){
            if(scanner.hasNext()){
                arrayOfInt[i] = new IntNumber(scanner.nextInt());
            }
        }

        return arrayOfInt;
    }

    private static IntNumber[] generateNewIntArray(int arrayLength){
        IntNumber[] arrayOfInt = new IntNumber[arrayLength];
        Random random = new Random();
        for(int i = 0; i < arrayLength; i++){
            arrayOfInt[i] = new IntNumber(random.nextInt());
        }

        return arrayOfInt;
    }

    public static void main(String[] args) throws IOException {
        IntNumber[] arrayOfInt;
        //generateNewArrayInTxt();
        arrayOfInt = readArrayFromTxt(10, "IntArray.txt");
        //arrayOfInt = generateNewIntArray(1024);

        System.out.println("Your array before sorting: " + Arrays.toString(arrayOfInt));

        Sorter.mergeSortComparable(arrayOfInt);
        System.out.println('\n' + "Your array is sorted through merge sorter: \n" + Arrays.toString(arrayOfInt));

    }
}
