import java.util.Comparator;

public class Sorter {
    public static Object[] mergeSortComparator(Comparator comparator, Object[] arrayOfObjects) {
        int lengthOfArray = arrayOfObjects.length;

        if (lengthOfArray < 2) {
            return arrayOfObjects;
        }

        int midIndex = lengthOfArray / 2;
        Object[] leftHalfArray = new Comparable[midIndex];
        Object[] rightHalfArray = new Comparable[lengthOfArray - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalfArray[i] = arrayOfObjects[i];
        }

        for (int i = midIndex; i < lengthOfArray; i++) {
            rightHalfArray[i - midIndex] = arrayOfObjects[i];
        }

        mergeSortComparator(comparator, leftHalfArray);
        mergeSortComparator(comparator, rightHalfArray);

        int leftLength = leftHalfArray.length;
        int rightLength = rightHalfArray.length;

        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (comparator.compare(leftHalfArray[i], rightHalfArray[j]) <= 0) {
                arrayOfObjects[k] = leftHalfArray[i];
                i++;
            } else {
                arrayOfObjects[k] = rightHalfArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            arrayOfObjects[k] = leftHalfArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            arrayOfObjects[k] = rightHalfArray[j];
            j++;
            k++;
        }

        return arrayOfObjects;
    }

    public static Comparable[] mergeSortComparable(Comparable[] arrayOfComparable) {
        int lengthOfArray = arrayOfComparable.length;

        if (lengthOfArray < 2) {
            return arrayOfComparable;
        }

        int midIndex = lengthOfArray / 2;

        Comparable[] leftHalfArray = new Comparable[midIndex];
        Comparable[] rightHalfArray = new Comparable[lengthOfArray - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalfArray[i] = arrayOfComparable[i];
        }

        for (int i = midIndex; i < lengthOfArray; i++) {
            rightHalfArray[i - midIndex] = arrayOfComparable[i];
        }

        mergeSortComparable(leftHalfArray);
        mergeSortComparable(rightHalfArray);

        int leftLength = leftHalfArray.length;
        int rightLength = rightHalfArray.length;

        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (leftHalfArray[i].compareTo(rightHalfArray[j]) <= 0) {
                arrayOfComparable[k] = leftHalfArray[i];
                i++;
            } else {
                arrayOfComparable[k] = rightHalfArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            arrayOfComparable[k] = leftHalfArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            arrayOfComparable[k] = rightHalfArray[j];
            j++;
            k++;
        }

        return arrayOfComparable;
    }

    public static Object[] quickSortComparator(Comparator comparator, Object[] arrayOfObjects, int minIndex, int maxIndex) {
        Object pivot = arrayOfObjects[minIndex + (maxIndex - minIndex) / 2];
        int i = minIndex;
        int j = maxIndex;

        while (i <= j) {
            while (comparator.compare(arrayOfObjects[i], pivot) < 0) {
                i++;
            }

            while (comparator.compare(arrayOfObjects[j], pivot) > 0) {
                j--;
            }

            if (i <= j) {
                Switcher.swap(arrayOfObjects, i, j);
                i++;
                j--;
            }
        }

        if (minIndex < j)
            quickSortComparator(comparator, arrayOfObjects, minIndex, j);
        if (i < maxIndex)
            quickSortComparator(comparator, arrayOfObjects, i, maxIndex);

        return arrayOfObjects;
    }

    public static Comparable[] quickSortComparable(Comparable[] arrayOfComparable, int minIndex, int maxIndex) {
        Comparable pivot = arrayOfComparable[minIndex + (maxIndex - minIndex) / 2];
        int i = minIndex;
        int j = maxIndex;

        while (i <= j) {
            while (arrayOfComparable[i].compareTo(pivot) < 0) {
                i++;
            }

            while (arrayOfComparable[j].compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                Switcher.swap(arrayOfComparable, i, j);
                i++;
                j--;
            }
        }

        if (minIndex < j)
            quickSortComparable(arrayOfComparable, minIndex, j);
        if (i < maxIndex)
            quickSortComparable(arrayOfComparable, i, maxIndex);

        return arrayOfComparable;
    }

    public static Object[] shellSortComparator(Comparator comparator, Object[] arrayOfObjects) {
        for (int gap = arrayOfObjects.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arrayOfObjects.length; i++) {
                Object tempObject = arrayOfObjects[i];
                int j;

                for (j = i; j >= gap && comparator.compare(arrayOfObjects[j - gap], tempObject) > 0; j -= gap) {
                    arrayOfObjects[j] = arrayOfObjects[j - gap];
                }

                arrayOfObjects[j] = tempObject;
            }
        }

