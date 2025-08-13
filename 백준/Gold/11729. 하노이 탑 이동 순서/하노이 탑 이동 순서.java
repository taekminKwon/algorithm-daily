import java.util.*;
import java.io.*;

public class Main {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  public static void hanoi(int N, int full, int empty, int last){    
    if(N==1){
      sb.append(Integer.toString(full) + " " + Integer.toString(last) + '\n');
      return;
    }
    hanoi(N-1,full,last,empty);
    sb.append(Integer.toString(full) + " " + Integer.toString(last) + '\n');
    hanoi(N-1,empty,full,last);
  }

  public static void main(String args[]) throws IOException {
    int n = Integer.parseInt(in.readLine());
    System.out.println((int)Math.pow(2,n)-1);
    hanoi(n,1,2,3);
    System.out.print(sb);
  }
}