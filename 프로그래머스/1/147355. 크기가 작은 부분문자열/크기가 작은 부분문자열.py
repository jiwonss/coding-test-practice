def solution(t, p):
    answer = 0
    n, m = len(t), len(p)
    for i in range(0, n - m + 1):
        if int(t[i:i + m]) <= int(p):
            answer += 1
    return answer