from collections import deque

dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]

def out_of_bounds(x, y):
    return not (0 <= x < n and 0 <= y < m)

def move(board, d, x, y):
    while True:
        x += dx[d]
        y += dy[d]
        if out_of_bounds(x, y) or board[x][y] == 'D':
            break
    x -= dx[d]
    y -= dy[d]
    return [x, y]
    
def bfs(board):
    q = deque()
    visited = [[0] * m for _ in range(n)]

    sx, sy = start
    q.append([sx, sy, 0])
    visited[sx][sy] = 1
    
    while q:
        x, y, cnt = q.popleft()
        for d in range(4):
            nx, ny = move(board, d, x, y)
            if visited[nx][ny]:
                continue
            if board[nx][ny] == 'G':
                return cnt + 1
            visited[nx][ny] = 1
            q.append([nx, ny, cnt + 1])
    return -1
    
def solution(board):
    global n, m, start
    
    n, m = len(board), len(board[0])
    
    start = [-1, -1]
    for i in range(n):
        for j in range(m):
            if board[i][j] == 'R':
                start = [i, j]
                break
        if start !=  [-1, -1]:
            break

    return bfs(board)
    
                
            
