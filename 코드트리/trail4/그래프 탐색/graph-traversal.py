n, m = map(int, input().split())
edges = [tuple(map(int, input().split())) for _ in range(m)]

# Please write your code here.
def dfs(n):
    for v in graph[n]:
        if visited[v]:
            continue
        visited[v] = 1
        dfs(v)

graph = {i : [] for i in range(1, n + 1)}
for a, b in edges:
    graph[a].append(b)
    graph[b].append(a)

visited = [0] * (n + 1)
visited[1] = 1
dfs(1)
print(sum(visited) - 1)