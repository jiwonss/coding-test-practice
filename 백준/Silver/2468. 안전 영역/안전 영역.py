from sys import stdin
from collections import deque
input = stdin.readline

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs(h):
    q = deque()
    visited = [[0] * n for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):
            if not visited[i][j] and board[i][j] > h:
                visited[i][j] = 1    
                q.append([i, j])
                cnt += 1
                while q:
                    x, y = q.popleft()
                    for d in range(4):
                        nx = x + dx[d]
                        ny = y + dy [d]
                        if nx < 0 or nx >= n or ny < 0 or ny >= n:
                            continue
                        if visited[nx][ny] or board[nx][ny] <= h:
                            continue
                        visited[nx][ny] = 1
                        q.append([nx, ny])
    return cnt

n = int(input())
board = []
max_h = 0
for i in range(n):
    board.append(list(map(int, input().split())))
    max_h = max(max_h, max(board[i]))

result = []
for h in range(max_h + 1):
    result.append(bfs(h))
print(max(result))