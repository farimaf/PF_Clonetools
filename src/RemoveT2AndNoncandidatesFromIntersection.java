import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.regex.Pattern;

/**
 * Created by Farima on 5/4/2018.
 */
public class RemoveT2AndNoncandidatesFromIntersection {

    static String icCandidatesFileAddress="/scratch/mondego/local/farima/tensorFlow/experiments/results/IC/candidates/ic_tp_totalcandidates.txt";
    //static String icCandidatesFileAddress="d:\\sample.txt";
    static String intersectionFileAddress="/lv_scratch/scratch/mondego/local/farima/new_oreo/sampling_for_precision_related/input_clone_pairs_file/nicad_scc_cw_alltypes_intersected.txt";
    static String outputFileAddress="/lv_scratch/scratch/mondego/local/farima/new_oreo/sampling_for_precision_related/input_clone_pairs_file/toolsintersected_t2andnotcand_removed.txt";
    //static String outputFileAddress="d:\\testfarima.txt";
    public static void main(String[] args) {
        try {
            HashSet<String> icCandidatesSet = new HashSet<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(icCandidatesFileAddress));
            PrintWriter printWriter = new PrintWriter(outputFileAddress);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                line=line.replace("\n", "").replace("\r", "");
                String[] lineTypeSplitted=line.split((Pattern.quote("#$#")));
                String type=lineTypeSplitted[0];
                String[] linePartsSplitted=lineTypeSplitted[1].split("~~");
                String candidatePair=linePartsSplitted[0]+","+linePartsSplitted[1];
                if (!type.equals("2")) {
                    icCandidatesSet.add(candidatePair);
                }
            }
            bufferedReader = new BufferedReader(new FileReader(intersectionFileAddress));
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replace("\n", "").replace("\r", "");
                String[] lineSplitted=line.split(",");
                String lineReverse=lineSplitted[4]+","+lineSplitted[5]+","+lineSplitted[6]+","+lineSplitted[7]+","+
                        lineSplitted[0]+","+lineSplitted[1]+","+lineSplitted[2]+","+lineSplitted[3];
                if (icCandidatesSet.contains(line) || icCandidatesSet.contains(lineReverse)){
                    printWriter.append(line+System.lineSeparator());
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
