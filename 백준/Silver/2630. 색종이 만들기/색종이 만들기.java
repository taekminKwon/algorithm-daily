import java.util.*;
import java.io.*;

public class Main {
    static int whitePaper, bluePaper;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int paperSize = Integer.parseInt(br.readLine());
        whitePaper = 0;
        bluePaper = 0;
        paper = new int[paperSize][paperSize];
        for (int i = 0; i < paperSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < paperSize; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        recursion(paperSize, new int[]{0, 0});
        System.out.println(whitePaper);
        System.out.println(bluePaper);
    }
    
    static void recursion(int paperSize, int[] point) {
        if(paperSize == 0) {
            return;
        }

        boolean isBlue = true;
        boolean isWhite = true;
        for (int i = point[0]; i < point[0] + paperSize; i++) {
            for (int j = point[1]; j < point[1] + paperSize; j++) {
                if(paper[i][j] == 0) {
                    isBlue = false;
                } else {
                    isWhite = false;
                }
            }
        }

        if(isBlue) {
            bluePaper++;
        } else if(isWhite) {
            whitePaper++;
        } else {
            for (int i = 0; i < 4; i++) {
                recursion(paperSize / 2, new int[]{point[0] + (i / 2) * (paperSize / 2), point[1] + (i % 2) * (paperSize / 2)});
            }
        }
    }
}