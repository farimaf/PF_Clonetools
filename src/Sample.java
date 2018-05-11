import java.io.*;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;

/**
 * Created by Farima on 7/12/2017.
 */
public class Sample {

    public static void main(String[] args) {
      Sample sampler = new Sample();
//        sampler.sampleOneNode();
        sampler.sampleOneNodeByCount(18135188,62751);//number of either clones or nonclones is given
    }

    private String pathInput = "/lv_scratch/scratch/mondego/local/farima/new_oreo/sampling_for_precision_related/input_clone_pairs_file" +
            "/nonclones_type3_toolsunionfiltered.txt";
    private PrintWriter printWriter;

    Sample() {
        try {
            //linesCount=bufferedReader.lines().count();
            printWriter = new PrintWriter(Paths.get("/lv_scratch/scratch/mondego/local/farima/new_oreo/sampling_for_precision_related/" +
                    "input_clone_pairs_file/nonclones_sampled.txt").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sampleOneNodeByCount(int totalNumRows,int numSample){
        try {
            HashSet<Integer> randomLineNums=new HashSet<>();
            Random random = new Random(0);
            int randNumLine = 0;
            while (randomLineNums.size() < numSample ) {
                randNumLine = random.nextInt(totalNumRows);
                randomLineNums.add(randNumLine);
            }
            System.out.println(randomLineNums.size());
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathInput));
            String line = "";
            int lineNum = 0;
            while ((line = bufferedReader.readLine()) != null) {
            if (randomLineNums.contains(lineNum)) {
                printWriter.append(line + System.lineSeparator());
            }
            lineNum++;
            }
            System.out.println(lineNum);
            System.out.println("Write Complete " );
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
