def solution(n, lost, reserve):
    clothes = {i : 1 for i in range(1, n + 1)}
    for r in reserve:
        clothes[r] += 1
    for l in lost:
        clothes[l] -= 1
        
    for l in sorted(lost):
        if clothes[l] == 1:
            continue
        pre, nxt = l - 1, l + 1
        if pre > 0 and clothes[pre] == 2:
            clothes[pre] -= 1
            clothes[l] += 1
        elif nxt <= n and clothes[nxt] == 2:
            clothes[nxt] -= 1
            clothes[l] += 1

    answer = 0
    for v in clothes.values():
        if v > 0:
            answer += 1
    return answer