from collections import deque

dx, dy = [0, 1, 0, -1], [1, 0, -1, 0]

def solution(maps):
    n, m = len(maps), len(maps[0])
    
    q = deque()
    visited = [[0] * m for _ in range(n)]
    
    q.append([0, 0])
    visited[0][0] = 1
    
    while q:
        x, y = q.popleft()
        if x == n - 1 and y == m - 1:
            return visited[x][y]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if not (0 <= nx < n and 0 <= ny < m):
                continue
            if maps[nx][ny] == 0 or visited[nx][ny]:
                continue
            visited[nx][ny] = visited[x][y] + 1
            q.append([nx, ny])
    return -1