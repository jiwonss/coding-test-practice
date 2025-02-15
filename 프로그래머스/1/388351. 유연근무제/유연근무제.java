import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int[] day = new int[7];
        int idx = 0;
        for (int i = startday - 1; i < startday + 7 - 1; i++) {
            day[idx++] = i % 7 + 1;
        }
        
        int[] limit = new int[schedules.length];
        for (int i = 0; i < schedules.length; i++) {
            if ((schedules[i] + 10) % 100 < 60) {
                limit[i] = schedules[i] + 10;
            } else {
                int div = (int) (schedules[i] + 10) / 100;
                int mod = (int) (schedules[i] + 10) % 100;
                limit[i] = (div + 1) * 100 + (mod % 60);
            }
        }

        int answer = 0;
        for (int i = 0; i < timelogs.length; i++) {
            boolean check = false;
            for (int j = 0; j < 7; j++) {
                if (day[j] == 6 || day[j] == 7) continue;
                if (timelogs[i][j] > limit[i]) {
                    check = true;
                    break;
                }
            }
            if (!check) answer ++; 
        }
        return answer;
    }
}