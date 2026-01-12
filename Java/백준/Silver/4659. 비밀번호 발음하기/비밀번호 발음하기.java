import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static char[] vowel = {'a', 'e', 'i', 'o', 'u'};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String word = br.readLine();
            if (word.equals("end")) {
                break;
            }

            buildWord(checkRule(word), word);
        }

        System.out.println(sb);
    }

    static boolean checkRule(String word) {
        return hasVowel(word) && !hasThreeStreak(word) && !hasTwoStreakWithoutEEorOO(word);
    }

    private static boolean hasTwoStreakWithoutEEorOO(String word) {
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) != 'o' && word.charAt(i) != 'e' && word.charAt(i) == word.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasThreeStreak(String word) {
        for (int i = 0; i < word.length() - 2; i++) {
            if (
                (isVowel(word.charAt(i)) && isVowel(word.charAt(i + 1)) && isVowel(word.charAt(i + 2))) ||
                (!isVowel(word.charAt(i)) && !isVowel(word.charAt(i + 1)) && !isVowel(word.charAt(i + 2)))
            ) {
                return true;
            }
        }

        return false;
    }

    static boolean isVowel(char c) {
        for (int i = 0; i < vowel.length; i++) {
            if (c == vowel[i]) {
                return true;
            }
        }

        return false;
    }

    static boolean hasVowel(String word) {
        return word.contains("a") || word.contains("e") || word.contains("i") || word.contains("o") || word.contains("u");
    }

    static void buildWord(boolean isAcceptable,String word) {
        sb.append('<').append(word).append('>');
        if (isAcceptable) {
            sb.append(" is acceptable.\n");
            return;
        }

        sb.append(" is not acceptable.\n");
    }
}
