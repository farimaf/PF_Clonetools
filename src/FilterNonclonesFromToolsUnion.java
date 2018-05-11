import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;

/**
 * Created by Farima on 5/10/2018.
 */
public class FilterNonclonesFromToolsUnion {
    static String unionFileAddress="/lv_scratch/scratch/mondego/local/farima/new_oreo/sampling_for_precision_related/input_clone_pairs_file/alltools_union.txt";
    static String nonclonesFileAddress="/scratch/mondego/local/farima/tensorFlow/experiments/results/IC/TN/predictions/nonclonepairs_type3.txt";

    static String outputFileAddress="/lv_scratch/scratch/mondego/local/farima/new_oreo/sampling_for_precision_related/input_clone_pairs_file/nonclones_type3_toolsunionfiltered.txt";
    //static String outputFileAddress="d:\\testfarima.txt";
    public static void main(String[] args) {
        String line = "";
        try {
        HashSet<String> unionSet = new HashSet<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(unionFileAddress));
        PrintWriter printWriter = new PrintWriter(outputFileAddress);

        while ((line = bufferedReader.readLine()) != null) {
            line = line.replace("\n", "").replace("\r", "");
            unionSet.add(line);
        }

        bufferedReader=new BufferedReader(new FileReader(nonclonesFileAddress));
        while ((line=bufferedReader.readLine())!=null){
            line=line.replace("\n", "").replace("\r", "");
            String[] lineSplitted=line.split(",");
            String lineReverse=lineSplitted[4]+","+lineSplitted[5]+","+lineSplitted[6]+","+lineSplitted[7]+","+
                    lineSplitted[0]+","+lineSplitted[1]+","+lineSplitted[2]+","+lineSplitted[3];
            if (!unionSet.contains(line) && !unionSet.contains(lineReverse)){
                printWriter.append(line+System.lineSeparator());
            }
        }
    }
        catch (Exception e){
        e.printStackTrace();
    }
    }
}
