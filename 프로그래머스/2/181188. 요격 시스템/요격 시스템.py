def solution(targets):
    targets.sort(key=lambda x:x[1])
    
    shot, answer = -1, 0
    for s, e in targets:
        if shot <= s:
            answer += 1
            shot = e
    return answer