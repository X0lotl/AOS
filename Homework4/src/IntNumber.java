public class IntNumber implements Comparable<IntNumber> {
    protected int number;

    public IntNumber(int number){
        this.number = number;
    }

    @Override
    public int compareTo(IntNumber that) {
        return this.number - that.number;
    }
    @Override
    public String toString(){
        return "" + number;
    }
}