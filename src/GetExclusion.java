import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.regex.Pattern;

/**
 * Created by Farima on 5/13/2018.
 */
public class GetExclusion {
    static String mainFileAdress = "/lv_scratch/scratch/mondego/local/farima/new_oreo/farima_maple/onemodel_randfor_th60.txt";
    //static String toBeExcludedAddress="d:\\sample.txt";
    static String toBeExcludedAddress = "/lv_scratch/scratch/mondego/local/farima/new_oreo/farima_maple/twomodels_randfor_60th.txt";
    static String outputFileAddress = "/lv_scratch/scratch/mondego/local/farima/new_oreo/farima_maple/onemodel_without2models.txt";

    //static String outputFileAddress="d:\\testfarima.txt";
    public static void main(String[] args) {
        String line = "";
        try {
            HashSet<String> tobeExcludedSet = new HashSet<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(toBeExcludedAddress));
            PrintWriter printWriter = new PrintWriter(outputFileAddress);

            while ((line = bufferedReader.readLine()) != null) {
                tobeExcludedSet.add(line.replace("\n", "").replace("\r", ""));
            }
            bufferedReader = new BufferedReader(new FileReader(mainFileAdress));
            while ((line = bufferedReader.readLine()) != null) {
                line = line.replace("\n", "").replace("\r", "");
                String[] lineSplitted = line.split(",");
                String lineReverse = lineSplitted[4] + "," + lineSplitted[5] + "," + lineSplitted[6] + "," + lineSplitted[7] + "," +
                        lineSplitted[0] + "," + lineSplitted[1] + "," + lineSplitted[2] + "," + lineSplitted[3];
                if (!tobeExcludedSet.contains(line) && !tobeExcludedSet.contains(lineReverse)) {
                    printWriter.append(line + System.lineSeparator());
                }

            }
        } catch (Exception e) {
            System.out.println(line);
            System.out.println(line.length());
            e.printStackTrace();
        }
    }
}
