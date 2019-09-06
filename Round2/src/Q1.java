import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("Q1_input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("Q1_output.txt"));

        String returnSentence = "Case #";

        int T = Integer.valueOf(br.readLine());
        for (int t = 1; t <= T; t++) {
            char suc = 'Y';

            //read k
            int[] input = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int k = input[2];

            //read teacher's location
            int[] teacherLocation = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int rTeacher = teacherLocation[0];
            int cTeacher = teacherLocation[1];

            //read k agent's location
            for (int i = 1; i <= k; i++) {
                int[] agentLocation = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
                int rAgent = agentLocation[0];
                int cAgent = agentLocation[1];
                if (k != 2 || (rTeacher + cTeacher) % 2 != (rAgent + cAgent) % 2) {
                    suc = 'N';
                }
            }
            writer.write(String.format("%s%d: %c\n", returnSentence, t, suc));
        }
        writer.close();
    }
}