        return arrayOfObjects;
    }

    public static Comparable[] shellSortComparable(Comparable[] arrayOfComparable) {
        for (int gap = arrayOfComparable.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arrayOfComparable.length; i++) {
                Comparable tempComparable = arrayOfComparable[i];
                int j;

                for (j = i; j >= gap && arrayOfComparable[j - gap].compareTo(tempComparable) > 0; j -= gap) {
                    arrayOfComparable[j] = arrayOfComparable[j - gap];
                }

                arrayOfComparable[j] = tempComparable;
            }
        }

        return arrayOfComparable;
    }

    public static Object[] combSortComparator(Comparator comparator, Object[] arrayOfObjects) {
        int gap = arrayOfObjects.length;
        boolean isSwapped = true;
        while (gap > 1 || isSwapped) {
            if (gap > 1) {
                gap = (int) (gap / 1.3);
            }
            isSwapped = false;

            for (int i = 0; i < arrayOfObjects.length - gap; i++) {
                if (comparator.compare(arrayOfObjects[i], arrayOfObjects[i + gap]) > 0) {
                    Switcher.swap(arrayOfObjects, i, i + gap);
                    isSwapped = true;
                }
            }
        }

        return arrayOfObjects;
    }

    public static Comparable[] combSortComparable(Comparable[] arrayOfComparable) {
        int gap = arrayOfComparable.length;
        boolean isSwapped = true;

        while (gap > 1 || isSwapped) {
            if (gap > 1) {
                gap = (int) (gap / 1.3);
            }
            isSwapped = false;

            for (int i = 0; i < arrayOfComparable.length - gap; i++) {
                if (arrayOfComparable[i].compareTo(arrayOfComparable[i + gap]) > 0) {
                    Switcher.swap(arrayOfComparable, i, i + gap);
                    isSwapped = true;
                }
            }
        }

        return arrayOfComparable;
    }

    public static Object[] insertionSortComparator(Comparator comparator, Object[] arrayOfObjects) {
        for (int i = 1; i < arrayOfObjects.length; i++) {
            Object key = arrayOfObjects[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(key, arrayOfObjects[j]) < 0) {
                Switcher.swap(arrayOfObjects, j, j + 1);
                j--;
            }
        }

        return arrayOfObjects;
    }

    public static Comparable[] insertionSortComparable(Comparable[] arrayOfComparable) {
        for (int i = 1; i < arrayOfComparable.length; i++) {
            Comparable key = arrayOfComparable[i];
            int j = i - 1;

            while (j >= 0 && key.compareTo(arrayOfComparable[j]) < 0) {
                Switcher.swap(arrayOfComparable, j, j + 1);
                j--;
            }
        }

        return arrayOfComparable;
    }

    public static Object[] selectionSorterComparator(Comparator comparator, Object[] arrayOfObjects) {
        for (int i = 0; i < arrayOfObjects.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arrayOfObjects.length; j++) {
                if (comparator.compare(arrayOfObjects[j], arrayOfObjects[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Switcher.swap(arrayOfObjects, minIndex, i);
        }

        return arrayOfObjects;
    }

    public static Comparable[] selectionSortComparable(Comparable[] arrayOfComparable) {
        for (int i = 0; i < arrayOfComparable.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arrayOfComparable.length; j++) {
                if (arrayOfComparable[j].compareTo(arrayOfComparable[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            Switcher.swap(arrayOfComparable, minIndex, i);
        }

        return arrayOfComparable;
    }

    public static Object[] bubbleSortComparator(Comparator comparator, Object[] arrayOfSObjects) {
        for (int i = 0; i < arrayOfSObjects.length - 1; i++) {
            for (int j = 0; j < arrayOfSObjects.length - i - 1; j++) {
                if (comparator.compare(arrayOfSObjects[j], arrayOfSObjects[j + 1]) > 0) {
                    Switcher.swap(arrayOfSObjects, j, j + 1);
                }
            }
        }

        return arrayOfSObjects;
    }

    public static Comparable[] bubbleSortComparable(Comparable[] arrayOfComparable) {
        for (int i = 0; i < arrayOfComparable.length - 1; i++) {
            for (int j = 0; j < arrayOfComparable.length - i - 1; j++) {
                if (arrayOfComparable[j].compareTo(arrayOfComparable[j + 1]) > 0) {
                    Switcher.swap(arrayOfComparable, j, j + 1);
                }
            }
        }

        return arrayOfComparable;
    }
}