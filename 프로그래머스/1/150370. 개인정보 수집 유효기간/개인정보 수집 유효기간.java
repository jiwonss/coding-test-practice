import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] today_split = today.split("\\.");
        int ty = Integer.parseInt(today_split[0]);
        int tm = Integer.parseInt(today_split[1]);
        int td = Integer.parseInt(today_split[2]);
        int today_result = ty * 12 * 28 + tm * 28 + td;
        
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] temp = term.split(" ");
            map.put(temp[0], Integer.parseInt(temp[1]) * 28);
        }
        
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        for (String privacy : privacies) {
            String[] temp = privacy.split(" ");
            
            String[] date = temp[0].split("\\.");
            String type = temp[1];
            
            int dy = Integer.parseInt(date[0]);
            int dm = Integer.parseInt(date[1]);
            int dd = Integer.parseInt(date[2]);
            
            int date_result = dy * 12 * 28 + dm * 28 + dd;
            if (date_result + map.get(type) <= today_result) {
                list.add(idx + 1);
            }
            idx++; 
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}