from collections import deque

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]

def out_of_bounds(x, y):
    return not (0 <= x < n and 0 <= y < m)

def move(board, x, y, d):
    while True:
        nx = x + dx[d]
        ny = y + dy[d]
        if out_of_bounds(nx, ny) or board[nx][ny] == 'D':
            return [x, y]
        x, y = nx, ny
    
def bfs(board):
    q = deque()
    visited = [[0] * m for _ in range(n)]
    
    sx, sy = start
    
    q.append([sx, sy, 0])
    visited[sx][sy] = 1
    
    while q:
        x, y, cnt = q.popleft()
        for d in range(4):
            nx, ny = move(board, x, y, d)
            if visited[nx][ny]:
                continue
            if board[nx][ny] == 'G':
                return cnt + 1
            visited[nx][ny] = 1
            q.append([nx, ny, cnt + 1])
    return -1

def solution(board):
    global n, m, start

    n, m, start = len(board), len(board[0]), [-1, -1]
    for i in range(n):
        for j in range(m):
            if board[i][j] == 'R':
                start = [i, j]
                break
        if start != [-1, -1]:
            break
    return bfs(board)