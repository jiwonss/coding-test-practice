def solution(word):
    answer = 0
    for i, w in enumerate(word):
        answer += "AEIOU".index(w) * ((5 ** (5 - i) - 1) // 4) + 1
    return answer