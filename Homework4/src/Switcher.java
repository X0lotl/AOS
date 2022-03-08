public class Switcher {
    public static void swap(Object[] array, int index1, int index2) {
        Object tempComparable = array[index1];
        array[index1] = array[index2];
        array[index2] = tempComparable;

    }

    public static void swap(Comparable[] array, int index1, int index2) {
        Comparable tempComparable = array[index1];
        array[index1] = array[index2];
        array[index2] = tempComparable;

    }
}
