class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0]; int x = bandage[1]; int y = bandage[2];
        int endTime = attacks[attacks.length - 1][0] + 1;
        
        int hp = health; int idx = 0; int cnt = 0;
        for (int time = 1; time < endTime; time++) {
            if (time == attacks[idx][0]) {
                cnt = 0;
                
                hp -= attacks[idx++][1];
                if (hp <= 0) return -1;
                
                if (idx >= attacks.length) return hp;
            } else {
                hp += x;
                
                cnt += 1;
                if (cnt == t) {
                    hp += y;
                    cnt = 0;
                }
            }
            
            if (hp > health) hp = health;
        }
        return hp;
    }
}