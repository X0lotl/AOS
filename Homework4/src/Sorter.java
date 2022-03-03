import java.util.Comparator;
import java.util.Random;

public class Sorter {

    public static Object[] swap(Object[] array, int index1, int index2){
        Object tempComparable = array[index1];
        array[index2] = array[index1];
        array[index1] = tempComparable;

        return array;
    }

    public static Comparable[] swap(Comparable[] array, int index1, int index2){
        Comparable tempComparable = array[index1];
        array[index2] = array[index1];
        array[index1] = tempComparable;

        return array;
    }

    public static Comparable[] quickSortComparable(Comparable[] arrayOfStudents) {
        int minIndex = 0;
        int maxIndex = arrayOfStudents.length - 1;

        if (minIndex >= maxIndex) {
            return arrayOfStudents;
        }

        int pivotIndex = new Random().nextInt(maxIndex - minIndex) + minIndex;
        Comparable pivot = arrayOfStudents[pivotIndex];
        Comparable tempComparable = arrayOfStudents[pivotIndex];
        arrayOfStudents[pivotIndex] = arrayOfStudents[maxIndex];
        arrayOfStudents[maxIndex] = tempComparable;

        int leftPointer = minIndex;
        int rightPointer = maxIndex;

        while(leftPointer < rightPointer){

            while (arrayOfStudents[leftPointer].compareTo(pivot) <= 0 && leftPointer < rightPointer){
                leftPointer++;
            }

            while (arrayOfStudents[rightPointer].compareTo(pivot) >= 0 && leftPointer < rightPointer){
                rightPointer++;
            }


        }

        //tempComparable

        return arrayOfStudents;
    }

    public static Object[] shellSortComparator(Comparator comparator, Object[] arrayOfStudentsObject) {
        for (int gap = arrayOfStudentsObject.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arrayOfStudentsObject.length; i++) {
                Object tempObject = arrayOfStudentsObject[i];
                int j;

                for (j = i; j >= gap && comparator.compare(arrayOfStudentsObject[j - gap], tempObject) > 0; j -= gap) {
                    arrayOfStudentsObject[j] = arrayOfStudentsObject[j - gap];
                }

                arrayOfStudentsObject[j] = tempObject;
            }
        }

