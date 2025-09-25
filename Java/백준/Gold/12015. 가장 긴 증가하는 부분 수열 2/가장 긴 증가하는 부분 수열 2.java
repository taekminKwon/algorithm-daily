import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    static int[] list, arr;
	public static void main(String[] args) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(list_dp(N));
    }

    static int binarySearch(int l, int r, int target) {
        int mid;

        while (l < r) {
            mid = (l + r) / 2;
            if(list[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return r;
    }

    static int list_dp(int N) {
        list[0] = arr[0];

        int len = 1;
        for (int i = 1; i < N; i++) {
            if (list[len - 1] < arr[i]) {
                list[len++] = arr[i];
            }
            else if (list[len - 1] > arr[i]) {
                int idx = binarySearch(0, len - 1, arr[i]);
                list[idx] = arr[i];
            }
        }

        return len;
    }
}