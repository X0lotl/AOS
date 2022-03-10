public class SorterMethods{
    protected String name;
    protected double timeOfSorterFor1024IntArray;
    protected double timeOfSorterFor2048IntArray;
    protected double timeOfSorterFor4096IntArray;
    protected double timeOfSorterFor16384IntArray;
    protected double timeOfSorterFor32768IntArray;

    @Override
    public String toString(){
        return "Name of sorter method: "+ name +
                "\n Time for 1024: " + timeOfSorterFor1024IntArray +
                "\n Time for 2048: " + timeOfSorterFor2048IntArray +
                "\n Time for 4096: " + timeOfSorterFor4096IntArray +
                "\n Time for 16384: " + timeOfSorterFor16384IntArray +
                "\n Time for 32768: " + timeOfSorterFor32768IntArray;
    }
}
