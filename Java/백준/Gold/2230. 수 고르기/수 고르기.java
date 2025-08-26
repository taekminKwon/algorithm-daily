import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);
        int minIndex = 0;
        int maxIndex = 0;
        int answer = Integer.MAX_VALUE;
        boolean isLooped = true;
        boolean isEnd = false;
        while(isLooped) {
            isLooped = false;
            while (!isEnd && maxIndex < N && numbers[maxIndex] - numbers[minIndex] < M) {
                isLooped = true;
                maxIndex++;
                if(maxIndex == N) {
                    isEnd = true;
                    maxIndex--;
                }
            }

            while (minIndex <= maxIndex && numbers[maxIndex] - numbers[minIndex] >= M) {
                isLooped = true;
                answer = Math.min(numbers[maxIndex] - numbers[minIndex], answer);
                minIndex++;
            }
        }
        System.out.println(answer);
    }
}