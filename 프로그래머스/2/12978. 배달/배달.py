def solution(N, road, K):
    graph = [[1e9] * (N + 1) for _ in range(N + 1)]
    for i in range(N):
        graph[i][i] = 0
    
    for a, b, c in road:
        graph[a][b] = min(graph[a][b], c)
        graph[b][a] = min(graph[b][a], c)
        
    for k in range(1, N + 1):
        for i in range(1, N + 1):
            for j in range(1, N + 1):
                graph[i][j] = min(graph[i][k] + graph[k][j], graph[i][j])
    return len([d for d in graph[1] if d <= K])