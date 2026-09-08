import java.util.*;

class Solution {
    static Map<String, Integer> genrePlays = new HashMap<>();
    static int[] playList;
    
    static class Music implements Comparable<Music> {
        int number;
        String genre;
        int play;
        
        public Music(int number, String genre, int play) {
            this.number = number;
            this.genre = genre;
            this.play = play;
        }
        
        @Override
        public int compareTo(Music music) {
            if (genre.equals(music.genre)) {
                if (play == music.play) {
                    return Integer.compare(number, music.number);
                } else {
                    return Integer.compare(music.play, play);
                }
            } else {
                return Integer.compare(genrePlays.get(music.genre), genrePlays.get(genre));
            }
        }
        
        public String toString() {
            return "number : " + number
                + ", genre : " + genre
                + ", play : " + play;
        }
    }
    
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        playList = plays;
        PriorityQueue<Music> pq = new PriorityQueue<>();
        
        for (int i = 0; i < genres.length; i++) {
            genrePlays.put(genres[i], genrePlays.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        for (int i = 0; i < genres.length; i++) {
            pq.add(new Music(i, genres[i], plays[i]));
        }
        
        while(!pq.isEmpty()) {
            int size = answer.size();
            Music next = pq.poll();
            String nextGenre = genres[next.number];
            System.out.println(next + " ");
            if (size < 2 || (size >= 2 && !genres[answer.get(size - 2)].equals(nextGenre))) {
                answer.add(next.number);
            }
        }
        return answer;
    }
}