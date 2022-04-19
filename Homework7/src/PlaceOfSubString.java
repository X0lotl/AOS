public class PlaceOfSubString {
    protected int numberOfStringInFile;
    protected int indexOFStartOfSubStringInFile;
    public PlaceOfSubString(int numberOfStringInFile, int indexOFStartOfSubStringInFile) {
        this.numberOfStringInFile = numberOfStringInFile;
        this.indexOFStartOfSubStringInFile = indexOFStartOfSubStringInFile;
    }

    @Override
    public String toString() {
        return "{ " + numberOfStringInFile + " , " + indexOFStartOfSubStringInFile + " }\n";
    }
}
