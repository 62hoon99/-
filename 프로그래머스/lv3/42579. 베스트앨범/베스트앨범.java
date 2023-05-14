import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {        
        List<Album> albums = new ArrayList<>();
        
        for (int i = 0; i < genres.length; i++) {
            albums.add(new Album(genres[i], plays[i], i));    
        }
        
        Map<String, Integer> totalPlays = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
        }
        int[] totalPlaysArr = new int[totalPlays.size()];
        int idx = 0;
        for (String key : totalPlays.keySet()) {
            totalPlaysArr[idx++] = totalPlays.get(key);
        }
        Arrays.sort(totalPlaysArr);
        
        idx = 0;
        String[] orderedGenres = new String[totalPlays.size()];

        for (int i = totalPlaysArr.length - 1; i >= 0; i--) {
            for (String key : totalPlays.keySet()) {
                if (totalPlaysArr[i] == totalPlays.get(key)) {
                    orderedGenres[idx++] = key;
                    break;
                }
            }
        }
        
        
        Map<String, List<Album>> albumMap = new HashMap();
        for (Album album : albums) {
            if (!albumMap.containsKey(album.getGenre())) {
                albumMap.put(album.getGenre(), new ArrayList<>());
            }
            albumMap.get(album.getGenre()).add(album);
        }
        for (String key : albumMap.keySet()) {
            Collections.sort(albumMap.get(key));
        }
        
        List<Integer> answerList = new ArrayList<>();
        
        for (int i = 0; i < orderedGenres.length; i++) {
            List<Album> values = albumMap.get(orderedGenres[i]);
            if (values.size() > 1) {
                answerList.add(values.get(0).getKey());
                answerList.add(values.get(1).getKey());
            } else {
                answerList.add(values.get(0).getKey());
            }
        }
        
        int[] answer = new int[answerList.size()];
        idx = 0;
        for (int num : answerList) {
            answer[idx++] = num;
        }
        
        return answer;
    }
    
    static class Album implements Comparable<Album>{
        private String genre;
        private int play;
        private int key;
        
        Album(String genre, int play, int key) {
            this.genre = genre;
            this.play = play;
            this.key = key;
        }
        
        String getGenre() {
            return genre;
        }
        
        int getPlay() {
            return play;
        }
        
        int getKey() {
            return key;
        }
        
        @Override
        public int compareTo(Album o) {
            return o.play == this.play ? this.key - o.key : o.play - this.play;
        }
    }
}