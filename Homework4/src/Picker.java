import java.io.IOException;

public class Picker {
    interface PickVariationOfArray {
        void pick(int arrayLength);
    }

    interface PickMethod {
        void pick(IntNumber[] arrayOfInt);
    }

    public static PickVariationOfArray[] arrayVariations = new PickVariationOfArray[]{
            new PickVariationOfArray() {
                @Override
                public void pick(int arrayLength) {
                    try {
                        ArrayGenerator.generateNewRandomArrayInTxt(arrayLength);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            },

            new PickVariationOfArray() {
                @Override
                public void pick(int arrayLength) {
                    try {
                        ArrayGenerator.generateSortedArrayInTxt(arrayLength);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            },

            new PickVariationOfArray() {
                @Override
                public void pick(int arrayLength) {
                    try {
                        ArrayGenerator.generateRevertSortedArrayInTxt(arrayLength);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            },

            new PickVariationOfArray() {
                @Override
                public void pick(int arrayLength) {
                    try {
                        ArrayGenerator.generateNewArrayWithSameIntInTxt(arrayLength);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

    };

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
}
