from collections import defaultdict

def solution(id_list, report, k):
    log = defaultdict(set)
    for r in report:
        a, b = r.split()
        log[b].add(a)
    
    result = defaultdict(int)
    for key, value in log.items():
        if len(value) < k:
            continue
        for v in value:
            result[v] += 1
    
    answer = []
    for id in id_list:
        answer.append(result[id])
    return answer