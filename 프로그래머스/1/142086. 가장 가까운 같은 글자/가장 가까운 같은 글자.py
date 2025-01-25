def solution(s):
    answer = []
    alphabet = {chr(i + 97) : -1 for i in range(26)}
    for i in range(len(s)):
        if alphabet[s[i]] != -1:
            answer.append(i - alphabet[s[i]])
        else:
            answer.append(-1)
        alphabet[s[i]] = i 
    return answer