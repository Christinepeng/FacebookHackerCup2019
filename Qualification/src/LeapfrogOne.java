import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class LeapfrogOne {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("leapfrog_ch_.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("Leapfrog_outputOne.txt"));


        String returnSentence = "Case #";
        int count = 1;

        int T = Integer.valueOf(br.readLine());
        for (int i = 0; i < T; i++) {
            String st = br.readLine();
            int countBeta = 0;
            int countDot = 0;
            for (Character s : st.toCharArray()) {
                if (s.equals('B')) {
                    countBeta++;
                } else if (s.equals('.')) {
                    countDot++;
                }
            }

            if (countBeta < countDot) {
                writer.write(returnSentence + count + ": N" + "\n");
                count++;
            } else {
                if (countDot == 0) {
                    writer.write(returnSentence + count + ": N" + "\n");
                    count++;
                } else {
                    writer.write(returnSentence + count + ": Y" + "\n");
                    count++;
                }
            }
        }
        writer.close();
    }
}
