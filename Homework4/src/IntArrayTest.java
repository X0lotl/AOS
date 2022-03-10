import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class IntArrayTest {

    interface PickMethod {
        void pick(IntNumber[] arrayOfInt);
    }

    public static PickMethod[] pickMethods = new PickMethod[]{
            new PickMethod() {
                @Override
                public void pick(IntNumber[] arrayOfInt) {
                    Sorter.mergeSortComparable(arrayOfInt);
                }
            },

            new PickMethod() {
                @Override
                public void pick(IntNumber[] arrayOfInt) {
                    Sorter.quickSortComparable(arrayOfInt, 0, arrayOfInt.length - 1);
                }

            },

            new PickMethod() {
                @Override
                public void pick(IntNumber[] arrayOfInt) {
                    Sorter.combSortComparable(arrayOfInt);
                }
            },

            new PickMethod() {
                @Override
                public void pick(IntNumber[] arrayOfInt) {
                    Sorter.insertionSortComparable(arrayOfInt);
                }
            },

            new PickMethod() {
                @Override
                public void pick(IntNumber[] arrayOfInt) {
                    Sorter.bubbleSortComparable(arrayOfInt);
                }
            },

            new PickMethod() {
                @Override
                public void pick(IntNumber[] arrayOfInt) {
                    Sorter.bubbleSortComparable(arrayOfInt);
                }
            },

            new PickMethod() {
                @Override
                public void pick(IntNumber[] arrayOfInt) {
                    Sorter.selectionSortComparable(arrayOfInt);
                }
            },

            new PickMethod() {
                @Override
                public void pick(IntNumber[] arrayOfInt) {
                    Sorter.shellSortComparable(arrayOfInt);
                }
            }
    };

    public static void main(String[] args) throws IOException {
        HashMap<String, Double> sorterMethodsTime = new HashMap<>();

        IntNumber[] arrayOfInt;

        /*
         uncomment next strings to chose witch methods you want to use
         */

        //generateNewRandomArrayInTxt();

        ArrayGenerator.generateRevertSortedArrayInTxt();

        //generateNewArrayWithSameIntINTxt();

        //generateSortedArrayInTxt();


        arrayOfInt = ArrayGenerator.readArrayFromTxt();
        System.out.println("Your array before sorting: " + Arrays.toString(arrayOfInt));

        Timer timer = new Timer();
        Double time;

        for(int i = 0; i < pickMethods.length; i++){
            timer.stopWatchAtStart();
            pickMethods[i].pick(arrayOfInt);
            time = timer.getElapsedTime();
            sorterMethodsTime.put(String.valueOf(i),time);
        }

        System.out.println("\nSorter methods times: " + sorterMethodsTime);
    }
}