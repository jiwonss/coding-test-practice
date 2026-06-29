def solution(players, m, k):
    server = [0] * (len(players) + k)
    count, answer = 0, 0
    
    for time, player in enumerate(players):
        count -= server[time]
        
        n = player // m
        if count < n:
            diff = n - count
            
            answer += diff
            count += diff
            server[time + k] += diff
            
    return answer