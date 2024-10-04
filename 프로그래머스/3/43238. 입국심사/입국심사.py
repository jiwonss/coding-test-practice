def solution(n, times):
    start, end = 0, times[-1] * n
    while start < end:
        mid = (start + end) // 2
        
        cnt = 0
        for time in times:
            cnt += mid // time
        
        if cnt < n:
            start = mid + 1
        else:
            end = mid
    return end