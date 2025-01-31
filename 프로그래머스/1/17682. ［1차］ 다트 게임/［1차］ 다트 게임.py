import re

def solution(dartResult):
    bonus = {"S" : 1, "D" : 2, "T" : 3}
    option = {"" : 1, "*" : 2, "#" : -1}
    
    p = re.compile("(\d+)([SDT])([*#])?")
    result = p.findall(dartResult)
    
    answer = [0, 0, 0]
    for i in range(3):
        if i > 0 and result[i][2] == '*':
            answer[i - 1] *= 2
        answer[i] = int(result[i][0]) ** bonus[result[i][1]] * option[result[i][2]]
    return sum(answer)