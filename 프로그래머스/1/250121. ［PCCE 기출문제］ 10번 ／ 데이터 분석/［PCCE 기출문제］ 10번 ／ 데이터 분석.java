import java.util.*;

class Solution {
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0); map.put("date", 1);
        map.put("maximum", 2); map.put("remain", 3);
        
        List<int[]> list = new ArrayList<>();
        for (int[] d : data) {
            if (d[map.get(ext)] < val_ext) {
                list.add(d);
            }
        }
        
        list.sort((a, b) -> Integer.compare(a[map.get(sort_by)], b[map.get(sort_by)]));
        return list.toArray(new int[0][]);
    }
}