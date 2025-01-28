def solution(answers):
    pattern = [[1, 2, 3, 4, 5], [2, 1, 2, 3, 2, 4, 2, 5], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    
    n = len(answers)
    result = {}
    for i, p in enumerate(pattern):
        cnt = 0
        for j in range(n):
            if answers[j] == p[j % len(p)]:
                cnt += 1
        result[i + 1] = cnt
    
    max_value = max(result.values())
    return [i + 1 for i in range(3) if result[i + 1] == max_value]