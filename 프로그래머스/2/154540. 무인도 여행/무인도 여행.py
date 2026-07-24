from collections import deque

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]

def solution(maps):
    n, m = len(maps), len(maps[0])
    
    q = deque()
    visited = [[0] * m for _ in range(n)]
    answer = []
    
    for i in range(n):
        for j in range(m):
            if maps[i][j] == 'X' or visited[i][j]:
                continue
            
            q.append([i, j])
            visited[i][j] = 1
            cnt = 0
            
            while q:
                x, y = q.popleft()
                cnt += int(maps[x][y])
                for d in range(4):
                    nx = x + dx[d]
                    ny = y + dy[d]
                    if not (0 <= nx < n and 0 <= ny < m):
                        continue
                    if visited[nx][ny] or maps[nx][ny] == 'X':
                        continue 
                    visited[nx][ny] = 1
                    q.append([nx, ny])
                    
            if cnt > 0:
                answer.append(cnt)
    return sorted(answer) if answer else [-1]