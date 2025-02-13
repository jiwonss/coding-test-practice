def solution(bandage, health, attacks):
    t, x, y = bandage
    end_time = attacks[-1][0] + 1
    
    idx, cnt, hp = 0, 0, health
    for time in range(1, end_time):
        if time == attacks[idx][0]:
            cnt = 0
            hp -= attacks[idx][1]
            if hp <= 0:
                return -1

            idx += 1
            if idx >= len(attacks):
                return hp
        else:
            hp += x
            
            cnt += 1
            if cnt == t:
                hp += y
                cnt = 0 
                
        if hp > health:
            hp = health                
    return hp