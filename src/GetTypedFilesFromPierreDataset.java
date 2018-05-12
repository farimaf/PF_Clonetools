import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;

/**
 * Created by Farima on 5/11/2018.
 */
public class GetTypedFilesFromPierreDataset {

    static String pierreDatasetAddress="/scratch/mondego/local/farima/new_oreo/farima_maple/train";
    static String typedDataset="/scratch/mondego/local/farima/new_oreo/farima_maple/train/NODE_1/output6.0/type_3.1.csv";

    static String outputFileAddress="/scratch/mondego/local/farima/new_oreo/farima_maple/train/node1_type31.txt";
    //static String outputFileAddress="d:\\testfarima.txt";
    public static void main(String[] args) {
        String line = "";
        try {
            HashSet<String> pierreDataset = new HashSet<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pierreDatasetAddress));
            PrintWriter printWriter = new PrintWriter(outputFileAddress);

            while ((line = bufferedReader.readLine()) != null) {
                line = line.replace("\n", "").replace("\r", "");
                pierreDataset.add(line);
            }

            bufferedReader=new BufferedReader(new FileReader(typedDataset));
            while ((line=bufferedReader.readLine())!=null){
                line=line.replace("\n", "").replace("\r", "");
//                String[] lineColumns=line.split("~~");
//                String lineReverse=lineColumns[1]+"~~"+lineColumns[0];
//                if (pierreDataset.contains(lineColumns[0]+"~~"+lineColumns[1]) || pierreDataset.contains(lineReverse)){
//                    printWriter.append(line+System.lineSeparator());
//                }
                if (pierreDataset.contains(line)){
                    printWriter.append(line+System.lineSeparator());
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
