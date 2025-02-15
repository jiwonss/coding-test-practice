def solution(n, w, num):
    div, mod = divmod(num - 1, w)
    x = 0
    if div % 2 == 0:
        x = w - mod
    else:
        x = mod + 1
    
    step = [x * 2 - 1, w * 2 - (x * 2 - 1)]
    
    answer = 0
    while num < n:
        if div % 2 == 0:
            num += step[0]
        else:
            num += step[1]
        div += 1
        answer += 1

    if num == n:
        answer += 1
    return answer