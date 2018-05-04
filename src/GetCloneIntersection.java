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
                type1ClonesSet.add(line.replace("\n", "").replace("\r", ""));
            }

            bufferedReader=new BufferedReader(new FileReader(bigFileAddress));
            while ((line=bufferedReader.readLine())!=null){
                line=line.replace("\n", "").replace("\r", "");
                String[] lineSplitted=line.split(",");
                String lineReverse=lineSplitted[4]+","+lineSplitted[5]+","+lineSplitted[6]+","+lineSplitted[7]+","+
                        lineSplitted[0]+","+lineSplitted[1]+","+lineSplitted[2]+","+lineSplitted[3];
                if (type1ClonesSet.contains(line) || type1ClonesSet.contains(lineReverse)){
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
