def solution(data, ext, val_ext, sort_by):
    column = {"code" : 0, "date" : 1, "maximum" : 2, "remain" : 3}
    result = [item for item in data if item[column[ext]] < val_ext]
    return sorted(result, key=lambda x : x[column[sort_by]])    
