def solution(data, ext, val_ext, sort_by):
    info = {"code" : 0, "date" : 1, "maximum" : 2, "remain" : 3}
    
    result = []
    for d in data:
        if d[info[ext]] < val_ext:
            result.append(d)
    return sorted(result, key=lambda x : x[info[sort_by]])    
