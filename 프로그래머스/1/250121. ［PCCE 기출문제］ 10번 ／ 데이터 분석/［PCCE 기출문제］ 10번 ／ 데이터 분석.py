def solution(data, ext, val_ext, sort_by):
    k = {"code" : 0, "date" : 1, "maximum" : 2, "remain" : 3}
    
    answer = []
    for d in data:
        if d[k[ext]] < val_ext:
            answer.append(d)
    return sorted(answer, key=lambda x : x[k[sort_by]])