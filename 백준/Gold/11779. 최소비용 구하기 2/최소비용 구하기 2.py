from sys import stdin
from heapq import heappush, heappop

input = stdin.readline
INF = float("inf")


def dijkstra(start):
    heap = []
    heappush(heap, [0, start, [start]])
    distance[start] = 0

    while heap:
        d, node, p = heappop(heap)
        if d > distance[node]:
            continue
        for v in graph[node]:
            cost = d + v[1]
            if cost < distance[v[0]]:
                distance[v[0]] = cost
                path[v[0]] = p + [v[0]]
                heappush(heap, [cost, v[0], p + [v[0]]])


def solve():
    global graph, distance, path

    n = int(input())
    m = int(input())

    graph = [[] for _ in range(n + 1)]
    for _ in range(m):
        a, b, c = map(int, input().split())
        graph[a].append([b, c])

    start, end = map(int, input().split())
    distance, path = [INF] * (n + 1), [[] for _ in range(n + 1)]
    dijkstra(start)

    print(distance[end])
    print(len(path[end]))
    print(*path[end])


if __name__ == "__main__":
    solve()
