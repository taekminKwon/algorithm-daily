import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[100001];
		int answer = -1;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {N, 0});
		while(!q.isEmpty()) {
			int[] target = q.poll();
			if(target[0] == K) {
				answer = target[1];
				break;
			}
			
			if(target[0] * 2 < 100001 && !visited[target[0] * 2]){
				q.add(new int[] {target[0] * 2, target[1] + 1});
                visited[target[0] * 2] = true;
			}
			if(target[0] > 0 && !visited[target[0] - 1]){
				q.add(new int[] {target[0] - 1, target[1] + 1});
                visited[target[0] - 1] = true;
            }
			if(target[0] < 100000 && !visited[target[0] + 1]){
				q.add(new int[] {target[0] + 1, target[1] + 1});
                visited[target[0] + 1] = true;
            }
		
		}
		
		System.out.print(answer);
	}
}
