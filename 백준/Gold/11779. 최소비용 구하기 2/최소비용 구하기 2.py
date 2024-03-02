import heapq
from sys import stdin
input = stdin.readline
INF = 1e9

n = int(input())
m = int(input())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
start, end = map(int, input().split())
distance = [INF] * (n + 1)
path = [[] for _ in range(n + 1)]

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start, [start]))
    distance[start] = 0
    while q:
        d, now, p = heapq.heappop(q)
        if distance[now] < d:
            continue
        for i in graph[now]:
            cost = d + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                path[i[0]] = p + [i[0]]
                heapq.heappush(q, (cost, i[0], p + [i[0]]))

dijkstra(start)

print(distance[end])
print(len(path[end]))
for p in path[end]:
    print(p, end=' ')