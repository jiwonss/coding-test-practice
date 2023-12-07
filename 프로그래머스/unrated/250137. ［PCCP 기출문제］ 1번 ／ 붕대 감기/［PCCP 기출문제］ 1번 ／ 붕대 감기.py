def solution(bandage, health, attacks):
    t, x, y = bandage
    end_time = attacks[-1][0] + 1
    idx, cnt, answer = 0, 0, health
    for time in range(end_time):
        if time == attacks[idx][0]:
            answer -= attacks[idx][1]
            if answer <= 0:
                return -1
            idx += 1
            if idx >= len(attacks): 
                break
            cnt = 0
        else:
            cnt += 1
            answer += x
            if cnt == t:
                cnt = 0
                answer += y
        if answer > health:
            answer = health
    return answer
    
    
