def solution(k, m, score):
    answer = 0
    score = sorted(score)[::-1]
    for i in range(0, len(score) - m + 1, m):
        answer += min(score[i:i + m]) * m
    return answer