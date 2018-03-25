import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

/**
 * Created by Farima on 3/25/2018.
 */
public class GetCloneIntersection {
    static String smallFileAddress="D:\\type1.txt";
    static String bigFileAddress="D:\\type1and2.txt";
    static String intersetionFileAddress="D:\\type2.txt";
    public static void main(String[] args) {
        try {
            HashSet<String> type1ClonesSet=new HashSet<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(smallFileAddress));
            PrintWriter printWriter=new PrintWriter(intersetionFileAddress);
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                type1ClonesSet.add(line);
            }

            bufferedReader=new BufferedReader(new FileReader(bigFileAddress));
            while ((line=bufferedReader.readLine())!=null){
                if (type1ClonesSet.contains(line)){
                    printWriter.append(line+System.lineSeparator());
                }
            }
            printWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