        return arrayOfStudentsObject;
    }

    public static Comparable[] shellSortComparable(Comparable[] arrayOfStudents) {
        for (int gap = arrayOfStudents.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arrayOfStudents.length; i++) {
                Comparable tempComparable = arrayOfStudents[i];
                int j;

                for (j = i; j >= gap && arrayOfStudents[j - gap].compareTo(tempComparable) > 0; j -= gap) {
                    arrayOfStudents[j] = arrayOfStudents[j - gap];
                }

                arrayOfStudents[j] = tempComparable;
            }
        }

        return arrayOfStudents;
    }

    public static Comparable[] combSortComparable(Comparable[] arrayOfStudents) {
        int gap = arrayOfStudents.length;
        boolean isSwapped = true;

        while (gap > 1 || isSwapped) {
            if (gap > 1) {
                gap = (int) (gap / 1.3);
            }
            isSwapped = false;

            for (int i = 0; i < arrayOfStudents.length - gap; i++) {
                if (arrayOfStudents[i].compareTo(arrayOfStudents[i + gap]) > 0) {
                    Comparable tempComparable = arrayOfStudents[i];
                    arrayOfStudents[i] = arrayOfStudents[i + gap];
                    arrayOfStudents[i + gap] = tempComparable;
                    isSwapped = true;
                }
            }
        }

        return arrayOfStudents;
    }

    public static Object[] combSortComparator(Comparator comparator, Object[] arrayOfStudentsObject) {
        int gap = arrayOfStudentsObject.length;
        boolean isSwapped = true;
        while (gap > 1 || isSwapped) {
            if (gap > 1) {
                gap = (int) (gap / 1.3);
            }
            isSwapped = false;

            for (int i = 0; i < arrayOfStudentsObject.length - gap; i++) {
                if (comparator.compare(arrayOfStudentsObject[i], arrayOfStudentsObject[i + gap]) > 0) {
                    Object tempObject = arrayOfStudentsObject[i];
                    arrayOfStudentsObject[i] = arrayOfStudentsObject[i + gap];
                    arrayOfStudentsObject[i + gap] = tempObject;
                    isSwapped = true;
                }
            }
        }

        return arrayOfStudentsObject;
    }

    public static Comparable[] insertionSortComparable(Comparable[] arrayOfStudents) {
        for (int i = 1; i < arrayOfStudents.length; i++) {
            Comparable key = arrayOfStudents[i];
            int j = i - 1;

            while (j >= 0 && key.compareTo(arrayOfStudents[j]) < 0) {
                Comparable tempComparable = arrayOfStudents[j];
                arrayOfStudents[j] = arrayOfStudents[j + 1];
                arrayOfStudents[j + 1] = tempComparable;
                j--;
            }
        }

        return arrayOfStudents;
    }

    public static Object[] insertionSortComparator(Comparator comparator, Object[] arrayOfStudentsObjects) {
        for (int i = 1; i < arrayOfStudentsObjects.length; i++) {
            Object key = arrayOfStudentsObjects[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(key, arrayOfStudentsObjects[j]) < 0) {
                Object tempComparable = arrayOfStudentsObjects[j];
                arrayOfStudentsObjects[j] = arrayOfStudentsObjects[j + 1];
                arrayOfStudentsObjects[j + 1] = tempComparable;
                j--;
            }
        }

        return arrayOfStudentsObjects;
    }

    public static Comparable[] selectionSortComparable(Comparable[] arrayOfStudentsObjects) {
        for (int i = 0; i < arrayOfStudentsObjects.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arrayOfStudentsObjects.length; j++)
                if (arrayOfStudentsObjects[j].compareTo(arrayOfStudentsObjects[minIndex]) < 0)
                    minIndex = j;
            Comparable tempComparable = arrayOfStudentsObjects[minIndex];
            arrayOfStudentsObjects[minIndex] = arrayOfStudentsObjects[i];
            arrayOfStudentsObjects[i] = tempComparable;
        }

        return arrayOfStudentsObjects;
    }

    public static Object[] selectionSorterComparator(Comparator comparator, Object[] arrayOfStudentsObjects) {
        for (int i = 0; i < arrayOfStudentsObjects.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arrayOfStudentsObjects.length; j++)
                if (comparator.compare(arrayOfStudentsObjects[j], arrayOfStudentsObjects[minIndex]) < 0){
                    minIndex = j;
                }
            swap(arrayOfStudentsObjects, minIndex, i);
            Object temp = arrayOfStudentsObjects[minIndex];
            arrayOfStudentsObjects[minIndex] = arrayOfStudentsObjects[i];
            arrayOfStudentsObjects[i] = temp;
        }

        return arrayOfStudentsObjects;
    }

    public static Object[] bubbleSortComparator(Comparator comparator, Object[] arrayOfStudentsObjects) {
        for (int i = 0; i < arrayOfStudentsObjects.length - 1; i++) {
            for (int j = 0; j < arrayOfStudentsObjects.length - i - 1; j++) {
                if (comparator.compare(arrayOfStudentsObjects[j], arrayOfStudentsObjects[j + 1]) > 0) {
                    swap(arrayOfStudentsObjects, j, j + 1);
                }
            }
        }

        return arrayOfStudentsObjects;
    }

    public static Comparable[] bubbleSortComparable(Comparable[] arrayOfStudents) {
        for (int i = 0; i < arrayOfStudents.length - 1; i++) {
            for (int j = 0; j < arrayOfStudents.length - i - 1; j++) {
                if (arrayOfStudents[j].compareTo(arrayOfStudents[j + 1]) > 0) {
                    swap(arrayOfStudents, j, j + 1);
                }
            }
        }

        return arrayOfStudents;
    }
}