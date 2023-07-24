from sys import stdin
from collections import defaultdict, deque
input = stdin.readline

def bfs(k, v):
    q.append(v)
    visited[v] = 1
    result = 0
    while q:
        x = q.popleft()
        for a, b in graph[x]:
            if not visited[a] and k <= b:
                visited[a] = 1
                q.append(a)
                result += 1
    return result

N, Q = map(int, input().split())
graph = defaultdict(list)
for _ in range(N - 1):
    p, q, r = map(int , input().split())
    graph[p].append([q, r])
    graph[q].append([p, r])
q = deque()
for _ in range(Q):
    k, v = map(int, input().split())
    visited = [0 for _ in range(N + 1)]
    result = bfs(k, v)
    print(result)