from heapq import heappush, heappop

def solution(jobs):
    heap = []
    answer = 0
    idx, now, start = 0, 0, -1
    while idx < len(jobs):
        for job in jobs:
            if start < job[0] <= now:
                heappush(heap, (job[1], job[0]))
        if heap:
            x = heappop(heap)
            start = now
            now += x[0]
            answer += now - x[1]
            idx += 1
        else:
            now += 1 
    return answer // idx