def solution(a, b, n):
    answer = 0
    while n >= a:
        div, mod = divmod(n, a)
        answer += (div * b)
        n = (div * b) + mod
    return answer