from sys import stdin
import heapq
input = stdin.readline

t = int(input())
for _ in range(t):
    k = int(input())

    max_heap, min_heap = [], []
    visited = [0] * k
    for i in range(k):
        s, n = input().split()
        if s == 'I':
            heapq.heappush(max_heap, (-int(n), i))
            heapq.heappush(min_heap, (int(n), i))
            visited[i] = 1
        else:
            if n == '1':
                while max_heap and not visited[max_heap[0][1]]:
                    heapq.heappop(max_heap)
                if max_heap:
                    visited[max_heap[0][1]] = 0
                    heapq.heappop(max_heap)
            else:
                while min_heap and not visited[min_heap[0][1]]:
                    heapq.heappop(min_heap)
                if min_heap:
                    visited[min_heap[0][1]] = 0
                    heapq.heappop(min_heap)

    while max_heap and not visited[max_heap[0][1]]:
        heapq.heappop(max_heap)
    while min_heap and not visited[min_heap[0][1]]:
        heapq.heappop(min_heap)
        
    if not max_heap and not min_heap:
        print("EMPTY")
    else:
        print(-max_heap[0][0], min_heap[0][0])