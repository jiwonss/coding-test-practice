from collections import defaultdict

def solution(survey, choices):
    result = defaultdict(int)
    score = [0, 3, 2, 1, 0, 1, 2, 3]
    for s, c in zip(survey, choices):
        if c < 4:
            result[s[0]] += score[c]
        if c > 4:
            result[s[1]] += score[c]
    
    p_type = ["RT", "CF", "JM", "AN"]
    answer = ''
    for i in range(4):
        p = p_type[i]
        a, b = result[p[0]], result[p[1]]
        if a >= b:
            answer += p[0]
        else:
            answer += p[1]
    return answer