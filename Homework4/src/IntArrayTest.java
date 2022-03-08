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
        IntNumber[] arrayOfInt = {
                new IntNumber(0),
                new IntNumber(2),
                new IntNumber(10),
                new IntNumber(1000),
                new IntNumber(-1000),
                new IntNumber(76187)
        };
        IntNumber[] tempArrayOfIntForSorters;

        //generateNewArrayInTxt();

        //arrayOfInt = generateNewIntArray(1024);

       // arrayOfInt = readArrayFromTxt(1024, "IntArray.txt");

        System.out.println("Your array before sorting: " + Arrays.toString(arrayOfInt));

        Timer timer = new Timer();
        Double time;

        tempArrayOfIntForSorters = arrayOfInt;
        timer.stopWatchAtStart();
        Sorter.mergeSortComparable(tempArrayOfIntForSorters);
        time = timer.getElapsedTime();
        System.out.println('\n' + "Your array is sorted through merge sorter: \n" + Arrays.toString(tempArrayOfIntForSorters));
        System.out.println("Merge sorter time: " + time);

        tempArrayOfIntForSorters = arrayOfInt;
        timer.stopWatchAtStart();
        Sorter.quickSortComparable(tempArrayOfIntForSorters,0, tempArrayOfIntForSorters.length - 1);
        time = timer.getElapsedTime();
        System.out.println('\n' + "Your array is sorted through quick sorter: \n" + Arrays.toString(tempArrayOfIntForSorters));
        System.out.println("Quick sorter time: " + time);

        tempArrayOfIntForSorters = arrayOfInt;
        timer.stopWatchAtStart();
        Sorter.combSortComparable(tempArrayOfIntForSorters);
        time = timer.getElapsedTime();
        System.out.println('\n' + "Your array is sorted through comb sorter: \n" + Arrays.toString(tempArrayOfIntForSorters));
        System.out.println("Comb sorter time: " + time);
    }
}