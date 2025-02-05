def solution(survey, choices):
    result = [{"R" : 0, "T" : 0}, {"C" : 0, "F" : 0}, {"J" : 0, "M" : 0}, {"A" : 0, "N" : 0}]
    number = {"RT" : 0, "TR" : 0, "CF" : 1, "FC" : 1, "JM" : 2, "MJ" : 2, "AN" : 3, "NA" : 3 }
    score = [0, 3, 2, 1, 0, 1, 2, 3]
    
    for i in range(len(survey)):
        c, s = choices[i], survey[i]
        idx = number[s]
        if c < 4:
            result[idx][s[0]] += score[c]
        if c > 4:
            result[idx][s[1]] += score[c]
    
    answer = ''
    for i in range(4):
        a, b = result[i].items()
        if a[1] >= b[1]:
            answer += a[0]
        else:
            answer += b[0]
    return answer