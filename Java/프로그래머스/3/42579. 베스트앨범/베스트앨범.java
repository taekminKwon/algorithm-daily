import java.util.*;

class Solution {
    static class Music implements Comparable<Music> {
        public int play;
        public int index;
        
        @Override
        public int compareTo(Music m1) {
            if(this.play == m1.play) {
                return this.index - m1.index;
            }
            
            return m1.play - this.play;
        }
        
        Music(int play, int index) {
            this.play = play;
            this.index = index;
        }
    }
    
    public List<Integer> solution(String[] genres, int[] plays) {
        Map<String, PriorityQueue<Music>> map = new HashMap<>();
        Map<String, Integer> genrePlays = new HashMap<>();
        List<String> list = new ArrayList<>();
    
        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) {
                PriorityQueue<Music> pq = new PriorityQueue<>();
                
                pq.add(new Music(plays[i], i));
                map.put(genres[i], pq);
                genrePlays.put(genres[i], plays[i]);
                list.add(genres[i]);
                continue;
            }
            
            map.get(genres[i]).add(new Music(plays[i], i));
            genrePlays.put(genres[i], plays[i] + genrePlays.get(genres[i]));
        }
        
        Collections.sort(list, (o1, o2) -> {
            return genrePlays.get(o2) - genrePlays.get(o1);
        });
        
        List<Integer> answer = new ArrayList<>();
        for (String genre : list) {
            PriorityQueue<Music> pq = map.get(genre);
            int count = 0;
            while(!pq.isEmpty() && count < 2) {
                answer.add(pq.poll().index);
                count++;
            }
        }
    
        
        return answer;
    }
}