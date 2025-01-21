def solution(s):
    answer = list(s)
    idx = 0
    for i in range(len(s)):
        if s[i] == ' ':
            idx = 0
            continue
        if idx % 2 == 0:
            answer[i] = answer[i].upper()
        else:
            answer[i] = answer[i].lower()
        idx += 1
    return ''.join(answer)