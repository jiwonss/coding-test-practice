from heapq import heapify, heappush, heappop

def solution(n, works):
    if sum(works) <= n:
        return 0
        
    heap = [-w for w in works]
    heapify(heap)
    
    for _ in range(n):
        heappush(heap, heappop(heap) + 1)
        
    return sum(h * h for h in heap)