from collections import defaultdict

def dfs(x):
    visited[x] = 1
    for v in graph[x]:
        if not visited[v]:
            dfs(v)

T = int(input())
for t in range(1, T + 1):
    N, M = map(int, input().split())
    graph = defaultdict(list)
    for _ in range(M):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)
    
    result = 0
    visited = [0] * (N + 1)
    for i in range(1, N + 1):
        if not visited[i]:
            dfs(i)
            result += 1
    print(f'#{t} {result}')