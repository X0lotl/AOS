public class SortionMethodsTimeData {
    protected String name;
    protected double timeOfSorterFor1024IntArray;
    protected double timeOfSorterFor2048IntArray;
    protected double timeOfSorterFor4096IntArray;
    protected double timeOfSorterFor8192IntArray;
    protected double timeOfSorterFor16384IntArray;
    protected double timeOfSorterFor32768IntArray;


    public SortionMethodsTimeData(String name, double timeOfSorterFor1024IntArray, double timeOfSorterFor2048IntArray,
                                  double timeOfSorterFor4096IntArray, double timeOfSorterFor8192IntArray, double timeOfSorterFor16384IntArray, double timeOfSorterFor32768IntArray) {
        this.name = name;
        this.timeOfSorterFor1024IntArray = timeOfSorterFor1024IntArray;
        this.timeOfSorterFor2048IntArray = timeOfSorterFor2048IntArray;
        this.timeOfSorterFor4096IntArray = timeOfSorterFor4096IntArray;
        this.timeOfSorterFor8192IntArray = timeOfSorterFor8192IntArray;
        this.timeOfSorterFor16384IntArray = timeOfSorterFor16384IntArray;
        this.timeOfSorterFor32768IntArray = timeOfSorterFor32768IntArray;
    }

    @Override
    public String toString() {
        return "\n Name of sorter method: " + name +
                "; Time for 1024 = " + timeOfSorterFor1024IntArray +
                "; Time for 2048 = " + timeOfSorterFor2048IntArray +
                "; Time for 4096 = " + timeOfSorterFor4096IntArray +
                "; Time for 8192 = " + timeOfSorterFor8192IntArray +
                "; Time for 16384 = " + timeOfSorterFor16384IntArray +
                "; Time for 32768 = " + timeOfSorterFor32768IntArray + '\n';
    }
}
