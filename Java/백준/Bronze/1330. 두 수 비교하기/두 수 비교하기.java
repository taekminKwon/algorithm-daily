import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        if (Integer.parseInt(s1[0]) > Integer.parseInt(s1[1])) {
            System.out.println(">");
        } else if (Integer.parseInt(s1[0]) < Integer.parseInt(s1[1])) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }
    }
}