import java.util.*;
import java.io.*;

public class Main{  
  public static void main (String args[]) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(in.readLine());
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(N);
    StringTokenizer st = new StringTokenizer(in.readLine());
    for(int i = 0; i < N; i++){
      int key = Integer.parseInt(st.nextToken());
      int count = 0;
      if(map.get(key)==null)
        count = 1;
      else
        count = map.get(key) + 1;
      map.put(key,count);
    }
    int M = Integer.parseInt(in.readLine());
    StringTokenizer st2 = new StringTokenizer(in.readLine());
    StringBuilder sb = new StringBuilder();
    while(M -->0){
      int key = Integer.parseInt(st2.nextToken());
      if(map.get(key)==null)
        sb.append('0');
      else
        sb.append(map.get(key));
      sb.append(' ');
    }
    System.out.print(sb);
    bw.flush();
    bw.close();
  }
}