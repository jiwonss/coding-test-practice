def solution(n, stations, w):
    answer = 0
    idx, location = 0, 1
    while location <= n:
        if idx < len(stations) and location >= stations[idx] - w:
            location = stations[idx] + w + 1
            idx += 1
        else:
            location += 2 * w + 1
            answer += 1
    return answer