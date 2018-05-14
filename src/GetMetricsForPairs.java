import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.regex.Pattern;

/**
 * Created by Farima on 5/14/2018.
 */
public class GetMetricsForPairs {
    static String pairsFileAddress="/lv_scratch/scratch/mondego/local/farima/new_oreo/sampling_for_precision_related/input_clone_pairs_file/IC_train_files/scc_cw_intersected_t2andnotcand_removed.txt";
    static String metricsFileAddress="/scratch/mondego/local/farima/new_oreo/recall_related/metricCalculator/SourcererCC/python_scripts/1_metric_output/mlcc_input.file";

    static String outputFileAddress="/lv_scratch/scratch/mondego/local/farima/new_oreo/sampling_for_precision_related/input_clone_pairs_file/IC_train_files/IC_train_clones_withmetrics.txt";

    public static void main(String[] args) {
        HashMap<String,String> methodMetricsMap=new HashMap();

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pairsFileAddress));
            PrintWriter printWriter = new PrintWriter(outputFileAddress);
            String line="";
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replace("\n", "").replace("\r", "");
                String[] lineSplitted=line.split(",");
                String pair1=lineSplitted[4]+","+lineSplitted[5]+","+lineSplitted[6]+","+lineSplitted[7];
                String pair2=lineSplitted[0]+","+lineSplitted[1]+","+lineSplitted[2]+","+lineSplitted[3];
                methodMetricsMap.put(pair1,"");
                methodMetricsMap.put(pair2,"");
            }

            bufferedReader=new BufferedReader(new FileReader(metricsFileAddress));
            while ((line=bufferedReader.readLine())!=null) {
                line = line.replace("\n", "").replace("\r", "");
                String[] lineSplitted=line.split((Pattern.quote("@#@")));
                String[] pairPartSplitted=lineSplitted[0].split(",");
                String pair=pairPartSplitted[0]+","+pairPartSplitted[1]+","+pairPartSplitted[2]+","+pairPartSplitted[3];
                String metricsPart=lineSplitted[1];
                if (methodMetricsMap.containsKey(pair)){
                    methodMetricsMap.put(pair,(metricsPart.replaceAll(",","~~")));
                }
            }
            bufferedReader = new BufferedReader(new FileReader(pairsFileAddress));
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replace("\n", "").replace("\r", "");
                String[] lineSplitted=line.split(",");
                String pair1=lineSplitted[4]+","+lineSplitted[5]+","+lineSplitted[6]+","+lineSplitted[7];
                String pair2=lineSplitted[0]+","+lineSplitted[1]+","+lineSplitted[2]+","+lineSplitted[3];
                printWriter.append(pair1+"~~"+pair2+"~~"+"1"+methodMetricsMap.get(pair1)+"~~"+methodMetricsMap.get(pair1));
            }
            printWriter.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
