def solution(s):
    answer = 0
    x, cnt = '', [0, 0]
    for c in s:
        if cnt[0] == cnt[1]:
            answer += 1
            x = c
        if c == x:
            cnt[0] += 1
        else:
            cnt[1] += 1
    return answer