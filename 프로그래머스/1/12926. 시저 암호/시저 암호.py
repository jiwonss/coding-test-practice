def solution(s, n):
    answer = list(s)
    for i in range(len(s)):
        if s[i].islower():
            answer[i] = chr((ord(s[i]) - ord('a') + n) % 26 + ord('a'))
        if s[i].isupper():
            answer[i] = chr((ord(s[i]) - ord('A') + n) % 26 + ord('A'))
    return ''.join(answer)