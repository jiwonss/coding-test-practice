import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> userIdx = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            userIdx.put(id_list[i], i);
        }
        
        Map<String, List<String>> log = new HashMap<>();
        for (String id : id_list) {
            log.put(id, new ArrayList<>());
        }
        
        for (String r : report) {
            String[] temp = r.split(" ");
            List<String> list = log.get(temp[1]);
            if (list.contains(temp[0])) continue;
            list.add(temp[0]);
            log.put(temp[1], list);
        }
        
        int[] answer = new int[id_list.length];
        for (Map.Entry entry : log.entrySet()) {
            String key = (String) entry.getKey();
            List<String> value = (List<String>) entry.getValue();
            
            if (value.size() < k) continue;
            
            for (int i = 0; i < value.size(); i++) {
                answer[userIdx.get(value.get(i))] += 1;
            }           
        }
        return answer;
    }
}