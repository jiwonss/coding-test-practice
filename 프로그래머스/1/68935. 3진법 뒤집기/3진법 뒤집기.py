def solution(n):
    result = []
    while n != 0:
        div, mod = divmod(n, 3)
        result.append(mod)
        n //= 3
    
    answer = 0
    result.reverse()
    for i in range(len(result)):
        answer += (3 ** i) * result[i]
    return answer