import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        int cur, nxt;
        String temp;
        for (int i = 0; i < callings.length; i++) {
            cur = map.get(callings[i]); nxt = cur - 1;
            
            map.put(players[cur], nxt);
            map.put(players[nxt], cur);
            
            temp = players[cur];
            players[cur] = players[nxt];
            players[nxt] = temp;
        }
        return players;
    }
}