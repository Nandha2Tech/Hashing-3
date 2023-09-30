import java.util.*;

// Time Complexity : O(m*n) m is the number of users and n is the number of songs
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

public class FavouriteGenres {
         public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
            HashMap<String, List<String>> result = new HashMap<>();;
            HashMap<String,String> songToGenreMap = new HashMap<>();

            for(String genre : genreMap.keySet()){   //O(n)
                List<String> songs = genreMap.get(genre);
                for(String song : songs){
                    songToGenreMap.put(song,genre);
                }
            }
            HashMap<String, Integer> countMap;
            for(String user : userMap.keySet()){    //O(m)
                int max = 0;
                countMap = new HashMap<>();
                result.put(user, new ArrayList<>());
                List<String> songs = userMap.get(user);
                for(String song: songs){    //O(n)
                    String genre = songToGenreMap.get(song);
                    countMap.put(genre, countMap.getOrDefault(genre,0)+1);
                    max = Math.max(max,countMap.get(genre));
                }
                for(String genre: countMap.keySet()){
                    if(countMap.get(genre) == max){
                        result.get(user).add(genre);
                    }
                }

            }
            return result;
        }

        public static void main(String[] args) {
            HashMap<String, List<String>> userSongs = new HashMap<>();

            userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));

            userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));

            HashMap<String, List<String>> songGenres = new HashMap<>();

            songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));

            songGenres.put("Dubstep", Arrays.asList(new String[]{"song7"}));

            songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));

            songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));

            songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));

            Map<String, List<String>> res = favoritegenre(userSongs, songGenres);

            System.out.println(res);
        }

    }
