import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] infix = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> icp = new HashMap<>();
        Map<Character, Integer> isp = new HashMap<>();
        setIcpAndISP(icp, isp);

        for (char c : infix) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                if (c == ')') {
                    while (!stack.isEmpty()) {
                        char s = stack.pop();
                        if (s == '(') {
                            break;
                        }
                        sb.append(s);
                    }
                } else {
                    while (!stack.isEmpty() && icp.get(c) <= isp.get(stack.peek())) {
                        char s = stack.pop();
                        sb.append(s);
                    }
                    stack.push(c);
                }
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        System.out.println(sb);
    }

    static void setIcpAndISP(Map<Character, Integer> icp, Map<Character, Integer> isp) {
        icp.put('(', 3);
        icp.put('*', 2);
        icp.put('/', 2);
        icp.put('+', 1);
        icp.put('-', 1);

        isp.put('(', 0);
        isp.put('*', 2);
        isp.put('/', 2);
        isp.put('+', 1);
        isp.put('-', 1);
    }
}
