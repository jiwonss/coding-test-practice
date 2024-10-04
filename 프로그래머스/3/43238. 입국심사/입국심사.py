from sys import maxsize

def solution(n, times):
    start, end = 0, maxsize
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