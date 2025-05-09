from heapq import heapify, heappush, heappop

def solution(n, k, enemy):
    heap = enemy[:k]
    heapify(heap)

    for i in range(k, len(enemy)):
        heappush(heap, enemy[i])
        n -= heappop(heap)
        if n < 0:
            return i
    return len(enemy)