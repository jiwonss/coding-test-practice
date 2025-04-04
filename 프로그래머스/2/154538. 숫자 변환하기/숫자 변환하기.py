from collections import deque

def solution(x, y, n):
    q = deque([x])
    visited = [0] * 1000001
    while q:
        k = q.popleft()
        if k == y:
            return visited[k]
        for v in [k + n, k * 2, k * 3]:
            if not (0 <= v < 1000001) or visited[v]:
                continue
            visited[v] = visited[k] + 1
            q.append(v)
    return -1