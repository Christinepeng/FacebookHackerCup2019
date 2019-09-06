import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.ArrayList;

public class QuestionOneGraphsAsAService {
    static final int INF = 1000000 * 50;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("graphs_as_a_service.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("graphs_output.txt"));

        String returnSentence = "Case #";

        int T = Integer.valueOf(br.readLine());
        for (int t = 0; t < T; t++) {
            int[] nodeAndEdgeNumber = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            int n = nodeAndEdgeNumber[0];
            int m = nodeAndEdgeNumber[1];

            ArrayList<int[]> nodesMinEdgeArray = new ArrayList<>();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = INF;
                }
            }

            for (int j = 0; j < m; j++) {
                int[] nodesMinEdge = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
                nodesMinEdgeArray.add(nodesMinEdge);

                int u = nodesMinEdge[0] - 1;
                int v = nodesMinEdge[1] - 1;
                int d = nodesMinEdge[2];
                matrix[u][v] = matrix[v][u] = d;
            }

            //create Floyd-Warshall matrix
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
                            matrix[i][j] = matrix[i][k] + matrix[k][j];
                        }
                    }
                }
            }

            //compare input with Floyd-Warshall matrix
            boolean suc = true;
            for (int[] nodesMinEdge : nodesMinEdgeArray) {
                int u = nodesMinEdge[0] - 1;
                int v = nodesMinEdge[1] - 1;
                int d = nodesMinEdge[2];
                if (matrix[u][v] != d) {
                    suc = false;
                }
            }

            if (suc) {
                writer.write(String.format("%s%d: %d\n", returnSentence, t+1, m));
                for (int[] nodesMinEdge : nodesMinEdgeArray) {
                    int u = nodesMinEdge[0];
                    int v = nodesMinEdge[1];
                    int d = nodesMinEdge[2];
                    writer.write(String.format("%d %d %d\n", u, v, d));
                }
            } else {
                writer.write(String.format("%s%d: Impossible\n", returnSentence, t+1));
            }

        }
        writer.close();
    }
}
