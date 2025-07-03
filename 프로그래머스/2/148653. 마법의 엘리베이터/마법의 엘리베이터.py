def solution(storey):
    if storey < 10:
        return min(storey, 11 - storey)
    div, mod = divmod(storey, 10)
    return min(mod + solution(div), 10 - mod + solution(div + 1))