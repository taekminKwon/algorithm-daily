import java.util.*;
class Word {
    String word;
    int depth;
    
    public Word(String word, int depth) {
        this.word = word;
        this.depth = depth;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(begin, 0));
        
        while(!queue.isEmpty()) {
            Word poll = queue.poll();
            if (poll.word.equals(target)) {
                return poll.depth;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) {
                    continue;
                }
                
                int count = 0;
                for (int j = 0; j < poll.word.length(); j++) {
                    if (words[i].charAt(j) == poll.word.charAt(j)) {
                        count++;
                    }
                }
                
                if (count == poll.word.length() - 1) {
                    queue.add(new Word(words[i], poll.depth + 1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
}