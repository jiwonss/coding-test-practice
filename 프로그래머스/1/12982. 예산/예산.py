def solution(d, budget):
    answer = 0
    for cost in sorted(d):
        budget -= cost
        if budget < 0:
            break
        answer += 1
    return answer