def solution(n, m, section):
    answer = 0
    idx = section[0]
    for s in section:
        if idx <= s:
            idx = s + m
            answer += 1
    return answer