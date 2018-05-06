import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;

/**
 * Created by Farima on 5/6/2018.
 */
public class GetCloneUnion {
    static String smallFileAddress="/lv_scratch/scratch/mondego/local/farima/new_oreo/sampling_for_precision_related/input_clone_pairs_file/nicad_clone_pairs.txt";
    static String bigFileAddress="/lv_scratch/scratch/mondego/local/farima/new_oreo/sampling_for_precision_related/input_clone_pairs_file/scc_clone_pairs.txt";

    static String outputFileAddress="/lv_scratch/scratch/mondego/local/farima/new_oreo/sampling_for_precision_related/input_clone_pairs_file/nicad_scc_union.txt";
    //static String outputFileAddress="d:\\testfarima.txt";
    public static void main(String[] args) {
        String line = "";
        try {
            HashSet<String> smallCloneSet = new HashSet<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(smallFileAddress));
            PrintWriter printWriter = new PrintWriter(outputFileAddress);

            while ((line = bufferedReader.readLine()) != null) {
                line = line.replace("\n", "").replace("\r", "");
                smallCloneSet.add(line);
                printWriter.append(line);
            }

            bufferedReader=new BufferedReader(new FileReader(bigFileAddress));
            while ((line=bufferedReader.readLine())!=null){
                line=line.replace("\n", "").replace("\r", "");
                String[] lineSplitted=line.split(",");
                String lineReverse=lineSplitted[4]+","+lineSplitted[5]+","+lineSplitted[6]+","+lineSplitted[7]+","+
                        lineSplitted[0]+","+lineSplitted[1]+","+lineSplitted[2]+","+lineSplitted[3];
                if (!smallCloneSet.contains(line) && !smallCloneSet.contains(lineReverse)){
                    printWriter.append(line+System.lineSeparator());
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
