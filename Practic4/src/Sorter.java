import java.util.Comparator;

public class Sorter {

    public static Object[] selectionSorterComparator(Comparator comparator, Object[] objects) {
        for (int i = 0; i < objects.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < objects.length; j++)
                if (comparator.compare(objects[j], objects[minIndex]) < 0)
                    minIndex = j;
            Object temp = objects[minIndex];
            objects[minIndex] = objects[i];
            objects[i] = temp;
        }
        return objects;
    }

    public static Object[] bubbleSortComparator(Comparator comparator, Object[] objects) {
        for (int i = 0; i < objects.length - 1; i++) {
            for (int j = 0; j < objects.length - i - 1; j++) {
                if (comparator.compare(objects[j], objects[j + 1]) > 0) {
                    Object tempObject = objects[j];
                    objects[j] = objects[j + 1];
                    objects[j + 1] = tempObject;
                }
            }
        }
        return objects;
    }

    public static Comparable[] bubbleSortComparable(Comparable[] arrayOfStudents) {
        for (int i = 0; i < arrayOfStudents.length - 1; i++) {
            for (int j = 0; j < arrayOfStudents.length - i - 1; j++) {
                if (arrayOfStudents[j].compareTo(arrayOfStudents[j + 1]) > 0) {
                    Comparable tempComparable = arrayOfStudents[j];
                    arrayOfStudents[j] = arrayOfStudents[j + 1];
                    arrayOfStudents[j + 1] = tempComparable;
                }
            }
        }
        return arrayOfStudents;
    }

    public static Comparable[] selectionSortComparable(Comparable[] arrayOfStudents) {
        for (int i = 0; i < arrayOfStudents.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < arrayOfStudents.length; j++)
                if (arrayOfStudents[j].compareTo(arrayOfStudents[min_idx]) < 0)
                    min_idx = j;
            Comparable tempComparable = arrayOfStudents[min_idx];
            arrayOfStudents[min_idx] = arrayOfStudents[i];
            arrayOfStudents[i] = tempComparable;
        }
        return arrayOfStudents;
    }
}