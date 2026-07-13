from collections import deque

def solution(n, roads, sources, destination):
    graph = {i : [] for i in range(n + 1)}
    for a, b in roads:
        graph[a].append(b)
        graph[b].append(a)
    
    q = deque([destination])
    distance = [-1] * (n + 1)
    distance[destination] = 0
    
    while q:
        x = q.popleft()
        for v in graph[x]:
            if distance[v] == -1:
                q.append(v)
                distance[v] = distance[x] + 1

    return [distance[s] for s in sources]