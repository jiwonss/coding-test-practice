def solution(keymap, targets):
    key = {chr(i) : 101 for i in range(ord('A'), ord('Z') + 1)}
    for k in keymap:
        for i in range(len(k)):
            v = k[i]
            key[v] = min(key[v], i + 1)
    
    answer = []    
    for target in targets:
        cnt = 0
        for t in target:
            if key[t] == 101:
                cnt = -1
                break
            cnt += key[t]
        answer.append(cnt)
    return answer