import java.util.HashMap;
import java.util.function.Consumer;

public class SortionMethodsTimeData {
    protected String name;
    protected Consumer<Comparable[]> sortionMethod;
    protected HashMap<Integer, Double> hashMapForTimeFromArraySize;


    public SortionMethodsTimeData(String name, Consumer<Comparable[]> sortionMethod, HashMap<Integer, Double> hashMapForTimeFromArraySize) {
        this.name = name;
        this.sortionMethod = sortionMethod;
        this.hashMapForTimeFromArraySize = hashMapForTimeFromArraySize;
    }


    @Override
    public String toString() {
        return "\n Name of sortion method: " + name +
                hashMapForTimeFromArraySize.toString() +
                '\n';
    }
}