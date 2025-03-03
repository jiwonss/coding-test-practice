def solution(elements):
    n = len(elements)
    answer = set()
    for size in range(1, n + 1):
        cur_sum = sum(elements[:size])
        answer.add(cur_sum)
        for i in range(n):
            cur_sum -= elements[i]
            cur_sum += elements[(i + size) % n]
            answer.add(cur_sum)
    return len(answer)