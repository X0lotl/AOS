public class Sorter {
    public String[] sortStringArray(String[] inputStringArray) {
        int size = inputStringArray.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < inputStringArray.length; j++) {
                if (inputStringArray[i].compareTo(inputStringArray[j]) > 0) {
                    String temp = inputStringArray[i];
                    inputStringArray[i] = inputStringArray[j];
                    inputStringArray[j] = temp;
                }
            }
        }

        return inputStringArray;
    }
}
