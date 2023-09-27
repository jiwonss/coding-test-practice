from sys import stdin
from collections import deque
input = stdin.readline

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]

def bfs():
    while q:
        x, y = q.popleft()
        if board[x][y] == 'S':
            for d in range(4):
                nx = x + dx[d]
                ny = y + dy[d]
                if nx < 0 or nx >= R or ny < 0 or ny >= C:
                    continue
                if board[nx][ny] == 'D':
                    return visited[x][y]
                if not visited[nx][ny] and board[nx][ny] == '.':
                    board[x][y] = '.'
                    board[nx][ny] = 'S'
                    visited[nx][ny] = visited[x][y] + 1
                    q.append([nx, ny])
        if board[x][y] == '*':
            for d in range(4):
                nx = x + dx[d]
                ny = y + dy[d]
                if nx < 0 or nx >= R or ny < 0 or ny >= C:
                    continue
                if board[nx][ny] == '.':
                    board[nx][ny] = '*'
                    q.append([nx, ny])
    return -1

R, C = map(int, input().split())
board = [list(input().strip()) for _ in range(R)]

q = deque()
visited = [[0] * C for _ in range(R)]

for i in range(R):
    for j in range(C):
        if board[i][j] == 'S':
            visited[i][j] = 1
            q.append([i, j])
        if board[i][j] == 'D':
            pass
        if board[i][j] == '*':
            q.appendleft([i, j])

result = bfs()
print(result if result > 0 else "KAKTUS")