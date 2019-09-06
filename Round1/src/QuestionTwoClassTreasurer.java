import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

import static java.lang.Math.max;

public class QuestionTwoClassTreasurer {
    static final int mod = 1000000007;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("class_treasurer.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("class_treasurer_output.txt"));

        String returnSentence = "Case #";

        int T = Integer.valueOf(br.readLine());
        for (int t = 0; t < T; t++) {
            int[] nodeAndEdgeNumber = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int n = nodeAndEdgeNumber[0];
            int k = nodeAndEdgeNumber[1];
            boolean[] changeArray = new boolean[n]; // true mean it need to be changed

            String studentVote = br.readLine();
            int cnt = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (studentVote.charAt(i) == ('A')) {
                    cnt -= 1;
                } else {
                    if (cnt == k) {
                        cnt -= 1;
                        changeArray[i] = true;
                    } else {
                        cnt += 1;
                    }
                }
                cnt = max(cnt, 0);
            }

            int cost = 0;
            int val = 1;
            for (int i = 0; i < n; i++) {
                val = (val * 2) % mod;
                if (changeArray[i]) {
                    cost = (cost + val) % mod;
                }
            }
            writer.write(String.format("%s%d: %d\n", returnSentence, t+1, cost));
        }
        writer.close();
    }
}
