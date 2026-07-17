def solution(n, s):
    answer = []
    while s > 0 and n > 0:
        div, mod = divmod(s, n)
        if div == 0:
            return [-1]
        answer.append(div)
        s -= div
        n -= 1
    return sorted(answer)