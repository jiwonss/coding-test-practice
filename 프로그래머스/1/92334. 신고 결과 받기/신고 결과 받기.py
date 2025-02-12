from collections import defaultdict

def solution(id_list, report, k):
    report = set(report)
    user_idx = {_id : i for i, _id in enumerate(id_list)}
    
    log = defaultdict(list)
    for r in report:
        a, b = r.split()
        log[b].append(a)
    
    answer = [0] * len(id_list)
    for key, value in log.items():
        if len(value) < k:
            continue
        for v in value:
            answer[user_idx[v]] += 1
    return answer