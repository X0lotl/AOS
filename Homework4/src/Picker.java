import java.io.IOException;

public class Picker {
    static SortionMethodsTimeData[] sortionMethodsTimeData = IntArrayTest.getSortionMethodsTimeDataArray();

    interface PickAddTimeToArrayOfTimeData {
        void add(int indexOfMethod, double time);
    }

    interface PickVariationOfArray {
        void pick(int arrayLength);
    }

    interface PickReturnOfMethodsArrayData {
        double pick(int i);
    }

    interface PickMethod {
        void pick(IntNumber[] arrayOfInt);
    }

    interface addSortionMethods {
        void addSortionMethod(SortionMethodsTimeData newSortionMethodTimeData);
    }

    static addSortionMethods addSortionMethod = new addSortionMethods() {
        @Override
        public void addSortionMethod(SortionMethodsTimeData newSortionMethodTimeData) {
            PickMethod[] temp = pickMethods;
            pickMethods = new PickMethod[temp.length + 1];
            System.arraycopy(temp,0,pickMethods,0,temp.length - 1);
            pickMethods[temp.length] = (PickMethod) newSortionMethodTimeData;
        }
    };

    public static PickAddTimeToArrayOfTimeData[] addTimeToArrayOfTimeData = new PickAddTimeToArrayOfTimeData[]{
            new PickAddTimeToArrayOfTimeData() {
                @Override
                public void add(int indexOfMethod, double time) {
                    sortionMethodsTimeData[indexOfMethod].timeOfSorterFor1024IntArray = time;
                }
            },

            new PickAddTimeToArrayOfTimeData() {
                @Override
                public void add(int indexOfMethod, double time) {
                    sortionMethodsTimeData[indexOfMethod].timeOfSorterFor2048IntArray = time;
                }
            },

            new PickAddTimeToArrayOfTimeData() {
                @Override
                public void add(int indexOfMethod, double time) {
                    sortionMethodsTimeData[indexOfMethod].timeOfSorterFor4096IntArray = time;
                }
            },

            new PickAddTimeToArrayOfTimeData() {
                @Override
                public void add(int indexOfMethod, double time) {
                    sortionMethodsTimeData[indexOfMethod].timeOfSorterFor8192IntArray = time;
                }
            },

            new PickAddTimeToArrayOfTimeData() {
                @Override
                public void add(int indexOfMethod, double time) {
                    sortionMethodsTimeData[indexOfMethod].timeOfSorterFor16384IntArray = time;
                }
            },

            new PickAddTimeToArrayOfTimeData() {
                @Override
                public void add(int indexOfMethod, double time) {
                    sortionMethodsTimeData[indexOfMethod].timeOfSorterFor32768IntArray = time;
                }
            }
    };

    public static PickReturnOfMethodsArrayData[] returnArrayTimeData = new PickReturnOfMethodsArrayData[]{
            new PickReturnOfMethodsArrayData() {
                @Override
                public double pick(int i) {
                    return sortionMethodsTimeData[i].timeOfSorterFor1024IntArray;
                }
            },

            new PickReturnOfMethodsArrayData() {
                @Override
                public double pick(int i) {
                    return sortionMethodsTimeData[i].timeOfSorterFor2048IntArray;
                }
            },

            new PickReturnOfMethodsArrayData() {
                @Override
                public double pick(int i) {
                    return sortionMethodsTimeData[i].timeOfSorterFor4096IntArray;
                }
            },

            new PickReturnOfMethodsArrayData() {
                @Override
                public double pick(int i) {
                    return sortionMethodsTimeData[i].timeOfSorterFor8192IntArray;
                }
            },

            new PickReturnOfMethodsArrayData() {
                @Override
                public double pick(int i) {
                    return sortionMethodsTimeData[i].timeOfSorterFor16384IntArray;
                }
            },

            new PickReturnOfMethodsArrayData() {
                @Override
                public double pick(int i) {
                    return sortionMethodsTimeData[i].timeOfSorterFor32768IntArray;
                }
            }
    };

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