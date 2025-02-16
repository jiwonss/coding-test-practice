from itertools import combinations

def solution(n, q, ans):
    m = len(q)
    answer = 0
    for c in combinations([i for i in range(1, n + 1)], 5):
        for i in range(m):
            if len(set(q[i]) & set(c)) != ans[i]:
                break
        else:
            answer += 1       
    return answer