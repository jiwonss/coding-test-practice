from heapq import heappush, heappop

def solution(operations):
    answer = []
    
    max_q, min_q = [], []
    for operation in operations:
        op, n = operation.split()
        n = int(n)
        if op == 'I':
            heappush(max_q, -n)
            heappush(min_q, n)
        else:
            if not max_q or not min_q:
                continue
            if n == 1:
                min_q.remove(-heappop(max_q))
            else:
                max_q.remove(-heappop(min_q))
            
    if max_q and min_q:
        return [-heappop(max_q), heappop(min_q)]
    return [0, 0]