import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class IntArrayTest {
    private static void generateNewArrayInTxt() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("IntArray.txt"));
        Random random = new Random();
        for(int i = 0; i < 40000; i++){
            out.println(random.nextInt());
        }
    }

    private static void readArrayFromTxt(IntNumber[] arrayOfInt, int arrayLength, String txtSource){
        arrayOfInt = new IntNumber[arrayLength];
        Scanner scanner = new Scanner(txtSource);
        for(int i = 0; i < arrayLength - 1; i++){
            if(scanner.hasNext()){
                arrayOfInt[i] = new IntNumber(scanner.nextInt());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        IntNumber[] arrayOfInt = new IntNumber[0];
        //generateNewArrayInTxt();
        readArrayFromTxt(arrayOfInt, 1024, "IntArray.txt");
    }
}
