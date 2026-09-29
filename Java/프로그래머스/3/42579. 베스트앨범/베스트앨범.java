import java.util.*;

class Solution {
    static Map<String, Integer> map;
    public int[] solution(String[] genres, int[] plays) {
        PriorityQueue<Music> pq = new PriorityQueue<>();
        map = new HashMap<>();
        Map<String, Integer> genrePlays = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            map.put(genre, map.getOrDefault(genre, 0) + plays[i]);
        }
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            pq.add(new Music(i, genre, plays[i]));
        }
        
        List<Music> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            Music next = pq.poll();
            if (genrePlays.getOrDefault(next.genre, 0) >= 2) {
                continue;
            }
            
            list.add(next);
            genrePlays.put(next.genre, genrePlays.getOrDefault(next.genre, 0) + 1);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).index;
        }
        
        return answer;
    }
    
    class Music implements Comparable<Music> {
        int index;
        String genre;
        int play;
        
        Music (int index, String genre, int play) {
            this.index = index;
            this.genre = genre;
            this.play = play;
        }
        
        public int compareTo(Music m) {
            if (map.get(genre) != map.get(m.genre)) {
                return Integer.compare(map.get(m.genre), map.get(genre));
            }
            
            if (play != m.play) {
                return Integer.compare(m.play, play);
            }
            
            return Integer.compare(index, m.index);
        }
    }
}