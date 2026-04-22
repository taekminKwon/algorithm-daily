import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] counts = new int[26];
        word = word.toUpperCase();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            counts[c - 'A']++;
        }

        int max = 0;
        int maxIndex = 0;
        boolean isEqual = false;
        for (int i = 0; i < 26; i++) {
            if (max == counts[i]) {
                isEqual = true;
            }

            if (max < counts[i]) {
                isEqual = false;
                maxIndex = i;
                max = counts[i];
            }
        }

        if (isEqual) {
            System.out.println("?");
        } else {
            System.out.println((char) ('A' + maxIndex));
        }
    }
}