import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> friendsIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            friendsIdx.put(friends[i], i);
        }
        
        int[][] giftsLog = new int[n][n];
        for (String gift : gifts) {
            String[] temp = gift.split(" ");
            giftsLog[friendsIdx.get(temp[0])][friendsIdx.get(temp[1])] += 1;
        }
        
        int[] giftsIndex = new int[n];
        for (int i = 0; i < n; i++) {
            int give = 0; int take = 0;
            for (int j = 0; j < n; j++) {
                give += giftsLog[i][j];
                take += giftsLog[j][i];
            }
            giftsIndex[i] = give - take;
        }
        
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (giftsLog[i][j] < giftsLog[j][i]) continue;
                
                if (giftsLog[i][j] > giftsLog[j][i]) {
                    count[i]++;
                } else {
                    if (giftsIndex[i] > giftsIndex[j]) {
                        count[i]++;
                    }
                }
            }
        }
        
        int answer = 0;
        for (int c : count) {
            answer = Math.max(answer, c);
        }
        return answer;
    }
}